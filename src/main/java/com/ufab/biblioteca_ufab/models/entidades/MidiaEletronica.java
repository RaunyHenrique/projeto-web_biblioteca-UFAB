package com.ufab.biblioteca_ufab.models.entidades;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;

import com.ufab.biblioteca_ufab.models.enums.TipoDeMidiaEletronica;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo
 * MidiaEletronica.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class MidiaEletronica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String titulo;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeMidiaEletronica tipo;

	@NotNull
	private Calendar dataDeGravacao;

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
	 * Retorna o valor da variável tipo
	 * 
	 * @return tipo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public TipoDeMidiaEletronica getTipo() {
		return tipo;
	}

	/**
	 * Inicializa a variável tipo com o valor recebido como parâmetro
	 * 
	 * @param tipo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setTipo(TipoDeMidiaEletronica tipo) {
		this.tipo = tipo;
	}

	/**
	 * Retorna o valor da variável dataDeGravacao
	 * 
	 * @return dataDeGravacao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Calendar getDataDeGravacao() {
		return dataDeGravacao;
	}

	/**
	 * Inicializa a variável dataDeGravacao com o valor recebido como parâmetro
	 * 
	 * @param dataDeGravacao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setDataDeGravacao(Calendar dataDeGravacao) {
		this.dataDeGravacao = dataDeGravacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDeGravacao == null) ? 0 : dataDeGravacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		MidiaEletronica other = (MidiaEletronica) obj;
		if (dataDeGravacao == null) {
			if (other.dataDeGravacao != null)
				return false;
		} else if (!dataDeGravacao.equals(other.dataDeGravacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (tipo != other.tipo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
