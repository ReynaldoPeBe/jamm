package com.core.jamm.app.jamm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * Predio
 */
@Entity
@Table(name = "predios")
@Data
public class Predio implements Serializable{
    /**
    *
    */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition="TEXT")
    private String svg;

    private String foto;

    private String ubicacion;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name = "nombre_predio")
    private String nombrePredio;

    
}