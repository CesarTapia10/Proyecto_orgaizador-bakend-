package pe.edu.upc.proyectoverano.dtos;

public class CantidaDeUsuarioConTareasyProyectosDTO {
    private String username;
    private int cantidad_tareas;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCantidad_tareas() {
        return cantidad_tareas;
    }

    public void setCantidad_tareas(int cantidad_tareas) {
        this.cantidad_tareas = cantidad_tareas;
    }
}
