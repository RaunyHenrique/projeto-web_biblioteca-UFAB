package com.ufab.biblioteca_ufab.models.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ufab.biblioteca_ufab.models.entidades.Biblioteca;

public interface BibliotecaRepositorio extends CrudRepository<Biblioteca, Long> {

}
