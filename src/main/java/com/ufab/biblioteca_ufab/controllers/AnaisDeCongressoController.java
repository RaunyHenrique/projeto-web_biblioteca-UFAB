package com.ufab.biblioteca_ufab.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ufab.biblioteca_ufab.models.repositorios.AlunoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.AnaisDeCongressoRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo
 * anaisDeCongresso.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

public class AnaisDeCongressoController {

	static final Logger logger = LoggerFactory.getLogger(AnaisDeCongressoController.class);

	@Autowired private AnaisDeCongressoRepositorio anaisDeCongressoRepositorio;

}
