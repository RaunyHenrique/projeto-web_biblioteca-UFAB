package com.ufab.biblioteca_ufab.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ufab.biblioteca_ufab.models.repositorios.BibliotecaRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.CursoRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo curso.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

public class CursoController {

	static final Logger logger = LoggerFactory.getLogger(CursoController.class);

	@Autowired private CursoRepositorio cursoRepositorio;

}
