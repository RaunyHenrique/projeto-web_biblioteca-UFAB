package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.User;

public class UserTeste {
	
	User user;

	@Before
	public void setUp() throws Exception {
		user =new User();
		user.setCpf("cpf");
		user.setEmail("email");
		user.setEndereco("endereco");
		user.setId((long)1);
		user.setNaturalidade("naturalidade");
		user.setNome("nome");
		user.setRg("rg");
		user.setSenha("senha");
		user.setTelefone("telefone");
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1),user.getId());
	}

	@Test
	public void testGetEmail() {
		assertEquals("email", user.getEmail());
	}

	@Test
	public void testGetSenha() {
		assertEquals("senha", user.getSenha());
	}

	@Test
	public void testGetCpf() {
		assertEquals("cpf", user.getCpf());
	}

	@Test
	public void testGetRg() {
		assertEquals("rg", user.getRg());
	}

	@Test
	public void testGetNaturalidade() {
		assertEquals("naturalidade",user.getNaturalidade());
	}

	@Test
	public void testGetNome() {
		assertEquals("nome", user.getNome());
	}

	@Test
	public void testGetEndereco() {
		assertEquals("endereco", user.getEndereco());
	}

	@Test
	public void testGetTelefone() {
		assertEquals("telefone", user.getTelefone());

	}

}
