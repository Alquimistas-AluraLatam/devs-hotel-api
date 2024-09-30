package com.aluracursos.devshotel.controller;

import com.aluracursos.devshotel.domain.huesped.DatosActualizarHuesped;
import com.aluracursos.devshotel.domain.huesped.DatosHuesped;
import com.aluracursos.devshotel.domain.huesped.Huesped;
import com.aluracursos.devshotel.domain.reserva.DatosActualizarReserva;
import com.aluracursos.devshotel.domain.reserva.DatosListadoReserva;
import com.aluracursos.devshotel.domain.reserva.DatosRegistroReserva;
import com.aluracursos.devshotel.domain.reserva.Reserva;
import com.aluracursos.devshotel.repository.HuespedRepository;
import com.aluracursos.devshotel.repository.ReservaRepository;
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
    @Autowired
    private HuespedRepository huespedRepository;


    @PostMapping
    public void registrarReserva(@RequestBody DatosRegistroReserva datosRegistroReserva){
        DatosHuesped datosHuesped = datosRegistroReserva.huesped();

        // Buscar al huésped en la base de datos por su email
        Huesped huesped = huespedRepository.findByEmail(datosHuesped.email())
                .orElseGet(() -> {
                    // Si no existe, crear un nuevo Huesped usando el constructor que acepta el DTO
                    return huespedRepository.save(new Huesped(datosHuesped));
                });

        // Guardar la reserva
        reservaRepository.save(new Reserva(datosRegistroReserva, huesped));
    }

    @GetMapping
    public Page<DatosListadoReserva> listadoDeReserva(@PageableDefault(size = 5) Pageable paginacion){
        return reservaRepository.findAll(paginacion).map(DatosListadoReserva::new);
    }

    @PutMapping
    @Transactional
    public void actualizarReserva(@RequestBody @Valid DatosActualizarReserva datosActualizarReserva, DatosActualizarHuesped datosHuesped){
        Reserva reserva = reservaRepository.getReferenceById(datosActualizarReserva.id());
        reserva.actualizarDatos(datosActualizarReserva, datosHuesped);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarReserva(@PathVariable Long id) {
        Reserva reserva = reservaRepository.getReferenceById(id);

    }

}
