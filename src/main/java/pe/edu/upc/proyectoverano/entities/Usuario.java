package pe.edu.upc.proyectoverano.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.apache.commons.lang3.text.translate.UnicodeUnpairedSurrogateRemover;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(name = "pais",nullable = false)
    private String pais;

    @Column(length = 200)
    private String password;

    private Boolean enabled;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<roles> roles;

    @Column(name = "fecha_creacion")
    private LocalDate fecha_registro;

    @Column(name = "fecha_modificacion")
    private LocalDate fecha_modificacion;

    public Usuario(){

    }

    public Usuario(int id, String username, String email, String pais, Boolean enabled, String password, List<pe.edu.upc.proyectoverano.entities.roles> roles, LocalDate fecha_registro, LocalDate fecha_modificacion) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.pais = pais;
        this.enabled = enabled;
        this.password = password;
        this.roles = roles;
        this.fecha_registro = fecha_registro;
        this.fecha_modificacion = fecha_modificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<pe.edu.upc.proyectoverano.entities.roles> getRoles() {
        return roles;
    }

    public void setRoles(List<pe.edu.upc.proyectoverano.entities.roles> roles) {
        this.roles = roles;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public LocalDate getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(LocalDate fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
}
