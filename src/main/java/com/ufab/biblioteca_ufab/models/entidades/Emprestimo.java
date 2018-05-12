package com.ufab.biblioteca_ufab.models.entidades;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(fetch=FetchType.EAGER)
	private Set<ItemDoAcervo> items_emprestados;
	
	@OneToOne
	private Aluno aluno;
	
	@NotNull
	private boolean isPedente;

}
