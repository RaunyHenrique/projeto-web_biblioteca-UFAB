package com.ufab.biblioteca_ufab.models.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ufab.biblioteca_ufab.models.entidades.Livro;

public interface LivroRepositorio extends CrudRepository<Livro, Long> {

}
