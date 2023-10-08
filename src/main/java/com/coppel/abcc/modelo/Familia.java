package com.coppel.abcc.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "familias")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_familia")
    private Integer numeroFamilia;

    @Column(name = "nombre_familia")
    private String nombreFamilia;

    @ManyToOne
    @JoinColumn(name = "clase_id")
    private Clase clase;

  
}
