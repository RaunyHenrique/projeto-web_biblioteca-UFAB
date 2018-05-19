package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.Revista;

public class RevistaTeste {

	Revista revista;
	
	@Before
	public void setUp() throws Exception {
		revista=new Revista();
		revista.setDataDePublicacao(new Date(2000));
		revista.setEdicao(1);
		revista.setId((long)1);
		revista.setNumeroDePaginas(100);
		revista.setTitulo("titulo");
		
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1), revista.getId());
	}

	@Test
	public void testGetTitulo() {
		assertEquals("titulo", revista.getTitulo());
	}

	@Test
	public void testGetDataDePublicacao() {
		assertEquals(new Date(2000), revista.getDataDePublicacao());
	}

	@Test
	public void testGetEdicao() {
		assertEquals(1, revista.getEdicao());
	}

	@Test
	public void testGetNumeroDePaginas() {
		assertEquals(100, revista.getNumeroDePaginas());
	}

}
