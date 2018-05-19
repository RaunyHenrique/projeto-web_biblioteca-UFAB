package com.ufab.biblioteca_ufab.entidadesTestes;
import com.ufab.biblioteca_ufab.models.entidades.Livro;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LivroTeste {

	Livro livro;
	
	@Before
	public void setUp() throws Exception {
		livro=new Livro();
		livro.setAnoDePublicacao(2000);
		livro.setArea("area");
		livro.setEdicao(1);
		livro.setId((long)1);
		livro.setIsbn("isbn");
		livro.setNumeroDePaginas(100);
		livro.setTema("tema");
		livro.setTitulo("titulo");
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1), livro.getId());
	}

	@Test
	public void testGetTitulo() {
		assertEquals("titulo", livro.getTitulo());
	}

	@Test
	public void testGetIsbn() {
		assertEquals("isbn", livro.getIsbn());
	}

	@Test
	public void testGetAutores() {
	}

	@Test
	public void testGetEditora() {
	}

	@Test
	public void testGetAnoDePublicacao() {
		assertEquals(2000, livro.getAnoDePublicacao());
	}

	@Test
	public void testGetEdicao() {
		assertEquals(1, livro.getEdicao());
	}

	@Test
	public void testGetNumeroDePaginas() {
		assertEquals(100, livro.getNumeroDePaginas());
	}

	@Test
	public void testGetArea() {
		assertEquals("area", livro.getArea());
	}

	@Test
	public void testGetTema() {
		assertEquals("tema", livro.getTema());
	}

}
