package com.ufab.biblioteca_ufab.models.entidades;

/**
 * Classe responsável por realizar autenticação de objetos tipo User.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

public class Autenticacao {

	private User user;

	/**
	 * Retorna o valor da variável user
	 * 
	 * @return user
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Inicializa a variável user com um valor recebido como parâmetro
	 * 
	 * @param user
	 * @author Luis Lancellote
	 * @author Rauny Henrique
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
