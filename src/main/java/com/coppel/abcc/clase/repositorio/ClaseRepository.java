package com.coppel.abcc.clase.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coppel.abcc.modelo.Clase;
import com.coppel.abcc.modelo.Departamento;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
    List<Clase> findByDepartamento(Departamento departamento);
}
