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
import com.ufab.biblioteca_ufab.models.entidades.Jornal;
import com.ufab.biblioteca_ufab.models.entidades.Livro;
import com.ufab.biblioteca_ufab.models.repositorios.JornalRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo Jornal.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Controller
@RequestMapping("/jornais")

public class JornalController {

	static final Logger logger = LoggerFactory.getLogger(JornalController.class);

	@Autowired private JornalRepositorio jornalRepositorio;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {
		
		Iterable<Jornal> jornais = jornalRepositorio.findAll();
		
		model.addAttribute("titulo", "Listagem de jornais");
		model.addAttribute("url", "jornais");
		
		model.addAttribute("jornais", jornais);
		
		logger.info("Itens listados com sucesso.");			
		return "jornal/listar";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody//retorna JSON
	public Jornal buscarById(@PathVariable Long id) {
		
		Optional<Jornal> jornal = jornalRepositorio.findById(id);
		
		return jornal.get();

	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute Jornal jornal, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult.getFieldErrors());
			
			logger.info("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			jornalRepositorio.save(jornal);
			logger.info("Item salvo com sucesso.");
		}

		Iterable<Jornal> jornais = jornalRepositorio.findAll();
		
		model.addAttribute("jornais", jornais);
		
		return "jornal/table-listar";

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		
		try {
			
			jornalRepositorio.deleteById(id);
			logger.info("Item deletado com sucesso.");

			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			
			logger.info("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}	
	}
	
	
}
