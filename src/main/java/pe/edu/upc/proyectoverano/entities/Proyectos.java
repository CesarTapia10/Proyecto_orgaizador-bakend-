package pe.edu.upc.proyectoverano.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "Proyectos")
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre",nullable = false)
    private String nombre;

    @Column(name = "decripcion",nullable = false)
    private String decripcion;

    @Column(name = "fecha_creacion",nullable = false)
    private LocalDate fecha_creacion;

    @Column(name = "fecha_modifiacion",nullable = false)
    private LocalDate fecha_modifiacion;

    public Proyectos(){

    }

    public Proyectos(int id, String nombre, String decripcion, LocalDate fecha_creacion, LocalDate fecha_modifiacion) {
        this.id = id;
        this.nombre = nombre;
        this.decripcion = decripcion;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modifiacion = fecha_modifiacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDate getFecha_modifiacion() {
        return fecha_modifiacion;
    }

    public void setFecha_modifiacion(LocalDate fecha_modifiacion) {
        this.fecha_modifiacion = fecha_modifiacion;
    }
}
