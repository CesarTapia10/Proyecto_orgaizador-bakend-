package pe.edu.upc.proyectoverano.dtos;

import pe.edu.upc.proyectoverano.entities.Proyectos;
import pe.edu.upc.proyectoverano.entities.Usuario;

public class ColaboradoresDTO {

    private int id;

    private String representacion;

    private Proyectos proyectos;

    private Usuario user;

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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }
}
