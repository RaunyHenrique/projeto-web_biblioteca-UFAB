package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;

import com.ufab.biblioteca_ufab.models.enums.TipoDeAnaisDoCongresso;

/**
 * Classe responsável por definir a organização dos dados dos objetos
 * AnaisDeCongresso.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class AnaisDeCongresso extends ItemDoAcervo {

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeAnaisDoCongresso tipo;

	@NotNull
	@NotEmpty
	private String nomeDoCongresso;

	@NotNull
	private int anoDePublicacao;

	@NotNull
	@NotEmpty
	private String local;

	public TipoDeAnaisDoCongresso getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeAnaisDoCongresso tipo) {
		this.tipo = tipo;
	}

	public String getNomeDoCongresso() {
		return nomeDoCongresso;
	}

	public void setNomeDoCongresso(String nomeDoCongresso) {
		this.nomeDoCongresso = nomeDoCongresso;
	}

	public int getAnoDePublicacao() {
		return anoDePublicacao;
	}

	public void setAnoDePublicacao(int anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + anoDePublicacao;
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((nomeDoCongresso == null) ? 0 : nomeDoCongresso.hashCode());
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
		AnaisDeCongresso other = (AnaisDeCongresso) obj;
		if (anoDePublicacao != other.anoDePublicacao)
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (nomeDoCongresso == null) {
			if (other.nomeDoCongresso != null)
				return false;
		} else if (!nomeDoCongresso.equals(other.nomeDoCongresso))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

}
