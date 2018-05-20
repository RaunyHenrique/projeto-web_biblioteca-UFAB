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

	/**
	 * Retorna a variável id da entidade ItemDoAcervo
	 * 
	 * @return id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Inicializa a variável id da entidade ItemDoAcervo
	 * 
	 * @param id
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retorna a variável item_tipo da entidade ItemDoAcervo
	 * 
	 * @return item_Tipo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public TipoDeItemDoAcervo getItem_tipo() {
		return item_tipo;
	}

	/**
	 * Inicializa a variável item_tipo da entidade ItemDoAcervo
	 * 
	 * @param item_tipo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setItem_tipo(TipoDeItemDoAcervo item_tipo) {
		this.item_tipo = item_tipo;
	}

	/**
	 * Retorna a variável titulo da entidade ItemDoAcervo
	 * 
	 * @return titulo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Inicializa a variável titulo da entidade ItemDoAcervo
	 * 
	 * @param titulo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Retorna a variável autores da entidade ItemDoAcervo
	 * 
	 * @return autores
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getAutores() {
		return autores;
	}

	/**
	 * Inicializa a variável autores da entidade ItemDoAcervo
	 * 
	 * @param autores
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setAutores(String autores) {
		this.autores = autores;
	}

	/**
	 * Retorna a variável quantidade da entidade ItemDoAcervo
	 * 
	 * @return quantidade
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Inicializa a variável quantidade da entidade ItemDoAcervo
	 * 
	 * @param quantidade
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Retorna a variável quantidade_emprestada da entidade ItemDoAcervo
	 * 
	 * @return quantidade_emprestada
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public int getQuantidade_emprestada() {
		return quantidade_emprestada;
	}
	
	/**
	 * Inicializa a variável quantidade_emprestada da entidade ItemDoAcervo
	 * 
	 * @param quantidade_emprestada
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setQuantidade_emprestada(int quantidade_emprestada) {
		this.quantidade_emprestada = quantidade_emprestada;
	}

	/**
	 * Retorna a variável palavra_chave da entidade ItemDoAcervo
	 * 
	 * @return palavra_chave
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getPalavra_chave() {
		return palavra_chave;
	}

	/**
	 * Inicializa a variável item_tipo da entidade ItemDoAcervo
	 * 
	 * @param item_tipo
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setPalavra_chave(String palavra_chave) {
		this.palavra_chave = palavra_chave;
	}

	/**
	 * Retorna a variável estante da entidade ItemDoAcervo
	 * 
	 * @return estante
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getEstante() {
		return estante;
	}

	/**
	 * Inicializa a variável estante da entidade ItemDoAcervo
	 * 
	 * @param estante
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setEstante(String estante) {
		this.estante = estante;
	}

	/**
	 * Retorna a variável corredor da entidade ItemDoAcervo
	 * 
	 * @return corredor
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getCorredor() {
		return corredor;
	}

	/**
	 * Inicializa a variável corredor da entidade ItemDoAcervo
	 * 
	 * @param corredor
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setCorredor(String corredor) {
		this.corredor = corredor;
	}

	/**
	 * Retorna a variável prateleira da entidade ItemDoAcervo
	 * 
	 * @return prateleira
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public String getPrateleira() {
		return prateleira;
	}

	/**
	 * Inicializa a variável prateleira da entidade ItemDoAcervo
	 * 
	 * @param prateleira
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setPrateleira(String prateleira) {
		this.prateleira = prateleira;
	}

	/**
	 * Retorna a variável hashcode da entidade ItemDoAcervo
	 * 
	 * @return result
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
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
