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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + edicao;
		return result;
	}

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
