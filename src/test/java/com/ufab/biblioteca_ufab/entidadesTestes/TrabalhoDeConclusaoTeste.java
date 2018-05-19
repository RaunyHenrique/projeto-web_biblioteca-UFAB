package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.TrabalhoDeConclusao;
import com.ufab.biblioteca_ufab.models.enums.TipoDeTrabalhoDeConclusao;

public class TrabalhoDeConclusaoTeste {

	TrabalhoDeConclusao trabalho;
	
	@Before
	public void setUp() throws Exception {
		trabalho=new TrabalhoDeConclusao();
		trabalho.setAnoDeDefesa(2000);
		trabalho.setAutores("autor");
		trabalho.setId((long)1);
		trabalho.setLocal("local");
		trabalho.setOrientadores("orientador");
		trabalho.setTipo(TipoDeTrabalhoDeConclusao.TESE);
		trabalho.setTitulo("titulo");
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1), trabalho.getId());
	}

	@Test
	public void testGetTitulo() {
		assertEquals("titulo", trabalho.getTitulo());
	}

	@Test
	public void testGetAutores() {
		assertEquals("autor", trabalho.getAutores());
	}

	@Test
	public void testGetOrientadores() {
		assertEquals("orientador", trabalho.getOrientadores());
	}

	@Test
	public void testGetTipo() {
		assertEquals(TipoDeTrabalhoDeConclusao.TESE, trabalho.getTipo());
	}

	@Test
	public void testGetAnoDeDefesa() {
		assertEquals(2000, trabalho.getAnoDeDefesa());
	}

	@Test
	public void testGetLocal() {
		assertEquals("local", trabalho.getLocal());
	}

}
