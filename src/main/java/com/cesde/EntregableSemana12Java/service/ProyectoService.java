package com.cesde.EntregableSemana12Java.service;

import com.cesde.EntregableSemana12Java.entity.Proyecto;
import com.cesde.EntregableSemana12Java.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    // Obtener todos los proyectos
    public List<Proyecto> obtenerTodosLosProyectos() {
        return proyectoRepository.findAll();
    }

    // Obtener un proyecto por su ID
    public Optional<Proyecto> obtenerProyectoPorId(Long id) {
        return proyectoRepository.findById(id);
    }

    // Crear un nuevo proyecto
    public Proyecto crearProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    // Actualizar un proyecto existente
    public Proyecto actualizarProyecto(Long id, Proyecto proyectoActualizado) {
        if (proyectoRepository.existsById(id)) {
            proyectoActualizado.setId(id);
            return proyectoRepository.save(proyectoActualizado);
        }
        return null; // Retorna null si el proyecto no existe
    }

    // Eliminar un proyecto por su ID
    public boolean eliminarProyecto(Long id) {
        if (proyectoRepository.existsById(id)) {
            proyectoRepository.deleteById(id);
            return true;
        }
        return false; // Retorna false si el proyecto no existe
    }
}
