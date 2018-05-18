package com.ufab.biblioteca_ufab.models.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ufab.biblioteca_ufab.models.entidades.Aluno;
import com.ufab.biblioteca_ufab.models.entidades.Emprestimo;

@Repository
public interface EmprestimoRepositorio extends CrudRepository<Emprestimo, Long> {
	
	@Query("SELECT a FROM Emprestimo a WHERE DATEDIFF(CURRENT_DATE(),a.data_devolucao) < 0 AND a.is_pendente = 1")
	public List<Emprestimo> findAll();
	
	@Query("SELECT a FROM Emprestimo a WHERE DATEDIFF(CURRENT_DATE(),a.data_devolucao) > 0 AND a.is_pendente = 1")
	public List<Emprestimo> findAllPendencias();

}