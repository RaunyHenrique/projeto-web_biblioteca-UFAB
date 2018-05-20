package com.ufab.biblioteca_ufab.models.entidades;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import com.ufab.biblioteca_ufab.models.enums.TipoDeMidiaEletronica;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo
 * MidiaEletronica.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class MidiaEletronica extends ItemDoAcervo {

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeMidiaEletronica tipo;

	@NotNull
	private Date dataDeGravacao;

	/**
	 * Retorna a variavel tipo da entidade MidiaEletronica
	 * 
	 * @return tipo 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public TipoDeMidiaEletronica getTipo() {
		return tipo;
	}

	/**
	 * Inicializa a variavel tipo da entidade MidiaEletronica
	 * 
	 * @param tipo 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setTipo(TipoDeMidiaEletronica tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Retorna a variavel dataDeGravacao da entidade MidiaEletronica
	 * 
	 * @return dataDeGravacao 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Date getDataDeGravacao() {
		return dataDeGravacao;
	}

	/**
	 * Inicializa a variavel dataDeGravacao da entidade MidiaEletronica
	 * 
	 * @param dataDeGravacao 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setDataDeGravacao(Date dataDeGravacao) {
		this.dataDeGravacao = dataDeGravacao;
	}

	/**
	 * Retorna a variavel hashcode da entidade MidiaEletronica
	 * 
	 * @return result 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataDeGravacao == null) ? 0 : dataDeGravacao.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MidiaEletronica other = (MidiaEletronica) obj;
		if (dataDeGravacao == null) {
			if (other.dataDeGravacao != null)
				return false;
		} else if (!dataDeGravacao.equals(other.dataDeGravacao))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

}
