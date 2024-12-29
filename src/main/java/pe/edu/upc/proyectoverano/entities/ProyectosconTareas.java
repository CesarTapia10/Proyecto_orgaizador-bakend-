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
@Table(name = "ProyectosconTareas")
public class ProyectosconTareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha_creacion",nullable = false)
    private LocalDate fecha_creacion;

    @Column(name = "fecha_modifiacion",nullable = false)
    private LocalDate fecha_modifiacion;

    @Column(name = "catsimporte",nullable = false)
    private int catsimporte;

    @ManyToOne
    @JoinColumn(name = "proyectos_id" , nullable = false)
    private Proyectos proyectos;

    @ManyToOne
    @JoinColumn(name = "tareas_id" , nullable = false)
    private Tareas tareas;

    public ProyectosconTareas(){

    }

    public ProyectosconTareas(int id, LocalDate fecha_creacion, LocalDate fecha_modifiacion, int catsimporte, Proyectos proyectos, Tareas tareas) {
        this.id = id;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modifiacion = fecha_modifiacion;
        this.catsimporte = catsimporte;
        this.proyectos = proyectos;
        this.tareas = tareas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCatsimporte() {
        return catsimporte;
    }

    public void setCatsimporte(int catsimporte) {
        this.catsimporte = catsimporte;
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
