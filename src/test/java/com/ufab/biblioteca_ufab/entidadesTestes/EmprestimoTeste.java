package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.Aluno;
import com.ufab.biblioteca_ufab.models.entidades.Emprestimo;
import com.ufab.biblioteca_ufab.models.entidades.ItemDoAcervo;

public class EmprestimoTeste {

	Emprestimo emprestimo;
	Aluno aluno;
	Set<ItemDoAcervo> items_emprestados;
	
	@Before
	public void setUp() throws Exception {
		emprestimo=new Emprestimo();
		aluno=new Aluno();
		emprestimo.setAluno(aluno);
		emprestimo.setData_devolucao(new Date(1000));
		emprestimo.setData_emprestimo(new Date(1000));
		emprestimo.setId((long)1);
		emprestimo.setIs_pendente(true);
		emprestimo.setItems_emprestados(items_emprestados);		
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1), emprestimo.getId());
	}

	@Test
	public void testGetItems_emprestados() {
		assertEquals(items_emprestados, emprestimo.getItems_emprestados());
	}

	@Test
	public void testGetAluno() {
		assertEquals(aluno, emprestimo.getAluno());
	}

	@Test
	public void testGetIs_pendente() {
		assertEquals(true, emprestimo.getIs_pendente());
	}

	@Test
	public void testGetData_emprestimo() {
		assertEquals(new Date(1000), emprestimo.getData_emprestimo());
	}

	@Test
	public void testGetData_devolucao() {
		assertEquals(new Date(1000), emprestimo.getData_devolucao());
	}

}
