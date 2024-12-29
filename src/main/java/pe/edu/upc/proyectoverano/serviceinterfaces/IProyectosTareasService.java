package pe.edu.upc.proyectoverano.serviceinterfaces;

import pe.edu.upc.proyectoverano.entities.ProyectosconTareas;

import java.util.List;

public interface IProyectosTareasService {
    public void insert(ProyectosconTareas proyectosconTareas);
    public List<ProyectosconTareas> list();
    public void delete(int idMproyectosconTareas);
    public ProyectosconTareas listId(int idproyectosconTareas);
    public void update(ProyectosconTareas proyectosconTareas);
}
