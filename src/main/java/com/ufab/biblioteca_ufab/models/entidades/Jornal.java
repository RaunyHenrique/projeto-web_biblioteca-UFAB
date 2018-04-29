package com.ufab.biblioteca_ufab.models.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo
 * Jornal.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class Jornal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	private String titulo;

	@NotNull
	private Date data;

	@NotNull
	private int edicao;

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
	 * Retorna o valor da variável titulo
	 * 
	 * @return titulo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Inicializa a variável titulo com o valor recebido como parâmetro
	 * 
	 * @param titulo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Retorna o valor da variável data
	 * 
	 * @return data
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Inicializa a variável data com o valor recebido como parâmetro
	 * 
	 * @param data
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Retorna o valor da variável edicao
	 * 
	 * @return edicao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getEdicao() {
		return edicao;
	}

	/**
	 * Inicializa a variável edicao com o valor recebido como parâmetro
	 * 
	 * @param edicao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + edicao;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Jornal other = (Jornal) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (edicao != other.edicao)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
