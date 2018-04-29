package com.ufab.biblioteca_ufab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufab.biblioteca_ufab.models.repositorios.AlunoRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo aluno.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

@Controller
@RequestMapping("/alunos")
public class AlunoController {

	static final Logger logger = LoggerFactory.getLogger(AlunoController.class);

	@Autowired private AlunoRepositorio alunoRepositorio;
	
	

}
