package com.ufab.biblioteca_ufab.models.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ufab.biblioteca_ufab.models.entidades.Funcionario;

public interface FuncionarioRepositorio extends CrudRepository<Funcionario, Long> {

}
