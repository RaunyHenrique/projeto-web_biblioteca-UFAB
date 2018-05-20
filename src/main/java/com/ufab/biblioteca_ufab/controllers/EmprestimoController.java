package com.ufab.biblioteca_ufab.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ufab.biblioteca_ufab.excecoes.ItemInvalidoException;
import com.ufab.biblioteca_ufab.models.entidades.Aluno;
import com.ufab.biblioteca_ufab.models.entidades.Emprestimo;
import com.ufab.biblioteca_ufab.models.entidades.ItemDoAcervo;
import com.ufab.biblioteca_ufab.models.entidades.Reserva;
import com.ufab.biblioteca_ufab.models.repositorios.AlunoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.EmprestimoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.ItemDoAcervoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.ReservaRepositorio;
import com.ufab.biblioteca_ufab.propertyeditors.AlunoPropertyEditor;
import com.ufab.biblioteca_ufab.propertyeditors.ItemDoAcervoPropertyEditor;


/**
 * Classe responsavel por manipular as informacoes dos objetos tipo Emprestimo.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */
@Controller
@RequestMapping("/home")
public class EmprestimoController {

	static final Logger logger = LoggerFactory.getLogger(EmprestimoController.class);
	
	@Autowired private AlunoPropertyEditor alunoPropertyEditor;
	
	@Autowired private ItemDoAcervoPropertyEditor itemDoAcervoPropertyEditor;

	@Autowired private EmprestimoRepositorio emprestimoRepositorio;
	
	@Autowired private AlunoRepositorio alunoRepositorio;
	
	@Autowired private ItemDoAcervoRepositorio itemDoAcervoRepositorio;
	
	@Autowired private ReservaRepositorio reservaRepositorio;
	
	/**
	 * Atribui um título, url e uma lista de emprestimos, alunos e itens do acervo cadastrados no banco ao modelo que será
	 * redirecionado à view de reservas
	 * 
	 * @param model
	 * @return "emprestimo/listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model, @RequestParam(value = "get_table", required = false)
    Boolean get_table) {

		Iterable<Emprestimo> emprestimos = emprestimoRepositorio.findAll();
		Iterable<Aluno> alunos = alunoRepositorio.findByNaoPendentes();
		Iterable<ItemDoAcervo> itensDoAcervo = itemDoAcervoRepositorio.findAllItensDisponiveis();
				
		model.addAttribute("titulo", "Listagem de Emprestimos");
		model.addAttribute("url", "home");
		model.addAttribute("emprestimos", emprestimos);
		model.addAttribute("alunos", alunos);
		model.addAttribute("itensDoAcervo", itensDoAcervo);
		
		logger.info("Itens listados com sucesso.");
		
		if (get_table != null) {
						
			return "emprestimo/table-listar";
			
		}
		
		return "emprestimo/listar";
		
	}

	/**
	 * Persiste um objeto do tipo Emprestimo recebido como parâmetro
	 * 
	 * @param emprestimo, bindingResult, model
	 * @return "emprestimo/table-listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute Emprestimo emprestimo, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult.getFieldErrors());
			
			logger.error("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			System.out.println(emprestimo.getItems_emprestados());
			
			for (ItemDoAcervo item : emprestimo.getItems_emprestados()) {
				
				System.out.println(item.getTitulo());
				
			}
					
			//checa data
			if (emprestimo.getData_devolucao().before(emprestimo.getData_emprestimo())) {
				
				throw new ItemInvalidoException();
				
			}
			
			long totalDeDiasDoEmprestimo = diferencaDeDias(emprestimo);
			
			long MAX_DIAS_EMPRESTIMO_GRADUACAO = 15;
			long MAX_DIAS_EMPRESTIMO_POSGRADUACAO = 30;
			
			//checa gradua��o do aluno
			switch (emprestimo.getAluno().getTipo_curso()) {
			
				case GRADUACAO:
					
					if (totalDeDiasDoEmprestimo > MAX_DIAS_EMPRESTIMO_GRADUACAO) {
						
						throw new ItemInvalidoException();
						
					}
					
					break;
	
				case POSGRADUACAO:
					
					if (totalDeDiasDoEmprestimo > MAX_DIAS_EMPRESTIMO_POSGRADUACAO) {
						
						throw new ItemInvalidoException();
						
					}
					
					break;
				
			}
			
			//subtrai do acervo
			if (emprestimo.getId() == null) {//remover???
				
				if (emprestimo.getItems_emprestados() != null) {
					
					for (ItemDoAcervo item : emprestimo.getItems_emprestados()) {
						
						if (item.getQuantidade_emprestada() < item.getQuantidade()) {
							
							item.setQuantidade_emprestada(item.getQuantidade_emprestada() + 1);

						}
						
					}
					
					itemDoAcervoRepositorio.saveAll(emprestimo.getItems_emprestados());
					
				} else {
					
					throw new ItemInvalidoException();

				}
				
			} 
						
			//antes de salvar, verificar se h� alguma pendencia!
			emprestimoRepositorio.save(emprestimo);
			logger.info("Item salvo com sucesso.");
		}

		Iterable<Emprestimo> emprestimoAll = emprestimoRepositorio.findAll();
		
		model.addAttribute("emprestimos", emprestimoAll);
		
		return "emprestimo/table-listar";

	}
	
	/**
	 * Retorna os dias passados desde o cadastro de um emprestimo
	 * 
	 * @return dt
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	private long diferencaDeDias(Emprestimo emprestimo) {

		try {
			
	        Calendar dataAtual = Calendar.getInstance();
	        Integer ano = dataAtual.get(Calendar.YEAR);
	        Integer mes = dataAtual.get(Calendar.MONTH);
	        Integer dia = dataAtual.get(Calendar.DAY_OF_MONTH);
	        mes += 1;
			
		     DateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
		        df.setLenient(false);
		        java.util.Date d1 = (java.util.Date) df.parse(ano + "-" + mes + "-" + dia);
		        System.out.println (d1);
		        
		        java.util.Date d2 = (java.util.Date) df.parse("" + emprestimo.getData_devolucao());
		        System.out.println (d2);
		        long dt = (d2.getTime() - d1.getTime());
		        System.out.println (dt / 86400000L);

		        return (dt / 86400000L);
			
		} catch (Exception e) {
			throw new ItemInvalidoException();
		}

	}

	/**
	 * Realiza uma busca na tabela de emprestimos com base no id recebido como parâmetro
	 * e retorna um objeto que possua o id buscado
	 * 
	 * @param id
	 * @return "emprestimo"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody//retorna JSON
	public Emprestimo buscarById(@PathVariable Long id) {
		
		Optional<Emprestimo> emprestimo = emprestimoRepositorio.findById(id);

		return emprestimo.get();

	}
	
	/**
	 * Atribui um título, url e uma lista de pendencias e itens do acervo cadastrados no banco ao modelo que será
	 * redirecionado à view de pendencias
	 * 
	 * @param model
	 * @return "pendencia/listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pendencias")
	public String listarPendencias(Model model) {
		
		Iterable<Emprestimo> pendencias = emprestimoRepositorio.findAllPendencias();
		Iterable<ItemDoAcervo> itensDoAcervo = itemDoAcervoRepositorio.findAll();
		Double VALOR_MULTA = 0.50;
		
		model.addAttribute("titulo", "Listagem de Pend�ncias");
		model.addAttribute("url", "pendencias");
		model.addAttribute("pendencias", pendencias);
		model.addAttribute("itensDoAcervo", itensDoAcervo);
		model.addAttribute("multa", VALOR_MULTA);

		return "pendencia/listar";

	}
	
	/**
	 * Realiza uma busca na tabela de emprestimos com base no id recebido como parâmetro
	 * e retorna um objeto que possua o id buscado
	 * 
	 * @param id
	 * @return "emprestimo"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/pendencias/{id}")
	@ResponseBody//retorna JSON
	public Emprestimo buscarPendenciaById(@PathVariable Long id) {
		
		Optional<Emprestimo> emprestimo = emprestimoRepositorio.findById(id);

		return emprestimo.get();

	}
	
	/**
	 * Realiza uma busca na tabela de emprestimos com base no id recebido como parâmetro
	 * para finaliza-lo
	 * 
	 * @param id
	 * @return "emprestimo/table-listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/{id}/finalizar")
	public String finalizarEmprestimo(@PathVariable Long id, Model model) {
		
		try {
			
			Optional<Emprestimo> emprestimo = emprestimoRepositorio.findById(id);

			if (emprestimo.isPresent()) {
				
				//quita emprestimo
				emprestimo.get().setIs_pendente(false);
				
				for (ItemDoAcervo item : emprestimo.get().getItems_emprestados()) {
					
					item.setQuantidade_emprestada(item.getQuantidade_emprestada() - 1);
					
				}
				
				itemDoAcervoRepositorio.saveAll(emprestimo.get().getItems_emprestados());
				
				emprestimoRepositorio.save(emprestimo.get());
				logger.info("Emprestimo finalizado com sucesso.");

				Iterable<Emprestimo> emprestimos = emprestimoRepositorio.findAll();
				model.addAttribute("emprestimos", emprestimos);
				
				return "emprestimo/table-listar";
				
			} else {

				logger.error("Erro: Item n�o encontrado.");
				throw new ItemInvalidoException();
				
			}
			
		} catch (Exception e) {
			
			logger.error("Erro ao finalizar emprestimo.");
			throw new ItemInvalidoException();
			
		}	
		
	}
	
	/**
	 * Realiza uma busca na tabela de emprestimos com base no id recebido como parâmetro
	 * para renova-lo
	 * 
	 * @param id
	 * @return "emprestimo/table-listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/{id}/renovar")
	public ResponseEntity<String> renovarEmprestimo(@PathVariable Long id) {
		
		try {
			
			Optional<Emprestimo> emprestimo = emprestimoRepositorio.findById(id);
			
			if (emprestimo.isPresent()) {
				
				for (ItemDoAcervo item : emprestimo.get().getItems_emprestados()) {
					
					//verifica disponibilidade, se houver uma reserva do item, n�o podera efetuar renova��o
					Optional<Reserva> is_indisponivel = reservaRepositorio.findByIdItemReserva(item.getId());
					
					if (is_indisponivel.isPresent()) {//is_indisponivel != null
						
						throw new Exception();
						
					}
					
				}
				
				logger.info("� possivel renovar o emprestimo.");

				return new ResponseEntity<String>(HttpStatus.OK);
				
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			
			logger.error("N�o � possivel renovar o emprestimo.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}	

	}
	
	/**
	 * Realiza uma busca na tabela de emprestimos com base no id recebido como parâmetro
	 * para quitação de um emprestimo pendente
	 * 
	 * @param id
	 * @return "pendencia/table-listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/pendencias/{id}/quitar")
	public String quitarPendencia(@PathVariable Long id, Model model) {
		
		try {
			
			Optional<Emprestimo> emprestimo = emprestimoRepositorio.findById(id);

			if (emprestimo.isPresent()) {
				
				//quita emprestimo
				emprestimo.get().setIs_pendente(false);
				
				//atualiza acervo
				for (ItemDoAcervo item : emprestimo.get().getItems_emprestados()) {
					
					item.setQuantidade_emprestada(item.getQuantidade_emprestada() - 1);
					
				}
				
				itemDoAcervoRepositorio.saveAll(emprestimo.get().getItems_emprestados());
				
				emprestimoRepositorio.save(emprestimo.get());
				logger.info("Pend�ncia quitada com sucesso.");

				Iterable<Emprestimo> pendencias = emprestimoRepositorio.findAllPendencias();
				model.addAttribute("pendencias", pendencias);
				
				return "pendencia/table-listar";
				
			} else {

				logger.error("Erro: Item n�o encontrado.");
				throw new ItemInvalidoException();
				
			}
			
		} catch (Exception e) {
			
			logger.error("Erro ao quitar item.");
			throw new ItemInvalidoException();
			
		}	
		
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

	/**
	 * Exclui do banco, um objeto do tipo emprestimo que possua o id recebido como parâmetro
	 * 
	 * @param id
	 * @return ResponseEntity
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {
		
		try {
			
			Optional<Emprestimo> emprestimo = emprestimoRepositorio.findById(id);
			
			if (emprestimo.isPresent()) {
				
				for (ItemDoAcervo item : emprestimo.get().getItems_emprestados()) {
					
					item.setQuantidade_emprestada(item.getQuantidade_emprestada() - 1);
					
				}
				
				itemDoAcervoRepositorio.saveAll(emprestimo.get().getItems_emprestados());
				
				emprestimoRepositorio.deleteById(id);
				logger.info("Item deletado com sucesso.");

				return new ResponseEntity<String>(HttpStatus.OK);
				
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			
			logger.error("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}	

	}
	
	/**
	 * Exclui do banco, um objeto do tipo Emprestimo pendente que possua o id recebido como parâmetro
	 * 
	 * @param id
	 * @return ResponseEntity
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/pendencias/{id}")
	public ResponseEntity<String> deletarPendencia(@PathVariable Long id) {
		
		try {
			
			Optional<Emprestimo> emprestimo = emprestimoRepositorio.findById(id);
			
			if (emprestimo.isPresent()) {
				
				for (ItemDoAcervo item : emprestimo.get().getItems_emprestados()) {
					
					item.setQuantidade_emprestada(item.getQuantidade_emprestada() - 1);
					
				}
				
				itemDoAcervoRepositorio.saveAll(emprestimo.get().getItems_emprestados());
				
				emprestimoRepositorio.deleteById(id);
				logger.info("Item deletado com sucesso.");

				return new ResponseEntity<String>(HttpStatus.OK);
				
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			
			logger.error("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}	

	}
	
	/**
	 * Registra o PropertyEditor para Aluno e ItemDoAcervo, transformando seus id's em entidades
	 * 
	 * @param webDataBinder
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		
		webDataBinder.registerCustomEditor(Aluno.class, alunoPropertyEditor);
		webDataBinder.registerCustomEditor(ItemDoAcervo.class, itemDoAcervoPropertyEditor);
		
	}

}
