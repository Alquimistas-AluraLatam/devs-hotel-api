package com.aluracursos.hotelalura.modelos;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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
