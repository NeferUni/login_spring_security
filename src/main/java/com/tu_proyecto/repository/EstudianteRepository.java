package com.tu_proyecto.repository;

import com.tu_proyecto.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Estudiante findByNombre(String nombre);
}
