package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.NotEmpty;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo
 * Livro.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class Livro extends ItemDoAcervo {

	@NotNull
	@NotEmpty
	private String isbn;

	@NotNull
	@NotEmpty
	private String editora;

	@NotNull
	private int anoDePublicacao;

	@NotNull
	private int edicao;

	@NotNull
	private int numeroDePaginas;

	@NotNull
	@NotEmpty
	private String area;

	@NotNull
	@NotEmpty
	private String tema;

	/**
	 * Retorna a variavel isbn da entidade Livro
	 * 
	 * @return isbn 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Inicializa a variavel isbn da entidade Livro
	 * 
	 * @param isbn 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Retorna a variavel editora da entidade Livro
	 * 
	 * @return editora 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getEditora() {
		return editora;
	}

	/**
	 * Inicializa a variavel editora da entidade Livro
	 * 
	 * @param editora 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEditora(String editora) {
		this.editora = editora;
	}

	/**
	 * Retorna a variavel anoDePublicacao da entidade Livro
	 * 
	 * @return anoDePublicacao 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getAnoDePublicacao() {
		return anoDePublicacao;
	}

	/**
	 * Inicializa a variavel anoDePublicacao da entidade Livro
	 * 
	 * @param anoDePublicacao 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setAnoDePublicacao(int anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}

	/**
	 * Retorna a variavel edicao da entidade Livro
	 * 
	 * @return edicao 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getEdicao() {
		return edicao;
	}
	
	/**
	 * Inicializa a variavel edicao da entidade Livro
	 * 
	 * @param edicao 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	/**
	 * Retorna a variavel numeroDePaginas da entidade Livro
	 * 
	 * @return numeroDePaginas 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	/**
	 * Inicializa a variavel numeroDePaginas da entidade Livro
	 * 
	 * @param numeroDePaginas 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	/**
	 * Retorna a variavel area da entidade Livro
	 * 
	 * @return area 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getArea() {
		return area;
	}

	/**
	 * Inicializa a variavel area da entidade Livro
	 * 
	 * @param area 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * Retorna a variavel tema da entidade Livro
	 * 
	 * @return tema 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * Inicializa a variavel tema da entidade Livro
	 * 
	 * @param tema 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}

	/**
	 * Retorna a variavel hashcode da entidade Livro
	 * 
	 * @return result 
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + anoDePublicacao;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + edicao;
		result = prime * result + ((editora == null) ? 0 : editora.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + numeroDePaginas;
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
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
		Livro other = (Livro) obj;
		if (anoDePublicacao != other.anoDePublicacao)
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (edicao != other.edicao)
			return false;
		if (editora == null) {
			if (other.editora != null)
				return false;
		} else if (!editora.equals(other.editora))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (numeroDePaginas != other.numeroDePaginas)
			return false;
		if (tema == null) {
			if (other.tema != null)
				return false;
		} else if (!tema.equals(other.tema))
			return false;
		return true;
	}

}
