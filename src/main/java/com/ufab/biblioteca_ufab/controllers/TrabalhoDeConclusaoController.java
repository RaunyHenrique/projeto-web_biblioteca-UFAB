package com.ufab.biblioteca_ufab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ufab.biblioteca_ufab.models.repositorios.TrabalhoDeConclusaoRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo
 * TrabalhoDeConclusao.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

public class TrabalhoDeConclusaoController {

	static final Logger logger = LoggerFactory.getLogger(TrabalhoDeConclusaoController.class);

	@Autowired private TrabalhoDeConclusaoRepositorio trabalhoDeConclusaoRepositorio;

}
