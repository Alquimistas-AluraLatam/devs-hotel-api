package com.aluracursos.devshotel.repository;

import com.aluracursos.devshotel.domain.huesped.Huesped;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HuespedRepository extends JpaRepository<Huesped, Long> {
    Optional<Huesped> findByEmail(String email);
}
