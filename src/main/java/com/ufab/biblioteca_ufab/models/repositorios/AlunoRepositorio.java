package com.ufab.biblioteca_ufab.models.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ufab.biblioteca_ufab.models.entidades.Aluno;

@Repository
public interface AlunoRepositorio extends CrudRepository<Aluno, Long> {
	
	

}
