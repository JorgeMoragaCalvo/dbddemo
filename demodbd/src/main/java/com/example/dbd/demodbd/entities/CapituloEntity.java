package com.example.dbd.demodbd.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CapituloEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idCapitulo;

    @Column(name = "titulo")
    private String titulo;
    @Column(name = "numero")
    private int numero;
    @Column(name = "duracion")
    private String duracion;
    @Column(name = "nombre_archivo")
    private String nombre_archivo;

    @ManyToOne()
    @JoinColumn(name = "temporada_id")
    private TemporadaEntity temporadaEntity;

    @JsonBackReference
    public TemporadaEntity getTemporadaEntity() {
        return temporadaEntity;
    }

    public void setTemporadaEntity(TemporadaEntity temporadaEntity) {
        this.temporadaEntity = temporadaEntity;
    }

    public long getIdCapitulo() {
        return idCapitulo;
    }

    public void setIdCapitulo(long idCapitulo) {
        this.idCapitulo = idCapitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
