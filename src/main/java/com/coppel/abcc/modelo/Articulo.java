package com.coppel.abcc.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String articulo;
    private String marca;
    private String modelo;
    private LocalDate fechaAlta;
    private Integer stock;
    private Integer cantidad;
    private Integer descontinuado;
    private LocalDate fechaBaja;

   
    public Articulo() {
    }

    
    public Articulo(String sku, String articulo, String marca, String modelo, LocalDate fechaAlta, Integer stock, Integer cantidad, Integer descontinuado, LocalDate fechaBaja) {
        this.sku = sku;
        this.articulo = articulo;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaAlta = fechaAlta;
        this.stock = stock;
        this.cantidad = cantidad;
        this.descontinuado = descontinuado;
        this.fechaBaja = fechaBaja;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getDescontinuado() {
        return descontinuado;
    }

    public void setDescontinuado(Integer descontinuado) {
        this.descontinuado = descontinuado;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
}
