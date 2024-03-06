package com.aluracursos.devshotel.repository;
import com.aluracursos.devshotel.domain.reserva.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {


}
