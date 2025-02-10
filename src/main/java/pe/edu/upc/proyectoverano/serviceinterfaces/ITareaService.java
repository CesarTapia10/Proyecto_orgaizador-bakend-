package pe.edu.upc.proyectoverano.serviceinterfaces;

import pe.edu.upc.proyectoverano.entities.Tareas;

import java.util.List;

public interface ITareaService {
    public void insert(Tareas tareas);
    public List<Tareas> list();
    public void delete(int idtareas);
    public Tareas listId(int idtareas);
    public void update(Tareas tareas);
    public List<String[]> verlastareasrealizadasynoralizadas();
}
