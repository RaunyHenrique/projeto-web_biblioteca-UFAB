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
import com.ufab.biblioteca_ufab.models.entidades.Livro;
import com.ufab.biblioteca_ufab.models.enums.TipoDeItemDoAcervo;
import com.ufab.biblioteca_ufab.models.repositorios.LivroRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo Livro.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Controller
@RequestMapping("/livros")

public class LivroController {
		
	static final Logger logger = LoggerFactory.getLogger(LivroController.class);
	
	@Autowired private LivroRepositorio livroRepositorio;

	/**
	 * Atribui um título, url e uma lista de livros, autores e editoras cadastrados no banco ao modelo que será
	 * redirecionado à view de livros
	 * 
	 * @param model
	 * @return "livro/listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {
		
		Iterable<Livro> livros = livroRepositorio.findAll();
		
		model.addAttribute("titulo", "Listagem de livros");
		model.addAttribute("url", "livros");
		
		model.addAttribute("livros", livros);
		
		logger.info("Itens listados com sucesso.");			
		return "livro/listar";
	}
	
	/**
	 * Persiste um objeto do tipo Livro recebido como parâmetro
	 * 
	 * @param livro, bindingResult, model
	 * @return "livro/table-listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute Livro livro, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult.getFieldErrors());
			
			logger.info("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			livro.setItem_tipo(TipoDeItemDoAcervo.LIVRO);
			
			livroRepositorio.save(livro);
			logger.info("Item salvo com sucesso.");
		}

		Iterable<Livro> livros = livroRepositorio.findAll();
		
		model.addAttribute("livros", livros);
		
		return "livro/table-listar";

	}

	/**
	 * Realiza uma busca na tabela de livros com base no id recebido como parâmetro
	 * e retorna um objeto que possua o id buscado
	 * 
	 * @param id
	 * @return livro
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody//retorna JSON
	public Livro buscarById(@PathVariable Long id) {
		
		Optional<Livro> livro = livroRepositorio.findById(id);

		return livro.get();

	}
	
	/**
	 * Exclui do banco, um objeto do tipo Livro que possua o id recebido como parâmetro
	 * 
	 * @param id
	 * @return ResponseEntity
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		
		try {
			
			livroRepositorio.deleteById(id);
			logger.info("Item deletado com sucesso.");

			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			
			logger.info("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}	

	}
	
	/**
	 * Registra o PropertyEditor para Autor e Editora, transformando seus id's em entidades
	 * 
	 * @param webDataBinder
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		
		
		
	}

}