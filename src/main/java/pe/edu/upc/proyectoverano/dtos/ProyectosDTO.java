package pe.edu.upc.proyectoverano.dtos;



import java.time.LocalDate;

public class ProyectosDTO {

    private int id;

    private String nombre;

    private String decripcion;

    private LocalDate fecha_creacion;

    private LocalDate fecha_modifiacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDate fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public LocalDate getFecha_modifiacion() {
        return fecha_modifiacion;
    }

    public void setFecha_modifiacion(LocalDate fecha_modifiacion) {
        this.fecha_modifiacion = fecha_modifiacion;
    }
}
