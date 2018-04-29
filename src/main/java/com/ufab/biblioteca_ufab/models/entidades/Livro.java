package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String titulo;

	@NotNull
	@NotEmpty
	private String isbn;

	@NotNull
	@NotEmpty
	private String autores;

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
	 * Retorna o valor da variável isbn
	 * 
	 * @return isbn
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * Inicializa a variável isbn com o valor recebido como parâmetro
	 * 
	 * @param isbn
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * Retorna o valor da variável autores
	 * 
	 * @return autores
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getAutores() {
		return autores;
	}

	/**
	 * Inicializa a variável autores com o valor recebido como parâmetro
	 * 
	 * @param autores
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * Retorna o valor da variável editora
	 * 
	 * @return editora
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getEditora() {
		return editora;
	}

	/**
	 * Inicializa a variável editora com o valor recebido como parâmetro
	 * 
	 * @param editora
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEditora(String editora) {
		this.editora = editora;
	}

	/**
	 * Retorna o valor da variável anoDePublicacao
	 * 
	 * @return anoDePublicacao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getAnoDePublicacao() {
		return anoDePublicacao;
	}

	/**
	 * Inicializa a variável anoDePublicacao com o valor recebido como parâmetro
	 * 
	 * @param anoDePublicacao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setAnoDePublicacao(int anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}

	/**
	 * Retorna o valor da variável edicao
	 * 
	 * @return edicao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getEdicao() {
		return edicao;
	}

	/**
	 * Inicializa a variável edicao com o valor recebido como parâmetro
	 * 
	 * @param edicao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	/**
	 * Retorna o valor da variável numeroDePaginas
	 * 
	 * @return numeroDePaginas
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}

	/**
	 * Inicializa a variável numeroDePaginas com o valor recebido como parâmetro
	 * 
	 * @param numeroDePaginas
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	/**
	 * Retorna o valor da variável area
	 * 
	 * @return area
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getArea() {
		return area;
	}

	/**
	 * Inicializa a variável area com o valor recebido como parâmetro
	 * 
	 * @param area
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * Retorna o valor da variável tema
	 * 
	 * @return tema
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * Inicializa a variável tema com o valor recebido como parâmetro
	 * 
	 * @param tema
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoDePublicacao;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + edicao;
		result = prime * result + ((editora == null) ? 0 : editora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + numeroDePaginas;
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
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
		Livro other = (Livro) obj;
		if (anoDePublicacao != other.anoDePublicacao)
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (edicao != other.edicao)
			return false;
		if (editora == null) {
			if (other.editora != null)
				return false;
		} else if (!editora.equals(other.editora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
