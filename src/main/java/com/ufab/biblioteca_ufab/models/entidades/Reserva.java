package com.ufab.biblioteca_ufab.models.entidades;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

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

	@NotNull
	private boolean receber_notificacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItemDoAcervo getItem() {
		return item;
	}

	public void setItem(ItemDoAcervo item) {
		this.item = item;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Date getData_reserva_entrega() {
		return data_reserva_entrega;
	}

	public void setData_reserva_entrega(Date data_reserva_entrega) {
		this.data_reserva_entrega = data_reserva_entrega;
	}

	public boolean isReceber_notificacao() {
		return receber_notificacao;
	}

	public void setReceber_notificacao(boolean receber_notificacao) {
		this.receber_notificacao = receber_notificacao;
	}

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