package com.ufab.biblioteca_ufab.models.entidades;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private Boolean is_pendente = true;
	
	@NotNull
	private Date data_emprestimo;
	
	@NotNull
	private Date data_devolucao;

	/**
	 * Retorna a variável id da entidade Emprestimo
	 * 
	 * @return id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Inicializa a variável id da entidade Emprestimo
	 * 
	 * @param id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Retorna a variável items_emprestados da entidade Emprestimo
	 * 
	 * @return items_emprestados
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Set<ItemDoAcervo> getItems_emprestados() {
		return items_emprestados;
	}

	/**
	 * Inicializa a variável items_emprestados da entidade Emprestimo
	 * 
	 * @param items_emprestados
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setItems_emprestados(Set<ItemDoAcervo> items_emprestados) {
		this.items_emprestados = items_emprestados;
	}

	/**
	 * Retorna a variável aluno da entidade Emprestimo
	 * 
	 * @return aluno
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * Inicializa a variável aluno da entidade Emprestimo
	 * 
	 * @param aluno
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	/**
	 * Retorna a variável is_pendente da entidade Emprestimo
	 * 
	 * @return is_pendente
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Boolean getIs_pendente() {
		return is_pendente;
	}

	/**
	 * Inicializa a variável is_pendente da entidade Emprestimo
	 * 
	 * @param is_pendente
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setIs_pendente(Boolean is_pendente) {
		this.is_pendente = is_pendente;
	}

	/**
	 * Retorna a variável data_emprestimo da entidade Emprestimo
	 * 
	 * @return data_emprestimo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Date getData_emprestimo() {
		return data_emprestimo;
	}

	/**
	 * Inicializa a variável data_emprestimo da entidade Emprestimo
	 * 
	 * @param data_emprestimo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setData_emprestimo(Date data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}

	/**
	 * Retorna a variável data_devolucao da entidade Emprestimo
	 * 
	 * @return data_devolucao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Date getData_devolucao() {
		return data_devolucao;
	}

	/**
	 * Inicializa a variável data_devolucao da entidade Emprestimo
	 * 
	 * @param data_devolucao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	
	/**
	 * Retorna a variável hashcode da entidade Emprestimo
	 * 
	 * @return result
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data_devolucao == null) ? 0 : data_devolucao.hashCode());
		result = prime * result + ((data_emprestimo == null) ? 0 : data_emprestimo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((is_pendente == null) ? 0 : is_pendente.hashCode());
		result = prime * result + ((items_emprestados == null) ? 0 : items_emprestados.hashCode());
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprestimo other = (Emprestimo) obj;
		if (data_devolucao == null) {
			if (other.data_devolucao != null)
				return false;
		} else if (!data_devolucao.equals(other.data_devolucao))
			return false;
		if (data_emprestimo == null) {
			if (other.data_emprestimo != null)
				return false;
		} else if (!data_emprestimo.equals(other.data_emprestimo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_pendente == null) {
			if (other.is_pendente != null)
				return false;
		} else if (!is_pendente.equals(other.is_pendente))
			return false;
		if (items_emprestados == null) {
			if (other.items_emprestados != null)
				return false;
		} else if (!items_emprestados.equals(other.items_emprestados))
			return false;
		return true;
	}

}
