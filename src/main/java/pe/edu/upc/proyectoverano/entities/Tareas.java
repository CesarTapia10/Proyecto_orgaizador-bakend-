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
@Table(name = "Tareas")
public class Tareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo",nullable = false)
    private String titulo;

    @Column(name = "descripcion",nullable = false)
    private String descripcion;

    @Column(name = "estado",nullable = false)
    private String estado;

    @Column(name = "fecha_limite",nullable = false)
    private LocalDate fecha_limite;
    @Column(name = "fecha_creacion",nullable = false)
    private LocalDate fecha_creacion;
    @Column(name = "fecha_actualizacion ",nullable = false)
    private LocalDate fecha_actualizacion ;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private Usuario user;

    public Tareas(){

    }

    public Tareas(int id, String titulo, String estado, String descripcion, LocalDate fecha_limite, LocalDate fecha_creacion, Usuario user, LocalDate fecha_actualizacion) {
        this.id = id;
        this.titulo = titulo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.fecha_limite = fecha_limite;
        this.fecha_creacion = fecha_creacion;
        this.user = user;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(LocalDate fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public LocalDate getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(LocalDate fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
