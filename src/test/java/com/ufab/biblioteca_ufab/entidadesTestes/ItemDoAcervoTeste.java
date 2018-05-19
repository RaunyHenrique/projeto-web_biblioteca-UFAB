package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.ItemDoAcervo;
import com.ufab.biblioteca_ufab.models.enums.TipoDeItemDoAcervo;

public class ItemDoAcervoTeste {

	ItemDoAcervo item;
	
	@Before
	public void setUp() throws Exception {
		item=new ItemDoAcervo();
		item.setAutores("autor");
		item.setCorredor("corredor");
		item.setEstante("estante");
		item.setId((long)1);
		item.setPalavra_chave("palavra");
		item.setPrateleira("prateleira");
		item.setQuantidade(1);
		item.setQuantidade_emprestada(1);
		item.setItem_tipo(TipoDeItemDoAcervo.JORNAL);
		item.setTitulo("titulo");
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1), item.getId());
	}

	@Test
	public void testGetItem_tipo() {
		assertEquals(TipoDeItemDoAcervo.JORNAL, item.getItem_tipo());
	}

	@Test
	public void testGetTitulo() {
		assertEquals("titulo", item.getTitulo());
	}

	@Test
	public void testGetAutores() {
		assertEquals("autor", item.getAutores());
	}

	@Test
	public void testGetQuantidade() {
		assertEquals(1, item.getQuantidade());
	}

	@Test
	public void testGetQuantidade_emprestada() {
		assertEquals(1, item.getQuantidade_emprestada());
	}

	@Test
	public void testGetPalavra_chave() {
		assertEquals("palavra", item.getPalavra_chave());
	}

	@Test
	public void testGetEstante() {
		assertEquals("estante", item.getEstante());
	}

	@Test
	public void testGetCorredor() {
		assertEquals("corredor",item.getCorredor());
	}

	@Test
	public void testGetPrateleira() {
		assertEquals("prateleira", item.getPrateleira());
	}

}
