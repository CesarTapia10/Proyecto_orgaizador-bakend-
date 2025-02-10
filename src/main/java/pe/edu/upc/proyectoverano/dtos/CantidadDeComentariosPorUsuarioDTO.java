package pe.edu.upc.proyectoverano.dtos;

public class CantidadDeComentariosPorUsuarioDTO {
    private String username;
    private int cantidad_comentarios;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCantidad_comentarios() {
        return cantidad_comentarios;
    }

    public void setCantidad_comentarios(int cantidad_comentarios) {
        this.cantidad_comentarios = cantidad_comentarios;
    }
}
