package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class AnaisDeCongresso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String titulo;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeAnaisDoCongresso tipo;

	@NotNull
	@NotEmpty
	private String autores;

	@NotNull
	@NotEmpty
	private String nomeDoCongresso;

	@NotNull
	private int anoDePublicacao;

	@NotNull
	@NotEmpty
	private String local;

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
	 * Retorna o valor da variável tipo
	 * 
	 * @return tipo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public TipoDeAnaisDoCongresso getTipo() {
		return tipo;
	}

	/**
	 * Inicializa a variável tipo com o valor recebido como parâmetro
	 * 
	 * @param tipo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	public void setTipo(TipoDeAnaisDoCongresso tipo) {
		this.tipo = tipo;
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
	 * Retorna o valor da variável nomeDoCongresso
	 * 
	 * @return nomeDoCongresso
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getNomeDoCongresso() {
		return nomeDoCongresso;
	}

	/**
	 * Inicializa a variável nomeDoCongresso com o valor recebido como parâmetro
	 * 
	 * @param nomeDoCongresso
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */

	public void setNomeDoCongresso(String nomeDoCongresso) {
		this.nomeDoCongresso = nomeDoCongresso;
	}

	/**
	 * Retorna o valor da variável anoDePublicacao
	 * 
	 * @return anodePublicacao
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
	 * Retorna o valor da variável local
	 * 
	 * @return local
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * Inicializa a variável local com o valor recebido como parâmetro
	 * 
	 * @param local
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoDePublicacao;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((nomeDoCongresso == null) ? 0 : nomeDoCongresso.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		AnaisDeCongresso other = (AnaisDeCongresso) obj;
		if (anoDePublicacao != other.anoDePublicacao)
			return false;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
