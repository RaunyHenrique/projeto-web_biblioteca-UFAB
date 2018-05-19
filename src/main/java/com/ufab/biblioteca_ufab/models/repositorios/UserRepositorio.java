package com.ufab.biblioteca_ufab.models.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ufab.biblioteca_ufab.models.entidades.User;

@Repository
public interface UserRepositorio extends CrudRepository<User, Long> {

	public User findByEmail(String email);

}
