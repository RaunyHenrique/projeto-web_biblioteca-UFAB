package com.ufab.biblioteca_ufab.models.entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo User.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class User implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4049829707412868936L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String email;

	@NotNull
	@NotEmpty
	private String senha;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Permissao> permissoes;
	
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String cpf;
	
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String rg;
	
	@NotNull
	@NotEmpty
	private String naturalidade;
	
	@NotNull
	@NotEmpty
	private String nome;
		
	@NotNull
	@NotEmpty
	private String endereco;
	
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String telefone;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> permissoes = new ArrayList<GrantedAuthority>();
		
		for (Permissao permissao : getPermissoes()) {
			
			permissoes.add(new SimpleGrantedAuthority(permissao.getNome()));
			
		}
		
		return permissoes;
	}

	/**
	 * Retorna a variavel senha da entidade Aluno
	 * 
	 * @return senha
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public String getPassword() {
		return this.senha;
	}
	/**
	 * Retorna a variavel email da entidade Aluno
	 * 
	 * @return email
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public String getUsername() {
		return this.email;
	}

	/**
	 * Verifica se a conta expirou
	 * 
	 * @return isAccountNonExpired
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * Verifica se a conta está bloqueada
	 * 
	 * @return isAccountNonLocked
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * Verifica se as credenciais estão expiradas
	 * 
	 * @return isCredentialsNonExpired
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * Verifica se a conta está ativa
	 * 
	 * @return isEnabled
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	/**
	 * Retorna a variavel id da entidade Aluno
	 * 
	 * @return id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Inicializa a variavel id da entidade Aluno
	 * 
	 * @param id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna a variavel email da entidade Aluno
	 * 
	 * @return email
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Inicializa a variavel email da entidade Aluno
	 * 
	 * @param email
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna a variavel senha da entidade Aluno
	 * 
	 * @return senha
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Inicializa a variavel senha da entidade Aluno
	 * 
	 * @param senha
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Retorna a variavel permissao da entidade Aluno
	 * 
	 * @return permissao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Set<Permissao> getPermissoes() {
		return permissoes;
	}

	/**
	 * Inicializa a variavel permissao da entidade Aluno
	 * 
	 * @param permissao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}

	/**
	 * Retorna a variavel cpf da entidade Aluno
	 * 
	 * @return cpf
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Inicializa a variavel cpf da entidade Aluno
	 * 
	 * @param cpf
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Retorna a variavel rg da entidade Aluno
	 * 
	 * @return rg
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * Inicializa a variavel rg da entidade Aluno
	 * 
	 * @param rg
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * Retorna a variavel naturalidade da entidade Aluno
	 * 
	 * @return naturalidade
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getNaturalidade() {
		return naturalidade;
	}

	/**
	 * Inicializa a variavel naturalidade da entidade Aluno
	 * 
	 * @param naturalidade
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	/**
	 * Retorna a variavel nome da entidade Aluno
	 * 
	 * @return nome
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Inicializa a variavel nome da entidade Aluno
	 * 
	 * @param nome
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna a variavel endereco da entidade Aluno
	 * 
	 * @return endereco
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Inicializa a variavel endereco da entidade Aluno
	 * 
	 * @param endereco
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Retorna a variavel telefone da entidade Aluno
	 * 
	 * @return telefone
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Inicializa a variavel telefone da entidade Aluno
	 * 
	 * @param telefone
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Retorna a variavel serialVersionUID da entidade Aluno
	 * 
	 * @return serialVersionUID
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Retorna a variavel hashcode da entidade Aluno
	 * 
	 * @return result
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((permissoes == null) ? 0 : permissoes.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Verifica a igualdade de atributos com um objeto recebido como parâmetro
	 * 
	 * @param obj
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (permissoes == null) {
			if (other.permissoes != null)
				return false;
		} else if (!permissoes.equals(other.permissoes))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
