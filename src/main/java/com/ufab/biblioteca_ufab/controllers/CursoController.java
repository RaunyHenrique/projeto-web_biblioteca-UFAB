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
import com.ufab.biblioteca_ufab.models.entidades.Curso;
import com.ufab.biblioteca_ufab.models.enums.TipoDeCurso;
import com.ufab.biblioteca_ufab.models.repositorios.CursoRepositorio;
import com.ufab.biblioteca_ufab.models.servicos.ServicoCurso;

/**
 * Classe responsável por manipular as informações dos objetos tipo curso.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Controller
@RequestMapping("/cursos")
public class CursoController {

	static final Logger logger = LoggerFactory.getLogger(CursoController.class);

	@Autowired private CursoRepositorio cursoRepositorio;
	
	@Autowired private ServicoCurso servicoCurso;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {

		Iterable<Curso> cursos = cursoRepositorio.findAll();

		model.addAttribute("titulo", "Listagem de cursos");
		model.addAttribute("url", "cursos");
		model.addAttribute("cursos", cursos);
		model.addAttribute("tipo_curso", TipoDeCurso.values());
		
		long cursosCount = cursoRepositorio.count();

		// Seed de cursos
		if (cursosCount == 0) {

			new Thread() {

				@Override
				public void run() {

					servicoCurso.setAllCursos();

				}
			}.start();

		}

		logger.info("Itens listados com sucesso.");
		return "curso/listar";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody // retorna JSON
	public Curso buscarById(@PathVariable Long id) {

		Optional<Curso> curso = cursoRepositorio.findById(id);

		return curso.get();

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute Curso curso, BindingResult bindingResult, Model model) {
				
		if (bindingResult.hasErrors()) {

			System.out.println(bindingResult.getFieldErrors());

			logger.info("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			cursoRepositorio.save(curso);
			logger.info("Item salvo com sucesso.");
			
		}

		Iterable<Curso> cursos = cursoRepositorio.findAll();

		model.addAttribute("cursos", cursos);

		return "curso/table-listar";

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {

		try {

			cursoRepositorio.deleteById(id);
			logger.info("Item deletado com sucesso.");

			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {

			logger.info("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}
	}

}
