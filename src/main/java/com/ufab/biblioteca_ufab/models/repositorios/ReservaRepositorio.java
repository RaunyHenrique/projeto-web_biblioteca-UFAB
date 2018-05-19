package com.ufab.biblioteca_ufab.models.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ufab.biblioteca_ufab.models.entidades.Reserva;

@Repository
public interface ReservaRepositorio extends CrudRepository<Reserva, Long> {
	
	@Query("SELECT a FROM Reserva a WHERE DATEDIFF(CURRENT_DATE(),a.data_reserva_entrega) < 0")
	public List<Reserva> findAll();
	
	@Query("SELECT a FROM Reserva a WHERE DATEDIFF(CURRENT_DATE(),a.data_reserva_entrega) < 0 AND a.item.id = :id")
	public Optional<Reserva> findByIdItemReserva(@Param("id") Long id);// se achar, não esta disponivel!

}
