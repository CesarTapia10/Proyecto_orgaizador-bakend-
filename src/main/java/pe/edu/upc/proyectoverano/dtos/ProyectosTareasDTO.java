package pe.edu.upc.proyectoverano.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.proyectoverano.entities.Proyectos;
import pe.edu.upc.proyectoverano.entities.Tareas;

import java.time.LocalDate;

public class ProyectosTareasDTO {
    private int id;

    private LocalDate fecha_creacion;

    private LocalDate fecha_modifiacion;

    private Proyectos proyectos;

    private Tareas tareas;

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha_modifiacion() {
        return fecha_modifiacion;
    }

    public void setFecha_modifiacion(LocalDate fecha_modifiacion) {
        this.fecha_modifiacion = fecha_modifiacion;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public Tareas getTareas() {
        return tareas;
    }

    public void setTareas(Tareas tareas) {
        this.tareas = tareas;
    }
}

