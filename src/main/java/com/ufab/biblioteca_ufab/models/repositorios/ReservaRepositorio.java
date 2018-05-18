package com.ufab.biblioteca_ufab.models.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ufab.biblioteca_ufab.models.entidades.Reserva;


@Repository
public interface ReservaRepositorio extends CrudRepository<Reserva, Long> {
	
	@Query("SELECT a FROM Reserva a WHERE DATEDIFF(CURRENT_DATE(),a.data_reserva_entrega) < 0")
	public List<Reserva> findAll();

}
