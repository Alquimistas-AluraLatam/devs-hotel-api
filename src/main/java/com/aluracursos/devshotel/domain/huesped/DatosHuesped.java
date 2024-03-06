package com.aluracursos.devshotel.domain.huesped;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record DatosHuesped(
        @NotBlank
        String nombreCompleto,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefono) {
}
