package com.aluracursos.devshotel.controller;

import com.aluracursos.devshotel.domain.huesped.DatosActualizarHuesped;
import com.aluracursos.devshotel.domain.huesped.DatosHuesped;
import com.aluracursos.devshotel.domain.huesped.DatosListadoHuesped;
import com.aluracursos.devshotel.domain.huesped.Huesped;
import com.aluracursos.devshotel.domain.reserva.DatosActualizarReserva;
import com.aluracursos.devshotel.domain.reserva.DatosListadoReserva;
import com.aluracursos.devshotel.domain.reserva.Reserva;
import com.aluracursos.devshotel.repository.HuespedRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/huesped")
public class HuespedController {
    @Autowired
    private HuespedRepository huespedRepository;

    @GetMapping
    public Page<DatosListadoHuesped> listadoDeHuesped(@PageableDefault(size = 5) Pageable paginacion) {
        return huespedRepository.findAll(paginacion).map(DatosListadoHuesped::new);
    }

    @PostMapping
    public void registrarHuesped(@RequestBody DatosHuesped datosHuesped) {
        huespedRepository.save(new Huesped(datosHuesped));
    }

    @PutMapping
    @Transactional
    public void actualizarHuesped(@RequestBody @Valid DatosActualizarHuesped datosActualizarHuesped) {
        Huesped huesped = huespedRepository.getReferenceById(datosActualizarHuesped.id());
        huesped.actualizarDatos(datosActualizarHuesped);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarReserva(@PathVariable Long id) {
        Huesped huesped = huespedRepository.getReferenceById(id);

    }
}