package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.ufab.biblioteca_ufab.models.enums.TipoDeCurso;

/**
 * Classe responsável por definir a organização dos dados dos objetos tipo
 * Curso.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	@NotEmpty
	private String area;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeCurso tipo;

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
	 * Retorna o valor da variável nome
	 * 
	 * @return nome
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Inicializa a variável nome com o valor recebido como parâmetro
	 * 
	 * @param nome
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setNome(String nome) {
		this.nome = nome;
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
	 * Retorna o valor da variável tipo
	 * 
	 * @return tipo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public TipoDeCurso getTipo() {
		return tipo;
	}

	/**
	 * Inicializa a variável id com o valor recebido como parâmetro
	 * 
	 * @param id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setTipo(TipoDeCurso tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Curso other = (Curso) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}

}
