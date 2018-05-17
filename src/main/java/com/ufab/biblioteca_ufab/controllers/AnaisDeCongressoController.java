package com.ufab.biblioteca_ufab.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import com.ufab.biblioteca_ufab.models.entidades.AnaisDeCongresso;
import com.ufab.biblioteca_ufab.models.entidades.Jornal;
import com.ufab.biblioteca_ufab.models.entidades.Livro;
import com.ufab.biblioteca_ufab.models.enums.TipoDeAnaisDoCongresso;
import com.ufab.biblioteca_ufab.models.repositorios.AlunoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.AnaisDeCongressoRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo
 * anaisDeCongresso.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Controller
@RequestMapping("/anais")
public class AnaisDeCongressoController {

	static final Logger logger = LoggerFactory.getLogger(AnaisDeCongressoController.class);

	@Autowired private AnaisDeCongressoRepositorio anaisDeCongressoRepositorio;

	/**
	 * Atribui um título, url e uma lista de anais de congresso e tipos de anais ao modelo que será
	 * redirecionado à view de anais de congresso
	 * 
	 * @param model
	 * @return "anais/listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {
				
		Iterable<AnaisDeCongresso> anais = anaisDeCongressoRepositorio.findAll();
		
		model.addAttribute("titulo", "Listagem de anais de congresso");
		model.addAttribute("url", "anais");
		
		model.addAttribute("tipos",TipoDeAnaisDoCongresso.values());
		model.addAttribute("anais", anais);
		
		logger.info("Itens listados com sucesso.");			
		return "anais/listar";
	}
	
	/**
	 * Persiste um objeto do tipo AnaisDeCongresso recebido como parâmetro
	 * 
	 * @param anaisDeCongresso, bindingResult, model
	 * @return "anais/table-listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute AnaisDeCongresso anaisDeCongresso, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult.getFieldErrors());
			
			logger.info("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			anaisDeCongressoRepositorio.save(anaisDeCongresso);
			logger.info("Item salvo com sucesso.");
		}

		Iterable<AnaisDeCongresso> anais = anaisDeCongressoRepositorio.findAll();
		
		model.addAttribute("anais", anais);
		
		return "anais/table-listar";

	}	

	/**
	 * Realiza uma busca na tabela de anais de congresso com base no id recebido como parâmetro
	 * e retorna um objeto que possua o id buscado
	 * 
	 * @param id
	 * @return "anais"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody//retorna JSON
	public AnaisDeCongresso buscarById(@PathVariable Long id) {
		
		Optional<AnaisDeCongresso> anais = anaisDeCongressoRepositorio.findById(id);

		return anais.get();

	}
	
	/**
	 * Exclui do banco, um objeto do tipo anaisDeCongresso que possua o id recebido como parâmetro
	 * 
	 * @param id
	 * @return ResponseEntity
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		
		try {
			
			anaisDeCongressoRepositorio.deleteById(id);
			logger.info("Item deletado com sucesso.");

			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			
			logger.info("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}	

	}

	
}
