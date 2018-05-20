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

	/**
	 * Retorna a variavel dataDePublicacao da entidade Revista
	 * 
	 * @return dataDePublicacao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}

	/**
	 * Inicializa a variavel dataDePublicacao da entidade Revista
	 * 
	 * @param dataDePublicacao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
	}

	/**
	 * Retorna a variavel edicao da entidade Revista
	 * 
	 * @return edicao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getEdicao() {
		return edicao;
	}

	/**
	 * Inicializa a variavel edicao da entidade Revista
	 * 
	 * @param edicao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	/**
	 * Retorna a variavel numeroDePaginas da entidade Revista
	 * 
	 * @return numeroDePaginas
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	/**
	 * Inicializa a variavel numeroDePaginas da entidade Revista
	 * 
	 * @param numeroDePaginas
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	/**
	 * Retorna a variavel hashcode da entidade Revista
	 * 
	 * @return result
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dataDePublicacao == null) ? 0 : dataDePublicacao.hashCode());
		result = prime * result + edicao;
		result = prime * result + numeroDePaginas;
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
