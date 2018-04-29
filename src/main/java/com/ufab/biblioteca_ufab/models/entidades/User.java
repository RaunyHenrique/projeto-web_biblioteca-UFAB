package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.ufab.biblioteca_ufab.models.enums.Role;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo User.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Object user_id;

	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String email;

	@NotNull
	@NotEmpty
	private String senha;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Role role;	

	public Object getUser_id() {
		return user_id;
	}

	public void setUser_id(Object user_id) {
		this.user_id = user_id;
	}

	/**
	 * Retorna o valor da variável id
	 * 
	 * @return id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Inicializa a variável id com o valor recebido como parâmetro
	 * 
	 * @param id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna o valor da variável email
	 * 
	 * @return email
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Inicializa a variável email com o valor recebido como parâmetro
	 * 
	 * @param email
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna o valor da variável senha
	 * 
	 * @return senha
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Inicializa a variável senha com o valor recebido como parâmetro
	 * 
	 * @param senha
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Retorna o valor da variável role
	 * 
	 * @return role
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Inicializa a variável role com o valor recebido como parâmetro
	 * 
	 * @param role
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}
