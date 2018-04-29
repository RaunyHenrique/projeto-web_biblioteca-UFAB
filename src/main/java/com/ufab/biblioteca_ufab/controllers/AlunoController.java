package com.ufab.biblioteca_ufab.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ufab.biblioteca_ufab.excecoes.ItemInvalidoException;
import com.ufab.biblioteca_ufab.models.entidades.Aluno;
import com.ufab.biblioteca_ufab.models.entidades.Curso;
import com.ufab.biblioteca_ufab.models.repositorios.AlunoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.CursoRepositorio;

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
	private AlunoRepositorio alunoRepositorio;
	@Autowired
	private CursoRepositorio cursosRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public String listarAlunos(Model model) {

		Iterable<Aluno> alunos = alunoRepositorio.findAll();
		Iterable<Curso> cursos = cursosRepositorio.findAll();

		model.addAttribute("titulo", "Listagem de alunos");
		model.addAttribute("alunos", alunos);
		model.addAttribute("cursos", cursos);

		return "aluno/listar";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String inserirAluno(@Valid @ModelAttribute Aluno aluno, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			
			throw new ItemInvalidoException();

//			Iterable<FieldError> errors = bindingResult.getFieldErrors();
//
//			redirectAttributes.addFlashAttribute("mensagensErro", errors);

		} else {

			alunoRepositorio.save(aluno);
//			redirectAttributes.addFlashAttribute("mensagemSucesso", "Inserido com sucesso.");
		}

		return "redirect:/app/alunos";

	}

	@RequestMapping(method = RequestMethod.PUT)
	public String alterarAluno() {

		return "aluno/alterar";

	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deletarAluno(int ID) {

		return "aluno/deletar/" + ID;

	}

}
