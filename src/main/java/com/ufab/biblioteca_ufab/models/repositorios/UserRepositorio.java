package com.ufab.biblioteca_ufab.models.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.ufab.biblioteca_ufab.models.entidades.User;

public interface UserRepositorio extends CrudRepository<User, Long> {

}
