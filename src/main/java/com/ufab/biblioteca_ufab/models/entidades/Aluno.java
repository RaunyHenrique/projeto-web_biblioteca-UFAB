package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import com.ufab.biblioteca_ufab.models.enums.TipoDeCurso;

/**
 * Classe responsável por definir a organização dos dados dos objetos Aluno.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String matricula = "";

	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String cpf;

	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String rg;

	@NotNull
	@NotEmpty
	private String naturalidade;

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	@NotEmpty
	private String nomeDaMae;
	
	@NotNull
	@NotEmpty
	private String endereco;

	@NotNull
	@NotEmpty
	@Column(unique = true)
	private String telefone;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoDeCurso tipo_curso;

	@NotNull
	@NotEmpty
	private String ano;

	@NotNull
	private int periodo;

	/**
	 * Retorna a variável id da entidade Aluno
	 * 
	 * @return id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Inicializa a variável id da entidade Aluno
	 * 
	 * @param id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Retorna a variável matricula da entidade Aluno
	 * 
	 * @return matricula
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Inicializa a variável matricula da entidade Aluno
	 * 
	 * @param matricula
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Retorna a variável cpf da entidade Aluno
	 * 
	 * @return cpf
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Inicializa a variável cpf da entidade Aluno
	 * 
	 * @param cpf
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Retorna a variável rg da entidade Aluno
	 * 
	 * @return rg
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * Inicializa a variável rg da entidade Aluno
	 * 
	 * @param rg
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * Retorna a variável naturalidade da entidade Aluno
	 * 
	 * @return naturalidade
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getNaturalidade() {
		return naturalidade;
	}

	/**
	 * Inicializa a variável naturalidade da entidade Aluno
	 * 
	 * @param naturalidade
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	/**
	 * Retorna a variável nome da entidade Aluno
	 * 
	 * @return nome
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Inicializa a variável nome da entidade Aluno
	 * 
	 * @param nome
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna a variável nomeDaMae da entidade Aluno
	 * 
	 * @return nomeDaMae
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getNomeDaMae() {
		return nomeDaMae;
	}

	/**
	 * Inicializa a variável nomeDaMae da entidade Aluno
	 * 
	 * @param nomeDaMae
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	/**
	 * Retorna a variável endereco da entidade Aluno
	 * 
	 * @return endereco
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * Inicializa a variável endereco da entidade Aluno
	 * 
	 * @param endereco
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * Retorna a variável telefone da entidade Aluno
	 * 
	 * @return telefone
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Inicializa a variável telefone da entidade Aluno
	 * 
	 * @param telefone
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Retorna a variável curso da entidade Aluno
	 * 
	 * @return curso
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * Inicializa a variável curso da entidade Aluno
	 * 
	 * @param curso
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * Retorna a variável tipo_curso da entidade Aluno
	 * 
	 * @return tipo_curso
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public TipoDeCurso getTipo_curso() {
		return tipo_curso;
	}

	/**
	 * Inicializa a variável tipo_curso da entidade Aluno
	 * 
	 * @param tipo_curso
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setTipo_curso(TipoDeCurso tipo_curso) {
		this.tipo_curso = tipo_curso;
	}

	/**
	 * Retorna a variável ano da entidade Aluno
	 * 
	 * @return ano
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getAno() {
		return ano;
	}

	/**
	 * Inicializa a variável ano da entidade Aluno
	 * 
	 * @param ano
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}

	/**
	 * Retorna a variável periodo da entidade Aluno
	 * 
	 * @return periodo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getPeriodo() {
		return periodo;
	}

	/**
	 * Inicializa a variável periodo da entidade Aluno
	 * 
	 * @param periodo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	/**
	 * Retorna a variável hashcode da entidade Aluno
	 * 
	 * @return result
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((naturalidade == null) ? 0 : naturalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeDaMae == null) ? 0 : nomeDaMae.hashCode());
		result = prime * result + periodo;
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((tipo_curso == null) ? 0 : tipo_curso.hashCode());
		return result;
	}

	/**
	 * Verifica a igualdade de atributos com um objeto recebido como parâmetro
	 * 
	 * @param obj
	 * @return boolean
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
		Aluno other = (Aluno) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (naturalidade == null) {
			if (other.naturalidade != null)
				return false;
		} else if (!naturalidade.equals(other.naturalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeDaMae == null) {
			if (other.nomeDaMae != null)
				return false;
		} else if (!nomeDaMae.equals(other.nomeDaMae))
			return false;
		if (periodo != other.periodo)
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipo_curso != other.tipo_curso)
			return false;
		return true;
	}

}
