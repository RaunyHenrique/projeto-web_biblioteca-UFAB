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

	@Autowired
	private AlunoRepositorio alunoRepositorio;
	@Autowired
	private CursoRepositorio cursosRepositorio;

	@Autowired
	private ServicoCurso servicoCurso;

	/**
	 * Atribui um título, url e uma lista de alunos e cursos cadastrados no banco ao modelo que será
	 * redirecionado à view de aluno
	 * 
	 * @param model
	 * @return "aluno/listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {

		Iterable<Aluno> alunos = alunoRepositorio.findAll();

		model.addAttribute("titulo", "Listagem de alunos");
		model.addAttribute("url", "alunos");
		model.addAttribute("alunos", alunos);
		model.addAttribute("tipo_curso", TipoDeCurso.values());

		long cursosCount = cursosRepositorio.count();

		// Seed de cursos
		if (cursosCount == 0) {

			System.out.println("Sem cursos :(");

			new Thread() {

				@Override
				public void run() {

					servicoCurso.setAllCursos();

				}
			}.start();

		}

		// colocar dentro da thred????
		Iterable<Curso> cursosGraduacao = cursosRepositorio.findByTipo(TipoDeCurso.GRADUACAO);
		model.addAttribute("cursosGraduacao", cursosGraduacao);

		Iterable<Curso> cursosPosGraduacao = cursosRepositorio.findByTipo(TipoDeCurso.POSGRADUACAO);
		model.addAttribute("cursosPosGraduacao", cursosPosGraduacao);

		logger.info("Itens listados com sucesso.");

		return "aluno/listar";

	}

	/**
	 * Persiste um objeto do tipo Aluno recebido como parâmetro
	 * 
	 * @param aluno, bindingResult, model
	 * @return "aluno/table-listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
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

	/**
	 * Realiza uma busca na tabela de alunos com base no id recebido como parâmetro
	 * e retorna um objeto que possua o id buscado
	 * 
	 * @param id
	 * @return "aluno"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody // retorna JSON
	public Aluno buscarById(@PathVariable Long id) {

		Optional<Aluno> aluno = alunoRepositorio.findById(id);

		return aluno.get();

	}

	/**
	 * Exclui do banco, um aluno que possua o id recebido como parâmetro
	 * 
	 * @param id
	 * @return ResponseEntity
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
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

	/**
	 * Registra o PropertyEditor para o curso, transformando id's em entidades de curso
	 * 
	 * @param webDataBinder
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {

		webDataBinder.registerCustomEditor(Curso.class, cursoPropertyEditor);

	}

}
