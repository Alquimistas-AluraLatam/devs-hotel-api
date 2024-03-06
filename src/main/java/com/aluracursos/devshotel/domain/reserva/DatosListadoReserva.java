package com.aluracursos.devshotel.domain.reserva;


import java.time.LocalDate;

public record DatosListadoReserva(Long id, LocalDate fechaCheckIn, LocalDate fechaCheckOut, String valor, String huesped){

    public DatosListadoReserva(Reserva reserva){
        this(reserva.getId(),reserva.getFechaCheckIn(),reserva.getFechaCheckOut(),reserva.getValor(), reserva.getHuesped().getNombreCompleto());

        }

}
