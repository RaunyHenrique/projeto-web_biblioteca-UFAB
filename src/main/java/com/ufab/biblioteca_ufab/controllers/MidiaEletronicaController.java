package com.ufab.biblioteca_ufab.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ufab.biblioteca_ufab.excecoes.ItemInvalidoException;
import com.ufab.biblioteca_ufab.models.entidades.MidiaEletronica;
import com.ufab.biblioteca_ufab.models.enums.TipoDeItemDoAcervo;
import com.ufab.biblioteca_ufab.models.enums.TipoDeMidiaEletronica;
import com.ufab.biblioteca_ufab.models.repositorios.MidiaEletronicaRepositorio;
import com.ufab.biblioteca_ufab.models.servicos.ServicoMidiaEletronica;

/**
 * Classe responsável por manipular as informações dos objetos tipo
 * MidiaEletronica.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Controller
@RequestMapping("/midias")
public class MidiaEletronicaController {

	static final Logger logger = LoggerFactory.getLogger(MidiaEletronicaController.class);

	@Autowired
	private MidiaEletronicaRepositorio midiaEletronicaRepositorio;

	@Autowired
	private ServicoMidiaEletronica servicoMidiaEletronica;

	/**
	 * Atribui um título, url e uma lista de midias e tipos de midia cadastrados no
	 * banco ao modelo que será redirecionado à view de midia
	 * 
	 * @param model
	 * @return "midia/listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {

		Iterable<MidiaEletronica> midias = servicoMidiaEletronica.findAll();

		model.addAttribute("titulo", "Listagem de midias eletronicas");
		model.addAttribute("url", "midias");

		model.addAttribute("tipos", TipoDeMidiaEletronica.values());
		model.addAttribute("midias", midias);

		logger.info("Itens listados com sucesso.");
		return "midia/listar";
	}

	/**
	 * Persiste um objeto do tipo MidiaEletronica recebido como parâmetro
	 * 
	 * @param midia,
	 *            bindingResult, model
	 * @return "midia/table-listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute MidiaEletronica midia, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {

			System.out.println(bindingResult.getFieldErrors());

			logger.info("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {

			midia.setItem_tipo(TipoDeItemDoAcervo.MIDIAELETRONICA);

			if (midia.getId() == null) {
				
				servicoMidiaEletronica.add(midia);

			} else {

				servicoMidiaEletronica.update(midia);

			}

			logger.info("Item salvo com sucesso.");
		}

		Iterable<MidiaEletronica> midias = midiaEletronicaRepositorio.findAll();

		model.addAttribute("midias", midias);

		return "midia/table-listar";

	}

	/**
	 * Realiza uma busca na tabela de midia eletronica com base no id recebido como
	 * parâmetro e retorna um objeto que possua o id buscado
	 * 
	 * @param id
	 * @return "midia"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody // retorna JSON
	public MidiaEletronica buscarById(@PathVariable Long id) {

		Optional<MidiaEletronica> midia = servicoMidiaEletronica.findById(id);

		return midia.get();
		
	}

	/**
	 * Exclui do banco, um objeto do tipo MidiaEletronica que possua o id recebido
	 * como parâmetro
	 * 
	 * @param id
	 * @return ResponseEntity
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {

		try {
			
			servicoMidiaEletronica.deleteById(id);
			
			logger.info("Item deletado com sucesso.");

			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {

			logger.info("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}

	}

}
