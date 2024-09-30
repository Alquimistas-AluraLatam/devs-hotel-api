package com.aluracursos.devshotel.domain.huesped;

import com.aluracursos.devshotel.domain.reserva.Reserva;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record DatosListadoHuesped( Long id,
        String nombreCompleto,
        String email,
        String telefono
) {

    public DatosListadoHuesped(Huesped huesped){
        this(huesped.getId(), huesped.getNombreCompleto(), huesped.getEmail(), huesped.getTelefono());

    }


}
