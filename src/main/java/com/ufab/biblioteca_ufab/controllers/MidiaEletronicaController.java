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

import com.ufab.biblioteca_ufab.models.repositorios.LivroRepositorio;
import com.ufab.biblioteca_ufab.models.repositorios.MidiaEletronicaRepositorio;

/**
 * Classe responsável por manipular as informações dos objetos tipo
 * MidiaEletronica.
 * 
 * @author Luis Lancellote
 * @author Rauny Henrique
 */

public class MidiaEletronicaController {

	static final Logger logger = LoggerFactory.getLogger(MidiaEletronicaController.class);

	@Autowired private MidiaEletronicaRepositorio midiaEletronicaRepositorio;

}
