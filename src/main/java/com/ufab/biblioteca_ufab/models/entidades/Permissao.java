package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Permissao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;

	/**
	 * Retorna a variavel id da entidade Permissao
	 * 
	 * @return id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Long getId() {
		return id;
	}


	/**
	 * Inicializa a variavel id da entidade Permissao
	 * 
	 * @param id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * Retorna a variavel nome da entidade Permissao
	 * 
	 * @return nome
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Inicializa a variavel nome da entidade Permissao
	 * 
	 * @param nome
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * Retorna a variavel hashcode da entidade Permissao
	 * 
	 * @return result
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Permissao other = (Permissao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
