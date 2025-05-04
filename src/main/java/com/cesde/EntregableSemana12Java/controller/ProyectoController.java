package com.cesde.EntregableSemana12Java.controller;

import com.cesde.EntregableSemana12Java.entity.Proyecto;
import com.cesde.EntregableSemana12Java.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    // Obtener todos los proyectos
    @GetMapping
    public List<Proyecto> obtenerProyectos() {
        return proyectoRepository.findAll();
    }

    // Crear un nuevo proyecto
    @PostMapping
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    // Obtener un proyecto por ID
    @GetMapping("/{id}")
    public Proyecto obtenerProyectoPorId(@PathVariable Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    // Eliminar un proyecto por ID
    @DeleteMapping("/{id}")
    public String eliminarProyecto(@PathVariable Long id) {
        if (proyectoRepository.existsById(id)) {
            proyectoRepository.deleteById(id);
            return "Proyecto eliminado";
        }
        return "Proyecto no encontrado";
    }
}
