package com.ufab.biblioteca_ufab.models.entidades;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.ufab.biblioteca_ufab.models.enums.TipoDeItemDoAcervo;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemDoAcervo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Nullable
	@Enumerated(EnumType.STRING)
	private TipoDeItemDoAcervo item_tipo;
	
	@NotNull
	@NotEmpty
	private String titulo;
	
	@Nullable
	private String autores;
	
	@NotNull
	private int quantidade = 0;
	
	@NotNull
	private int quantidade_emprestada = 0;
	
	@NotNull
	@NotEmpty
	private String palavra_chave;
	
	@NotNull
	@NotEmpty
	private String estante;
	
	@NotNull
	@NotEmpty
	private String corredor;
	
	@NotNull
	@NotEmpty
	private String prateleira;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoDeItemDoAcervo getItem_tipo() {
		return item_tipo;
	}

	public void setItem_tipo(TipoDeItemDoAcervo item_tipo) {
		this.item_tipo = item_tipo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade_emprestada() {
		return quantidade_emprestada;
	}

	public void setQuantidade_emprestada(int quantidade_emprestada) {
		this.quantidade_emprestada = quantidade_emprestada;
	}

	public String getPalavra_chave() {
		return palavra_chave;
	}

	public void setPalavra_chave(String palavra_chave) {
		this.palavra_chave = palavra_chave;
	}

	public String getEstante() {
		return estante;
	}

	public void setEstante(String estante) {
		this.estante = estante;
	}

	public String getCorredor() {
		return corredor;
	}

	public void setCorredor(String corredor) {
		this.corredor = corredor;
	}

	public String getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(String prateleira) {
		this.prateleira = prateleira;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + ((corredor == null) ? 0 : corredor.hashCode());
		result = prime * result + ((estante == null) ? 0 : estante.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item_tipo == null) ? 0 : item_tipo.hashCode());
		result = prime * result + ((palavra_chave == null) ? 0 : palavra_chave.hashCode());
		result = prime * result + ((prateleira == null) ? 0 : prateleira.hashCode());
		result = prime * result + quantidade;
		result = prime * result + quantidade_emprestada;
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
		ItemDoAcervo other = (ItemDoAcervo) obj;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (corredor == null) {
			if (other.corredor != null)
				return false;
		} else if (!corredor.equals(other.corredor))
			return false;
		if (estante == null) {
			if (other.estante != null)
				return false;
		} else if (!estante.equals(other.estante))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (item_tipo != other.item_tipo)
			return false;
		if (palavra_chave == null) {
			if (other.palavra_chave != null)
				return false;
		} else if (!palavra_chave.equals(other.palavra_chave))
			return false;
		if (prateleira == null) {
			if (other.prateleira != null)
				return false;
		} else if (!prateleira.equals(other.prateleira))
			return false;
		if (quantidade != other.quantidade)
			return false;
		if (quantidade_emprestada != other.quantidade_emprestada)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
}
