package com.aluracursos.hotelalura.modelos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Huesped {
    private String nombreCompleto;
    private String email;
    private String telefono;

    public Huesped(DatosHuesped huesped) {
        this.nombreCompleto = huesped.nombreCompleto();
        this.email = huesped.email();
        this.telefono = huesped.telefono();
    }

    public Huesped actualizarDatos(DatosHuesped huesped) {
        this.nombreCompleto = huesped.nombreCompleto();
        this.email = huesped.email();
        this.telefono = huesped.telefono();
        return this;
    }
}
