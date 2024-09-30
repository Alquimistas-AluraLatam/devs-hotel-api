package com.aluracursos.devshotel.repository;

import com.aluracursos.devshotel.domain.reserva.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {


}
