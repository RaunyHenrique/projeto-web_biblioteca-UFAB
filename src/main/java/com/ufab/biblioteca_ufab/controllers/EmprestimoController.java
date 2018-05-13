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
import com.ufab.biblioteca_ufab.models.entidades.Emprestimo;
import com.ufab.biblioteca_ufab.models.entidades.ItemDoAcervo;
import com.ufab.biblioteca_ufab.models.repositorios.AlunoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.EmprestimoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.ItemDoAcervoRepositorio;
import com.ufab.biblioteca_ufab.propertyeditors.AlunoPropertyEditor;
import com.ufab.biblioteca_ufab.propertyeditors.CursoPropertyEditor;
import com.ufab.biblioteca_ufab.propertyeditors.ItemDoAcervoPropertyEditor;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

	static final Logger logger = LoggerFactory.getLogger(EmprestimoController.class);
	
	@Autowired private AlunoPropertyEditor alunoPropertyEditor;
	
	@Autowired private ItemDoAcervoPropertyEditor itemDoAcervoPropertyEditor;

	@Autowired private EmprestimoRepositorio emprestimoRepositorio;
	
	@Autowired private AlunoRepositorio alunoRepositorio;
	
	@Autowired private ItemDoAcervoRepositorio itemDoAcervoRepositorio;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {

		Iterable<Emprestimo> emprestimos = emprestimoRepositorio.findAll();
		Iterable<Aluno> alunos = alunoRepositorio.findAll();
		Iterable<ItemDoAcervo> itensDoAcervo = itemDoAcervoRepositorio.findAll();
				
		model.addAttribute("titulo", "Listagem de Emprestimos");
		model.addAttribute("url", "emprestimos");
		model.addAttribute("emprestimos", emprestimos);
		model.addAttribute("alunos", alunos);
		model.addAttribute("itensDoAcervo", itensDoAcervo);
		
		logger.info("Itens listados com sucesso.");
		
		return "emprestimo/listar";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute Emprestimo emprestimo, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult.getFieldErrors());
			
			logger.error("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			emprestimoRepositorio.save(emprestimo);
			logger.info("Item salvo com sucesso.");
		}

		Iterable<Emprestimo> emprestimoAll = emprestimoRepositorio.findAll();
		
		model.addAttribute("emprestimos", emprestimoAll);
		
		return "emprestimo/table-listar";

	}
	
	//RequestMapping busca view's
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody//retorna JSON
	public Emprestimo buscarById(@PathVariable Long id) {
		
		Optional<Emprestimo> emprestimo = emprestimoRepositorio.findById(id);

		return emprestimo.get();

	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/alunos")
//	@ResponseBody//retorna JSON
//	public List<SelectItem> getAlunos() {
//		
//		List<SelectItem> selectItems = new ArrayList<SelectItem>();
//		Iterable<Aluno> alunos = alunoRepositorio.findAll();
//				
//		for (Iterator<Aluno> iterator = alunos.iterator(); iterator.hasNext();) {
//			
//			Aluno aluno = (Aluno) iterator.next();
//			
//			SelectItem si = new SelectItem();
//			si.id = aluno.getId();
//			si.text = aluno.getMatricula() + " - " + aluno.getNome();
//			
//			selectItems.add(si);
//						
//		}
//
//		return selectItems;
//
//	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		
		try {
			
			emprestimoRepositorio.deleteById(id);
			logger.info("Item deletado com sucesso.");

			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception e) {
			
			logger.error("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}	

	}
	
	//Registra o PropertyEditor para o aluno, logo transforma id's em entidades de Aluno
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		
		webDataBinder.registerCustomEditor(Aluno.class, alunoPropertyEditor);
		webDataBinder.registerCustomEditor(ItemDoAcervo.class, itemDoAcervoPropertyEditor);
		
	}

}
