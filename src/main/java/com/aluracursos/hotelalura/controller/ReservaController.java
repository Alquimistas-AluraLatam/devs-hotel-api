package com.aluracursos.hotelalura.controller;

import com.aluracursos.hotelalura.modelos.DatosActualizarReserva;
import com.aluracursos.hotelalura.modelos.DatosListadoReserva;
import com.aluracursos.hotelalura.modelos.DatosRegistroReserva;
import com.aluracursos.hotelalura.modelos.Reserva;
import com.aluracursos.hotelalura.repository.ReservaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;


    @PostMapping
    public void registrarReserva(@RequestBody DatosRegistroReserva datosRegistroReserva){
        reservaRepository.save(new Reserva(datosRegistroReserva));

        }

    @GetMapping
    public Page<DatosListadoReserva> listadoDeReserva(@PageableDefault(size = 2) Pageable paginacion){
        return reservaRepository.findAll(paginacion).map(DatosListadoReserva::new);
    }

    @PutMapping
    @Transactional
    public void actualizarReserva(@RequestBody @Valid DatosActualizarReserva datosActualizarReserva){
        Reserva reserva = reservaRepository.getReferenceById(datosActualizarReserva.id());
        reserva.actualizarDatos(datosActualizarReserva);
    }


}
