package com.ufab.biblioteca_ufab.entidadesTestes;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.ufab.biblioteca_ufab.models.entidades.Aluno;
import com.ufab.biblioteca_ufab.models.entidades.ItemDoAcervo;
import com.ufab.biblioteca_ufab.models.entidades.Reserva;

public class ReservaTeste {

	Reserva reserva;
	Aluno aluno;	
	ItemDoAcervo item;
	
	@Before
	public void setUp() throws Exception {
		reserva=new Reserva();
		aluno=new Aluno();
		item=new ItemDoAcervo();
		
		reserva.setAluno(aluno);
		reserva.setData_reserva_entrega(new Date(1000));
		reserva.setId(new Long(1));
		reserva.setItem(item);
		reserva.setReceber_notificacao(true);
		
	}

	@Test
	public void testGetId() {
		assertEquals(new Long(1), reserva.getId());
	}

	@Test
	public void testGetItem() {
		assertEquals(item, reserva.getItem());
	}

	@Test
	public void testGetAluno() {
		assertEquals(aluno, reserva.getAluno());
	}

	@Test
	public void testGetData_reserva_entrega() {
		assertEquals(new Date(1000), reserva.getData_reserva_entrega());
	}

	@Test
	public void testIsReceber_notificacao() {
		assertEquals(true, reserva.isReceber_notificacao());
	}

}
