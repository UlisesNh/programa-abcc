package com.coppel.abcc.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name = "departamentos")
	public class Departamento {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "numero_departamento")
	    private Integer numeroDepartamento;

	    @Column(name = "nombre_departamento")
	    private String nombreDepartamento;

	    // Getters y setters
	}


