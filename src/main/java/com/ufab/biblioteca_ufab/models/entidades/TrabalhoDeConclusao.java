package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.ufab.biblioteca_ufab.models.enums.TipoDeTrabalhoDeConclusao;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo
 * TrabalhoDeConclusao.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class TrabalhoDeConclusao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String titulo;

	@NotNull
	@NotEmpty
	private String autores;

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
	 * Retorna o valor da variável orientadores
	 * 
	 * @return orientadores
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getOrientadores() {
		return orientadores;
	}

	/**
	 * Inicializa a variável orientadores com o valor recebido como parâmetro
	 * 
	 * @param orientadores
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setOrientadores(String orientadores) {
		this.orientadores = orientadores;
	}

	/**
	 * Retorna o valor da variável tipo
	 * 
	 * @return tipo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public TipoDeTrabalhoDeConclusao getTipo() {
		return tipo;
	}

	/**
	 * Inicializa a variável tipo com o valor recebido como parâmetro
	 * 
	 * @param tipo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setTipo(TipoDeTrabalhoDeConclusao tipo) {
		this.tipo = tipo;
	}

	/**
	 * Retorna o valor da variável anoDeDefesa
	 * 
	 * @return anoDeDefesa
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getAnoDeDefesa() {
		return anoDeDefesa;
	}

	/**
	 * Inicializa a variável anoDeDefesa com o valor recebido como parâmetro
	 * 
	 * @param anoDeDefesa
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setAnoDeDefesa(int anoDeDefesa) {
		this.anoDeDefesa = anoDeDefesa;
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
		result = prime * result + anoDeDefesa;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((orientadores == null) ? 0 : orientadores.hashCode());
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
		TrabalhoDeConclusao other = (TrabalhoDeConclusao) obj;
		if (anoDeDefesa != other.anoDeDefesa)
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
		if (orientadores == null) {
			if (other.orientadores != null)
				return false;
		} else if (!orientadores.equals(other.orientadores))
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
