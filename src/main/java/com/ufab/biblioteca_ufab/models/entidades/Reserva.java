package com.ufab.biblioteca_ufab.models.entidades;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private ItemDoAcervo item;
	
	@ManyToOne
	private Aluno aluno;
	
	@NotNull
	private Date data_reserva_entrega;

	@Type(type="boolean")
	private Boolean receber_notificacao = false;

	/**
	 * Retorna a variavel id da entidade Reserva
	 * 
	 * @return id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Inicializa a variavel id da entidade Reserva
	 * 
	 * @param id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna a variavel item da entidade Reserva
	 * 
	 * @return item
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public ItemDoAcervo getItem() {
		return item;
	}

	/**
	 * Inicializa a variavel item da entidade Reserva
	 * 
	 * @param item
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setItem(ItemDoAcervo item) {
		this.item = item;
	}

	/**
	 * Retorna a variavel aluno da entidade Reserva
	 * 
	 * @return aluno
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * Inicializa a variavel aluno da entidade Reserva
	 * 
	 * @param aluno
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	/**
	 * Retorna a variavel data_reserva_entrega da entidade Reserva
	 * 
	 * @return data_reserva_entrega
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Date getData_reserva_entrega() {
		return data_reserva_entrega;
	}
	
	/**
	 * Inicializa a variavel data_reserva_entrega da entidade Reserva
	 * 
	 * @param data_reserva_entrega
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setData_reserva_entrega(Date data_reserva_entrega) {
		this.data_reserva_entrega = data_reserva_entrega;
	}

	/**
	 * Retorna a variavel isReceber_Notificacao da entidade Reserva
	 * 
	 * @return isReceber_Notificacao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public boolean isReceber_notificacao() {
		return receber_notificacao;
	}

	/**
	 * Inicializa a variavel isReceber_Notificacao da entidade Reserva
	 * 
	 * @param isReceber_Notificacao
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setReceber_notificacao(boolean receber_notificacao) {
		this.receber_notificacao = receber_notificacao;
	}

	/**
	 * Retorna a variavel hashCode da entidade Reserva
	 * 
	 * @return result
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((data_reserva_entrega == null) ? 0 : data_reserva_entrega.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + (receber_notificacao ? 1231 : 1237);
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
		Reserva other = (Reserva) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (data_reserva_entrega == null) {
			if (other.data_reserva_entrega != null)
				return false;
		} else if (!data_reserva_entrega.equals(other.data_reserva_entrega))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (receber_notificacao != other.receber_notificacao)
			return false;
		return true;
	}
}