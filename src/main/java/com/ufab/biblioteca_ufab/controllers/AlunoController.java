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
import com.ufab.biblioteca_ufab.models.entidades.Curso;
import com.ufab.biblioteca_ufab.models.enums.TipoDeCurso;
import com.ufab.biblioteca_ufab.models.repositorios.AlunoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.CursoRepositorio;
import com.ufab.biblioteca_ufab.models.servicos.ServicoCurso;
import com.ufab.biblioteca_ufab.propertyeditors.CursoPropertyEditor;


/**
 * Classe responsável por manipular as informações dos objetos tipo aluno.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Controller
@RequestMapping("/alunos")
public class AlunoController {

	static final Logger logger = LoggerFactory.getLogger(AlunoController.class);
	
	@Autowired
	private CursoPropertyEditor cursoPropertyEditor;

	@Autowired private AlunoRepositorio alunoRepositorio;
	@Autowired private CursoRepositorio cursosRepositorio;
	
	@Autowired private ServicoCurso servicoCurso;

	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {

		Iterable<Aluno> alunos = alunoRepositorio.findAll();
		Iterable<Curso> cursos = cursosRepositorio.findAll();
				
		model.addAttribute("titulo", "Listagem de alunos");
		model.addAttribute("url", "alunos");
		model.addAttribute("cursos", cursos);
		model.addAttribute("alunos", alunos);
		model.addAttribute("tipo_curso", TipoDeCurso.values());
		
		logger.info("Itens listados com sucesso.");

		return "aluno/listar";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute Aluno aluno, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult.getFieldErrors());
			
			logger.info("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			alunoRepositorio.save(aluno);
			logger.info("Item salvo com sucesso.");
		}

		Iterable<Aluno> alunos = alunoRepositorio.findAll();
		
		model.addAttribute("alunos", alunos);
		
		return "aluno/table-listar";

	}
	
	//RequestMapping busca view's
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody//retorna JSON
	public Aluno buscarById(@PathVariable Long id) {
		
		Optional<Aluno> aluno = alunoRepositorio.findById(id);

		return aluno.get();

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		
		try {
			
			alunoRepositorio.deleteById(id);
			logger.info("Item deletado com sucesso.");

			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			
			logger.info("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}	

	}
	
	//registra o PropertyEditor para o curso, logo transforma id's em entidades de Curso
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		
		webDataBinder.registerCustomEditor(Curso.class, cursoPropertyEditor);
		
	}

}
