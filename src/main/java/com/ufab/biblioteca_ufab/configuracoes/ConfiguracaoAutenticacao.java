package com.ufab.biblioteca_ufab.configuracoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ufab.biblioteca_ufab.models.servicos.ServicoAutenticacao;

/**
 * Classe responsável por realizar autenticação e gerenciar permissões de usuários
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */
@Configuration
@EnableWebSecurity
public class ConfiguracaoAutenticacao extends WebSecurityConfigurerAdapter {

	@Autowired private ServicoAutenticacao servicoAutenticacao;
	
	/**
	 * Define o objeto que gerencia os serviços de autenticação e codificação de senha
	 * 
	 * @param auth
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
			.userDetailsService(servicoAutenticacao)
			.passwordEncoder(encoder());
			
	}
	
	/**
	 * Configura o acesso às url's com base na permissão do usuário
	 * 
	 * @param http
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/assets/**").permitAll()
				.antMatchers("/livros/**").hasRole("ADMIN")
				.antMatchers("/jornais/**").hasRole("ADMIN")
				.antMatchers("/anais/**").hasRole("ADMIN")
				.antMatchers("/trabalhos/**").hasRole("ADMIN")
				.antMatchers("/midias/**").hasRole("ADMIN")
				.anyRequest().authenticated()
		.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.loginProcessingUrl("/autenticar")
				.defaultSuccessUrl("/home")
				.failureUrl("/login?error=true")
				.usernameParameter("email")
				.passwordParameter("password")
				
			.and()
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout=true")
					
			.and()
			.rememberMe();
	}
	
	/**
	 * Retorna uma instancia da classe BCryptPasswordEncoder utilizada para criptografar uma senha
	 * 
	 * @return BCryptPasswordEncoder
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Bean
	public BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
	}

}
