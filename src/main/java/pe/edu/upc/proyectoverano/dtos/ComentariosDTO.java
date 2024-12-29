package pe.edu.upc.proyectoverano.dtos;


import pe.edu.upc.proyectoverano.entities.Tareas;
import pe.edu.upc.proyectoverano.entities.Usuario;

import java.time.LocalDate;

public class ComentariosDTO {

    private int id;

    private String contenido;


    private LocalDate fecha_creacion;


    private Tareas tareas;


    private Usuario user;

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
