package com.ufab.biblioteca_ufab.models.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ufab.biblioteca_ufab.models.entidades.ItemDoAcervo;

@Repository
public interface ItemDoAcervoRepositorio extends CrudRepository<ItemDoAcervo, Long> {
	
	@Query("SELECT p FROM ItemDoAcervo p WHERE p.quantidade_emprestada < p.quantidade")
	public List<ItemDoAcervo> findAllItensDisponiveis();
	
	@Query("SELECT p FROM ItemDoAcervo p WHERE p.quantidade_emprestada = p.quantidade")
	public List<ItemDoAcervo> findAllItensReservados();

}

