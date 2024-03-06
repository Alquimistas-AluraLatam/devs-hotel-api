package com.aluracursos.devshotel.domain.reserva;
import com.aluracursos.devshotel.domain.huesped.Huesped;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Table(name="reserva")
@Entity(name="Reserva")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT-3")
    private LocalDate fechaCheckIn;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT-3")
    private LocalDate fechaCheckOut;
    private String valor;
    @Enumerated(EnumType.STRING)
    private FormaDePago formaDePago;
    @Embedded
    private Huesped huesped;

    public Reserva(DatosRegistroReserva datosRegistroReserva) {
        this.fechaCheckIn = datosRegistroReserva.fechaCheckIn();
        this.fechaCheckOut = datosRegistroReserva.fechaCheckOut();
        this.valor = datosRegistroReserva.valor();
        this.formaDePago = datosRegistroReserva.formaDePago();
        this.huesped = new Huesped(datosRegistroReserva.huesped());
    }

    public void actualizarDatos(DatosActualizarReserva datosActualizarReserva) {
        if (datosActualizarReserva.fechaCheckIn() != null){
            this.fechaCheckIn = datosActualizarReserva.fechaCheckIn();
        }
        if (datosActualizarReserva.fechaCheckOut() != null){
            this.fechaCheckOut = datosActualizarReserva.fechaCheckOut();
        }
        if (datosActualizarReserva.valor() != null){
            this.valor = datosActualizarReserva.valor();
        }
        if (datosActualizarReserva.formaDePago() != null){
            this.formaDePago = datosActualizarReserva.formaDePago();
        }
        if (datosActualizarReserva.huesped() != null){
            this.huesped = huesped.actualizarDatos(datosActualizarReserva.huesped());
        }
    }
}
