package com.ufab.biblioteca_ufab.models.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ufab.biblioteca_ufab.models.entidades.Curso;

public interface CursoRepositorio extends CrudRepository<Curso, Long> {
	
//	@Query("SELECT p FROM Curso p WHERE p.tipo = :tipo")
//	public List<Curso> findByTipo(@Param("tipo") String tipo);

}
