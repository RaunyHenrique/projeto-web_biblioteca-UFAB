package com.ufab.biblioteca_ufab.models.entidades;

import java.sql.Date;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo
 * Revista.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class Revista extends ItemDoAcervo {

	@NotNull
	private Date dataDePublicacao;

	@NotNull
	private int edicao;

	@NotNull
	private int numeroDePaginas;

	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}

	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataDePublicacao == null) ? 0 : dataDePublicacao.hashCode());
		result = prime * result + edicao;
		result = prime * result + numeroDePaginas;
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
		Revista other = (Revista) obj;
		if (dataDePublicacao == null) {
			if (other.dataDePublicacao != null)
				return false;
		} else if (!dataDePublicacao.equals(other.dataDePublicacao))
			return false;
		if (edicao != other.edicao)
			return false;
		if (numeroDePaginas != other.numeroDePaginas)
			return false;
		return true;
	}

}
