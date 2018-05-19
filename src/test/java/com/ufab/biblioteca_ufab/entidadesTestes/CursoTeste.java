package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.Curso;
import com.ufab.biblioteca_ufab.models.enums.TipoDeCurso;

public class CursoTeste {

	Curso curso;
	
	@Before
	public void setUp() throws Exception {
		
		curso=new Curso();
		curso.setArea("area");
		curso.setId((long)1);
		curso.setNome("nome");
		curso.setTipo(TipoDeCurso.GRADUACAO);
		
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1), curso.getId());
	}

	@Test
	public void testGetNome() {
		assertEquals("nome", curso.getNome());
	}

	@Test
	public void testGetArea() {
		assertEquals("area", curso.getArea());
	}

	@Test
	public void testGetTipo() {
		assertEquals(TipoDeCurso.GRADUACAO, curso.getTipo());
	}

}
