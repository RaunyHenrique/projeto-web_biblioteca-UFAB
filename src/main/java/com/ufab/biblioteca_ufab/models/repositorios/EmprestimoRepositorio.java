package com.ufab.biblioteca_ufab.models.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ufab.biblioteca_ufab.models.entidades.Emprestimo;

@Repository
public interface EmprestimoRepositorio extends CrudRepository<Emprestimo, Long> {
	
	

}