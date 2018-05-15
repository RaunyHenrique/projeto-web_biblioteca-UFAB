package com.ufab.biblioteca_ufab.models.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ufab.biblioteca_ufab.models.entidades.Reserva;


@Repository
public interface ReservaRepositorio extends CrudRepository<Reserva, Long> {
	
	

}
