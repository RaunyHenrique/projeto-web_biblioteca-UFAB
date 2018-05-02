package com.ufab.biblioteca_ufab.models.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.ufab.biblioteca_ufab.models.entidades.User;

public interface UserRepositorio extends CrudRepository<User, Long> {

	public User findByEmail(String email);

}
