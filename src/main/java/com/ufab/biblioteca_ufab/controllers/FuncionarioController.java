package com.ufab.biblioteca_ufab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ufab.biblioteca_ufab.models.repositorios.CursoRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo Funcionario.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

public class FuncionarioController {

	static final Logger logger = LoggerFactory.getLogger(FuncionarioController.class);

	@Autowired private CursoRepositorio cursoRepositorio;

}
