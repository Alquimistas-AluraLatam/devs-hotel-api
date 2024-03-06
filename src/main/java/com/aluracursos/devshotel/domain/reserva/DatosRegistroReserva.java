package com.aluracursos.devshotel.domain.reserva;


import com.aluracursos.devshotel.domain.huesped.DatosHuesped;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record DatosRegistroReserva(

        @NotNull
        LocalDate fechaCheckIn,
        @NotNull
        LocalDate fechaCheckOut,
        @NotBlank
        String valor,
        @NotNull
        FormaDePago formaDePago,
        @NotNull
        @Valid
        DatosHuesped huesped) {
}
