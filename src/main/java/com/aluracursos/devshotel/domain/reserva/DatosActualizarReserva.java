package com.aluracursos.devshotel.domain.reserva;

import com.aluracursos.devshotel.domain.huesped.DatosHuesped;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record DatosActualizarReserva(
    @NotNull
    Long id,
    LocalDate fechaCheckIn,
    LocalDate fechaCheckOut,
    String valor,
    FormaDePago formaDePago,
    DatosHuesped huesped) {
}
