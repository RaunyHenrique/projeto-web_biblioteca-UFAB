package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.Aluno;
import com.ufab.biblioteca_ufab.models.enums.TipoDeCurso;

public class AlunoTeste {

	Aluno aluno;
	
	@Before
	public void setUp() throws Exception {
		aluno=new Aluno();
		aluno.setAno("ano");
		aluno.setCpf("cpf");
		aluno.setEndereco("endereco");
		aluno.setId((long)1);
		aluno.setMatricula("matricula");
		aluno.setNaturalidade("naturalidade");
		aluno.setNome("nome");
		aluno.setNomeDaMae("nome");
		aluno.setPeriodo(1);
		aluno.setRg("rg");
		aluno.setTelefone("telefone");
		aluno.setTipo_curso(TipoDeCurso.GRADUACAO);
		
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1), aluno.getId());
	}

	@Test
	public void testGetMatricula() {
		assertEquals("matricula", aluno.getMatricula());
	}

	@Test
	public void testGetCpf() {
		assertEquals("cpf", aluno.getCpf());
	}

	@Test
	public void testGetRg() {
		assertEquals("rg", aluno.getRg());
	}

	@Test
	public void testGetNaturalidade() {
		assertEquals("naturalidade", aluno.getNaturalidade());
	}

	@Test
	public void testGetNome() {
		assertEquals("nome", aluno.getNome());
	}

	@Test
	public void testGetNomeDaMae() {
		assertEquals("nome", aluno.getNomeDaMae());

	}

	@Test
	public void testGetEndereco() {
		assertEquals("endereco",aluno.getEndereco());
	}

	@Test
	public void testGetTelefone() {
		assertEquals("telefone", aluno.getTelefone());
	}

	@Test
	public void testGetCurso() {
	}

	@Test
	public void testGetTipo_curso() {
		assertEquals(TipoDeCurso.GRADUACAO, aluno.getTipo_curso());
	}

	@Test
	public void testGetAno() {
		assertEquals("ano", aluno.getAno());
	}

	@Test
	public void testGetPeriodo() {
		assertEquals(1, aluno.getPeriodo());
	}

}
