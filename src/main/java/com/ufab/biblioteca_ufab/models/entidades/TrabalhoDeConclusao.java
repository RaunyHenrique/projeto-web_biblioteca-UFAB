package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;

import com.ufab.biblioteca_ufab.models.enums.TipoDeTrabalhoDeConclusao;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo
 * TrabalhoDeConclusao.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class TrabalhoDeConclusao extends ItemDoAcervo {

	@NotNull
	@NotEmpty
	private String orientadores;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeTrabalhoDeConclusao tipo;

	@NotNull
	private int anoDeDefesa;

	@NotNull
	@NotEmpty
	private String local;

	public String getOrientadores() {
		return orientadores;
	}

	public void setOrientadores(String orientadores) {
		this.orientadores = orientadores;
	}

	public TipoDeTrabalhoDeConclusao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeTrabalhoDeConclusao tipo) {
		this.tipo = tipo;
	}

	public int getAnoDeDefesa() {
		return anoDeDefesa;
	}

	public void setAnoDeDefesa(int anoDeDefesa) {
		this.anoDeDefesa = anoDeDefesa;
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
		result = prime * result + anoDeDefesa;
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((orientadores == null) ? 0 : orientadores.hashCode());
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
		TrabalhoDeConclusao other = (TrabalhoDeConclusao) obj;
		if (anoDeDefesa != other.anoDeDefesa)
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (orientadores == null) {
			if (other.orientadores != null)
				return false;
		} else if (!orientadores.equals(other.orientadores))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

}
