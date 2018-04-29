package com.ufab.biblioteca_ufab.models.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo
 * Revista.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class Revista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String titulo;

	@NotNull
	@NotEmpty
	private String editora;

	@NotNull
	private Date dataDePublicacao;

	@NotNull
	private int edicao;

	@NotNull
	private int numeroDePaginas;

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
	 * Retorna o valor da variável dataDePublicacao
	 * 
	 * @return dataDePublicacao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Date getDataDePublicacao() {
		return dataDePublicacao;
	}

	/**
	 * Inicializa a variável dataDePublicacao com o valor recebido como parâmetro
	 * 
	 * @param dataDePublicacao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	public void setDataDePublicacao(Date dataDePublicacao) {
		this.dataDePublicacao = dataDePublicacao;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDePublicacao == null) ? 0 : dataDePublicacao.hashCode());
		result = prime * result + edicao;
		result = prime * result + ((editora == null) ? 0 : editora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + numeroDePaginas;
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
		Revista other = (Revista) obj;
		if (dataDePublicacao == null) {
			if (other.dataDePublicacao != null)
				return false;
		} else if (!dataDePublicacao.equals(other.dataDePublicacao))
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
		if (numeroDePaginas != other.numeroDePaginas)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
