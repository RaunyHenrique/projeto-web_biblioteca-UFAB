package com.ufab.biblioteca_ufab.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.ufab.biblioteca_ufab.models.entidades.Permissao;
import com.ufab.biblioteca_ufab.models.entidades.User;
import com.ufab.biblioteca_ufab.models.repositorios.PermissaoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.UserRepositorio;
import com.ufab.biblioteca_ufab.propertyeditors.PermissaoPropertyEditor;

/**
 * Classe responsável por manipular as informações dos objetos tipo User.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Controller
@RequestMapping("/funcionarios")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private PermissaoPropertyEditor permissaoPropertyEditor;

	@Autowired private UserRepositorio userRepositorio;
	
	@Autowired private PermissaoRepositorio permissaoRepositorio;

	/**
	 * Atribui um título, url e uma lista de permissoes e usuários cadastrados no banco
	 * ao modelo que será redirecionado à view de funcionarios
	 * 
	 * @param model
	 * @return "funcionario/listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String listar(Model model) {

		Iterable<User> funcionarios = userRepositorio.findAll();
		Iterable<Permissao> permissoes = permissaoRepositorio.findAll();

		model.addAttribute("titulo", "Listagem de funcion�rios");
		model.addAttribute("url", "funcionarios");
		model.addAttribute("funcionarios", funcionarios);
		model.addAttribute("permissoes", permissoes);
		
		long permissoesCount = permissaoRepositorio.count();

		// Seed de permissões
		if (permissoesCount == 0) {

			new Thread() {

				@Override
				public void run() {
					
					Permissao admin = new Permissao();
					admin.setId(1L);
					admin.setNome("ROLE_ADMIN");
					permissaoRepositorio.save(admin);
					
					Permissao operador = new Permissao();
					admin.setId(2L);
					admin.setNome("ROLE_OPERADOR");
					permissaoRepositorio.save(operador);		

				}
			}.start();

		}

		logger.info("Itens listados com sucesso.");

		return "funcionario/listar";

	}
	
	/**
	 * Persiste um objeto do tipo User recebido como parâmetro
	 * 
	 * @param user, bindingResult, model
	 * @return "funcionario/table-listar"
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {

			System.out.println(bindingResult.getFieldErrors());

			logger.info("Erro ao salvar item.");
			throw new ItemInvalidoException();

		} else {
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			
			if (user.getId() == null) {//create
				
				user.setSenha(passwordEncoder.encode(user.getSenha()));
				
			} else {//update
				
				Optional<User> senhaAntiga = userRepositorio.findById(user.getId());
				
				if (senhaAntiga.isPresent()) {
					
					if (user.getSenha().equals(senhaAntiga.get().getSenha())) {
						
						//faz nada
						
					} else {
						
						user.setSenha(passwordEncoder.encode(user.getSenha()));
						
					}
					
				}
				
			}
			
			userRepositorio.save(user);
			logger.info("Item salvo com sucesso.");

		}

		Iterable<User> funcionarios = userRepositorio.findAll();
		model.addAttribute("funcionarios", funcionarios);

		return "funcionario/table-listar";

	}
	
	/**
	 * Realiza uma busca na tabela de usuarios com base no id recebido como parâmetro
	 * e retorna um objeto que possua o id buscado
	 * 
	 * @param id
	 * @return user
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody // retorna JSON
	public User buscarById(@PathVariable Long id) {

		Optional<User> user = userRepositorio.findById(id);

		return user.get();

	}
	
	/**
	 * Exclui do banco, um usuário que possua o id recebido como parâmetro
	 * 
	 * @param id
	 * @return ResponseEntity
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deletar(@PathVariable Long id) {

		try {

			userRepositorio.deleteById(id);
			logger.info("Item deletado com sucesso.");

			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {

			logger.info("Erro ao deletar item.");
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}

	}
	
	/**
	 * Registra o PropertyEditor para permissao, transformando id's em entidades de
	 * permissao
	 * 
	 * @param webDataBinder
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {

		webDataBinder.registerCustomEditor(Permissao.class, permissaoPropertyEditor);

	}

}
