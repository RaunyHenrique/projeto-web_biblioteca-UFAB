package com.ufab.biblioteca_ufab.models.entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(fetch=FetchType.EAGER)
	private Set<ItemDoAcervo> items_emprestados;
	
	@OneToOne
	private Aluno aluno;
	
	@Type(type="boolean")
	private Boolean is_pedente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ItemDoAcervo> getItems_emprestados() {
		return items_emprestados;
	}

	public void setItems_emprestados(Set<ItemDoAcervo> items_emprestados) {
		this.items_emprestados = items_emprestados;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Boolean getIs_pedente() {
		return is_pedente;
	}

	public void setIs_pedente(Boolean is_pedente) {
		this.is_pedente = is_pedente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((is_pedente == null) ? 0 : is_pedente.hashCode());
		result = prime * result + ((items_emprestados == null) ? 0 : items_emprestados.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_pedente == null) {
			if (other.is_pedente != null)
				return false;
		} else if (!is_pedente.equals(other.is_pedente))
			return false;
		if (items_emprestados == null) {
			if (other.items_emprestados != null)
				return false;
		} else if (!items_emprestados.equals(other.items_emprestados))
			return false;
		return true;
	}

}
