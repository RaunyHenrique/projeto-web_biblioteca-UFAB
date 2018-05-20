package com.ufab.biblioteca_ufab.models.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ufab.biblioteca_ufab.models.entidades.User;
import com.ufab.biblioteca_ufab.models.repositorios.UserRepositorio;

/**
 * Classe responsavel por realizar a autenticação de usuários
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */
@Service
public class ServicoAutenticacao implements UserDetailsService {
	
	@Autowired private UserRepositorio userRepositorio;

	/**
	 * Busca um nome de usuário cadastrado no banco
	 * 
	 * @param email
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User emailUser = userRepositorio.findByEmail(email);
		
	    if (emailUser == null) {
	        throw new UsernameNotFoundException("Usu�rio n�o encontrado!");
	    }
		
		//System.out.println("EMAIL: " + emailUser.getEmail());
		
		return emailUser;
		
	}
	
	/**
	 * Retorna um usuário logado no sistema
	 * 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public User getUserLogado() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth == null) {
			
			throw new AuthenticationCredentialsNotFoundException("Usu�rio n�o encontrado!");
			
		} 
		
		UserDetails userlogado = (UserDetails) auth.getPrincipal();
		
		String email = userlogado.getUsername();
		
		return userRepositorio.findByEmail(email);
		
	}

}
