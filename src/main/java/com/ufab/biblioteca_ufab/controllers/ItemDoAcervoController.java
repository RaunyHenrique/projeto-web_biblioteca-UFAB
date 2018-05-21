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
import com.ufab.biblioteca_ufab.models.entidades.ItemDoAcervo;
import com.ufab.biblioteca_ufab.models.repositorios.ItemDoAcervoRepositorio;

@Controller
@RequestMapping("/itens-acervo")
public class ItemDoAcervoController {

	static final Logger logger = LoggerFactory.getLogger(ItemDoAcervoController.class);

	@Autowired private ItemDoAcervoRepositorio itemDoAcervoRepositorio;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {

		Iterable<ItemDoAcervo> itens = itemDoAcervoRepositorio.findAll();

		model.addAttribute("titulo", "Listagem de itens do acervo");
		model.addAttribute("url", "itens-acervo");
		model.addAttribute("itens", itens);

		logger.info("Itens listados com sucesso.");
		return "itens_acervo/listar";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody // retorna JSON
	public ItemDoAcervo buscarById(@PathVariable Long id) {

		Optional<ItemDoAcervo> itemDoAcervo = itemDoAcervoRepositorio.findById(id);

		return itemDoAcervo.get();

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute ItemDoAcervo itemDoAcervo, BindingResult bindingResult, Model model) {
				
		if (bindingResult.hasErrors()) {

			System.out.println(bindingResult.getFieldErrors());

			logger.info("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			itemDoAcervoRepositorio.save(itemDoAcervo);
			logger.info("Item salvo com sucesso.");
			
		}

		Iterable<ItemDoAcervo> itemDoAcervoAll = itemDoAcervoRepositorio.findAll();

		model.addAttribute("itens", itemDoAcervoAll);

		return "curso/table-listar";

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {

		try {

			itemDoAcervoRepositorio.deleteById(id);
			logger.info("Item deletado com sucesso.");

			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {

			logger.info("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}

}
