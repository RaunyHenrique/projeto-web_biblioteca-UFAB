package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.Jornal;

public class JornalTeste {

	Jornal jornal;
	
	@Before
	public void setUp() throws Exception {
		jornal=new Jornal();
		jornal.setData(new Date(1000));
		jornal.setEdicao(1);
		jornal.setId((long)1);
		jornal.setTitulo("titulo");
		
	}

	@Test
	public void testGetId() {
		Long id=new Long(1);
		assertEquals(id, jornal.getId());
	}

	@Test
	public void testGetTitulo() {
		assertEquals("titulo", jornal.getTitulo());
	}

	@Test
	public void testGetData() {
		assertEquals(new Date(1000), jornal.getData());
	}

	@Test
	public void testGetEdicao() {
		assertEquals(1, jornal.getEdicao());
	}

}
