package com.aluracursos.devshotel.domain.huesped;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="huesped")
@Entity(name="Huesped")
public class Huesped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCompleto;
    private String email;
    private String telefono;


    public Huesped(DatosHuesped huesped) {
        this.nombreCompleto = huesped.nombreCompleto();
        this.email = huesped.email();
        this.telefono = huesped.telefono();
    }


    public Huesped actualizarDatos(@Valid DatosActualizarHuesped datosActualizarHuesped) {
        if (datosActualizarHuesped.nombreCompleto() != null){
            this.nombreCompleto = datosActualizarHuesped.nombreCompleto();
        }
        if (datosActualizarHuesped.email() != null){
            this.email = datosActualizarHuesped.email();
        }
        if (datosActualizarHuesped.telefono() != null){
            this.telefono = datosActualizarHuesped.telefono();
        }
        return this;
    }


}
