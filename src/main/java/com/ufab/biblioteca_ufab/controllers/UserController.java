package com.ufab.biblioteca_ufab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ufab.biblioteca_ufab.models.repositorios.UserRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo User.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired private UserRepositorio userRepositorio;

	public void realizarEmprestimo() {
	}

	public void realizarReserva() {
	}

	public void realizarRenovacaoDeEmprestimo() {
	}

	public void realizarDevolucao() {
	}

	public void cadastrarAluno() {
	}

	public void EditarAluno() {
	}

}
