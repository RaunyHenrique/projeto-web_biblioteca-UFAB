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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ufab.biblioteca_ufab.excecoes.ItemInvalidoException;
import com.ufab.biblioteca_ufab.models.entidades.Aluno;
import com.ufab.biblioteca_ufab.models.entidades.ItemDoAcervo;
import com.ufab.biblioteca_ufab.models.entidades.Reserva;
import com.ufab.biblioteca_ufab.models.repositorios.AlunoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.ItemDoAcervoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.ReservaRepositorio;
import com.ufab.biblioteca_ufab.propertyeditors.AlunoPropertyEditor;
import com.ufab.biblioteca_ufab.propertyeditors.ItemDoAcervoPropertyEditor;

/**
 * Classe respons�vel por manipular as informações dos objetos tipo Reserva.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Controller
@RequestMapping("/reservas")
public class ReservaController {

	static final Logger logger = LoggerFactory.getLogger(EmprestimoController.class);
	
	@Autowired private AlunoPropertyEditor alunoPropertyEditor;
	
	@Autowired private ItemDoAcervoPropertyEditor itemDoAcervoPropertyEditor;
	
	@Autowired private AlunoRepositorio alunoRepositorio;
	
	@Autowired private ItemDoAcervoRepositorio itemDoAcervoRepositorio;
	
	@Autowired private ReservaRepositorio reservaRepositorio;
	
	/**
	 * Atribui um título, url e uma lista de reservas, alunos e itens do acervo cadastrados no banco ao modelo que será
	 * redirecionado à view de reservas
	 * 
	 * @param model
	 * @return "reserva/listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {

		Iterable<Reserva> reservas = reservaRepositorio.findAll();
		Iterable<Aluno> alunos = alunoRepositorio.findByNaoPendentes();
		Iterable<ItemDoAcervo> itensDoAcervo = itemDoAcervoRepositorio.findAllItensReservados();
				
		model.addAttribute("titulo", "Listagem de Reservas");
		model.addAttribute("url", "reservas");
		model.addAttribute("reservas", reservas);
		model.addAttribute("alunos", alunos);
		model.addAttribute("itensDoAcervo", itensDoAcervo);
		
		logger.info("Itens listados com sucesso.");
		
		return "reserva/listar";

	}

	/**
	 * Persiste um objeto do tipo Reserva recebido como parâmetro
	 * 
	 * @param reserva, bindingResult, model
	 * @return "reserva/table-listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute Reserva reserva, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult.getFieldErrors());
			
			logger.error("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			reservaRepositorio.save(reserva);
			logger.info("Item salvo com sucesso.");
		}

		Iterable<Reserva> reservaAll = reservaRepositorio.findAll();
		
		model.addAttribute("reservas", reservaAll);
		
		return "reserva/table-listar";

	}
	
	/**
	 * Realiza uma busca na tabela de reservas com base no id recebido como parâmetro
	 * e retorna um objeto que possua o id buscado
	 * 
	 * @param id
	 * @return "reserva"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody//retorna JSON
	public Reserva buscarById(@PathVariable Long id) {
		
		Optional<Reserva> reserva = reservaRepositorio.findById(id);

		return reserva.get();

	}
	
	/**
	 * Exclui do banco, um objeto do tipo Reserva que possua o id recebido como parâmetro
	 * 
	 * @param id
	 * @return ResponseEntity
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		
		try {
			
			reservaRepositorio.deleteById(id);
			logger.info("Item deletado com sucesso.");

			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			
			logger.error("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}	

	}
	
	/**
	 * Registra o PropertyEditor para Aluno e ItemDoAcervo, transformando seus id's em entidades
	 * 
	 * @param webDataBinder
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		
		webDataBinder.registerCustomEditor(Aluno.class, alunoPropertyEditor);
		webDataBinder.registerCustomEditor(ItemDoAcervo.class, itemDoAcervoPropertyEditor);
		
	}

}
