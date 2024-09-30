package com.aluracursos.devshotel.domain.huesped;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record DatosActualizarHuesped(
        @NotBlank
        Long id,
        String nombreCompleto,
        @Email
        String email,

        String telefono) {

}
