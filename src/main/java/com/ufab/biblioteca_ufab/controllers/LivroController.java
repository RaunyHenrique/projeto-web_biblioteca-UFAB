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
import com.ufab.biblioteca_ufab.models.entidades.Autor;
import com.ufab.biblioteca_ufab.models.entidades.Editora;
import com.ufab.biblioteca_ufab.models.entidades.Livro;
import com.ufab.biblioteca_ufab.models.repositorios.AutorRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.EditoraRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.LivroRepositorio;
import com.ufab.biblioteca_ufab.propertyeditors.AutorPropertyEditor;
import com.ufab.biblioteca_ufab.propertyeditors.EditoraPropertyEditor;

/**
 * Classe responsável por manipular as informações dos objetos tipo Livro.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Controller
@RequestMapping("/livros")

public class LivroController {
	
	@Autowired private AutorPropertyEditor autorPropertyEditor;
	@Autowired private EditoraPropertyEditor editoraPropertyEditor;

	@Autowired private LivroRepositorio livroRepositorio;
	@Autowired private AutorRepositorio autorRepositorio;
	@Autowired private EditoraRepositorio editoraRepositorio;
	
	static final Logger logger = LoggerFactory.getLogger(LivroController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {
		
		Iterable<Livro> livros = livroRepositorio.findAll();
		Iterable<Autor> autores = autorRepositorio.findAll();
		Iterable<Editora> editoras = editoraRepositorio.findAll();
		
		model.addAttribute("titulo", "Listagem de livros");
		model.addAttribute("url", "livros");
		
		model.addAttribute("livros", livros);
		model.addAttribute("autores", autores);
		model.addAttribute("editoras", editoras);		
		
		logger.info("Itens listados com sucesso.");			
		return "livro/listar";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute Livro livro, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult.getFieldErrors());
			
			logger.info("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			livroRepositorio.save(livro);
			logger.info("Item salvo com sucesso.");
		}

		Iterable<Livro> livros = livroRepositorio.findAll();
		
		model.addAttribute("livros", livros);
		
		return "livro/table-listar";

	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody//retorna JSON
	public Livro buscarById(@PathVariable Long id) {
		
		Optional<Livro> livro = livroRepositorio.findById(id);

		return livro.get();

	}
	
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
	
	//Registra o PropertyEditor para o curso, logo transforma id's em entidades de Curso
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		
		webDataBinder.registerCustomEditor(Autor.class, autorPropertyEditor);
		webDataBinder.registerCustomEditor(Editora.class, editoraPropertyEditor);
		
	}

}