package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo
 * Funcionario.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
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
	@Column(unique = true)
	private String nome;
		
	@NotNull
	@NotEmpty
	private String endereco;
	
	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String telefone;


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
	 * Retorna o valor da variável cpf
	 * 
	 * @return cpf
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Inicializa a variável cpf com o valor recebido como parâmetro
	 * 
	 * @param cpf
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	/**
	 * Retorna o valor da variável rg
	 * 
	 * @return rg
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	
	public String getRg() {
		return rg;
	}

	/**
	 * Inicializa a variável rg com o valor recebido como parâmetro
	 * 
	 * @param rg
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	

	/**
	 * Retorna o valor da variável naturalidade
	 * 
	 * @return naturalidade
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	public String getNaturalidade() {
		return naturalidade;
	}

	/**
	 * Inicializa a variável naturalidade com o valor recebido como parâmetro
	 * 
	 * @param naturalidade
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	

	/**
	 * Retorna o valor da variável nome
	 * 
	 * @return nome
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	public String getNome() {
		return nome;
	}
	
	/**
	 * Inicializa a variável nome com o valor recebido como parâmetro
	 * 
	 * @param nome
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * Retorna o valor da variável endereco
	 * 
	 * @return endereco
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	
	public String getEndereco() {
		return endereco;
	}
	
	/**
	 * Inicializa a variável endereco com o valor recebido como parâmetro
	 * 
	 * @param endereco
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	/**
	 * Retorna o valor da variável telefone
	 * 
	 * @return telefone
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	
	public String getTelefone() {
		return telefone;
	}
	
	/**
	 * Inicializa a variável telefone com o valor recebido como parâmetro
	 * 
	 * @param telefone
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
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
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

}
