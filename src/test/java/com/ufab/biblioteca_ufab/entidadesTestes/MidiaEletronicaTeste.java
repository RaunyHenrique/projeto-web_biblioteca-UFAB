package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.MidiaEletronica;
import com.ufab.biblioteca_ufab.models.enums.TipoDeMidiaEletronica;

public class MidiaEletronicaTeste {
	
	MidiaEletronica midia;

	@Before
	public void setUp() throws Exception {
		midia=new MidiaEletronica();
		midia.setDataDeGravacao(new Date(2000));
		midia.setId((long)1);
		midia.setTipo(TipoDeMidiaEletronica.CD);
		midia.setTitulo("titulo");
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1), midia.getId());
	}

	@Test
	public void testGetTitulo() {
		assertEquals("titulo", midia.getTitulo());
	}

	@Test
	public void testGetTipo() {
		assertEquals(TipoDeMidiaEletronica.CD, midia.getTipo());
	}

	@Test
	public void testGetDataDeGravacao() {
		assertEquals(new Date(2000), midia.getDataDeGravacao());
	}

}
