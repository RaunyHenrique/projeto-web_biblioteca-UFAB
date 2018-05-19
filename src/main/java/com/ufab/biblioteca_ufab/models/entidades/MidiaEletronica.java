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

	public TipoDeMidiaEletronica getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeMidiaEletronica tipo) {
		this.tipo = tipo;
	}

	public Date getDataDeGravacao() {
		return dataDeGravacao;
	}

	public void setDataDeGravacao(Date dataDeGravacao) {
		this.dataDeGravacao = dataDeGravacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataDeGravacao == null) ? 0 : dataDeGravacao.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
