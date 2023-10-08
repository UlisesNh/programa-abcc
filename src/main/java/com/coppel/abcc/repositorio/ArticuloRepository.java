package com.coppel.abcc.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.coppel.abcc.modelo.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    Optional<Articulo> findBySku(String sku);
}