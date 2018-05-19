package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.AnaisDeCongresso;
import com.ufab.biblioteca_ufab.models.enums.TipoDeAnaisDoCongresso;

public class AnaisDeCongressoTeste {

	AnaisDeCongresso anais;
	
	@Before
	public void setUp() throws Exception {
		anais=new AnaisDeCongresso();
		anais.setAnoDePublicacao(2000);
		anais.setAutores("autor");
		anais.setId((long)1);
		anais.setLocal("local");
		anais.setNomeDoCongresso("nome");
		anais.setTipo(TipoDeAnaisDoCongresso.ARTIGO);
		anais.setTitulo("titulo");
		
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1), anais.getId());
	}

	@Test
	public void testGetTitulo() {
		assertEquals("titulo", anais.getTitulo());
	}

	@Test
	public void testGetTipo() {
		assertEquals(TipoDeAnaisDoCongresso.ARTIGO, anais.getTipo());
	}

	@Test
	public void testGetAutores() {
		assertEquals("autor", anais.getAutores());
	}

	@Test
	public void testGetNomeDoCongresso() {
		assertEquals("nome", anais.getNomeDoCongresso());
	}

	@Test
	public void testGetAnoDePublicacao() {
		assertEquals(2000, anais.getAnoDePublicacao());
	}

	@Test
	public void testGetLocal() {
		assertEquals("local", anais.getLocal());
	}

}
