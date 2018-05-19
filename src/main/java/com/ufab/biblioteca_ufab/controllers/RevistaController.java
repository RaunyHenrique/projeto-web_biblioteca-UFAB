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
import com.ufab.biblioteca_ufab.models.entidades.Revista;
import com.ufab.biblioteca_ufab.models.enums.TipoDeItemDoAcervo;
import com.ufab.biblioteca_ufab.models.repositorios.RevistaRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo
 * Revista.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Controller
@RequestMapping("/revistas")
public class RevistaController {
	
	static final Logger logger = LoggerFactory.getLogger(RevistaController.class);
	
	@Autowired private RevistaRepositorio revistaRepositorio;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {

		Iterable<Revista> revistas = revistaRepositorio.findAll();

		model.addAttribute("titulo", "Listagem de revistas");
		model.addAttribute("url", "revistas");
		model.addAttribute("revistas", revistas);

		logger.info("Itens listados com sucesso.");
		return "revista/listar";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody // retorna JSON
	public Revista buscarById(@PathVariable Long id) {

		Optional<Revista> revista = revistaRepositorio.findById(id);

		return revista.get();

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute Revista revista, BindingResult bindingResult, Model model) {
				
		if (bindingResult.hasErrors()) {

			System.out.println(bindingResult.getFieldErrors());

			logger.info("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			revista.setItem_tipo(TipoDeItemDoAcervo.REVISTA);
			
			revistaRepositorio.save(revista);
			logger.info("Item salvo com sucesso.");
			
		}

		Iterable<Revista> revistaAll = revistaRepositorio.findAll();

		model.addAttribute("revistas", revistaAll);

		return "revista/table-listar";

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {

		try {

			revistaRepositorio.deleteById(id);
			logger.info("Item deletado com sucesso.");

			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {

			logger.info("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}

}
