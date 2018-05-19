package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.Permissao;

public class PermissaoTeste {

	Permissao permissao;
	
	@Before
	public void setUp() throws Exception {
		permissao=new Permissao();
		permissao.setId((long)1);
		permissao.setNome("nome");
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1), permissao.getId());
	}

	@Test
	public void testGetNome() {
		assertEquals("nome", permissao.getNome());
	}

}
