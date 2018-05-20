package com.ufab.biblioteca_ufab.models.entidades;

import java.sql.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo
 * Jornal.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class Jornal extends ItemDoAcervo {

	@NotNull
	private Date data;

	@NotNull
	private int edicao;

	/**
	 * Retorna a variavel data da entidade Jornal
	 * 
	 * @return data 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Inicializa a variavel data da entidade Jornal
	 * 
	 * @param data 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Retorna a variavel edicao da entidade Jornal
	 * 
	 * @return edicao 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getEdicao() {
		return edicao;
	}

	/**
	 * Inicializa a variavel edicao da entidade Jornal
	 * 
	 * @param edicao 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	/**
	 * Retorna a variavel hashcode da entidade Jornal
	 * 
	 * @return result 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + edicao;
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
		Jornal other = (Jornal) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (edicao != other.edicao)
			return false;
		return true;
	}

}
