package com.ufab.biblioteca_ufab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ufab.biblioteca_ufab.models.repositorios.CursoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.JornalRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo Jornal.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

public class JornalController {

	static final Logger logger = LoggerFactory.getLogger(JornalController.class);

	@Autowired private JornalRepositorio jornalRepositorio;
}
