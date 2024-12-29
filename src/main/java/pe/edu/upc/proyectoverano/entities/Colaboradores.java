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
@Table(name = "Colaboradores")
public class Colaboradores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "representacion",nullable = false)
    private String representacion;

    @ManyToOne
    @JoinColumn(name = "proyecto_id" , nullable = false)
    private Proyectos proyectos;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private Usuario user;

    public Colaboradores(){

    }

    public Colaboradores(int id, String representacion, Usuario user, Proyectos proyectos) {
        this.id = id;
        this.representacion = representacion;
        this.user = user;
        this.proyectos = proyectos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepresentacion() {
        return representacion;
    }

    public void setRepresentacion(String representacion) {
        this.representacion = representacion;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
