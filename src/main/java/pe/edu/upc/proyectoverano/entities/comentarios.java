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
@Table(name = "comentarios")
public class comentarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "contenido",nullable = false)
    private String contenido;

    @Column(name = "fecha_creacion",nullable = false)
    private LocalDate fecha_creacion;

    @ManyToOne
    @JoinColumn(name = "tareas_id" , nullable = false)
    private Tareas tareas;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private Usuario user;

    public comentarios(){

    }

    public comentarios(LocalDate fecha_creacion, int id, String contenido, Tareas tareas, Usuario user) {
        this.fecha_creacion = fecha_creacion;
        this.id = id;
        this.contenido = contenido;
        this.tareas = tareas;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Tareas getTareas() {
        return tareas;
    }

    public void setTareas(Tareas tareas) {
        this.tareas = tareas;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
