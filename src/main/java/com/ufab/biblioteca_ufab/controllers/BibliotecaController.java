package com.ufab.biblioteca_ufab.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ufab.biblioteca_ufab.models.repositorios.AnaisDeCongressoRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.BibliotecaRepositorio;


/**
 * Classe responsável por manipular as informações dos objetos tipo biblioteca.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

public class BibliotecaController {

	static final Logger logger = LoggerFactory.getLogger(BibliotecaController.class);

	@Autowired private BibliotecaRepositorio bibliotecaRepositorio;

}
