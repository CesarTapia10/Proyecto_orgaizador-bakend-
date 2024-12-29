package pe.edu.upc.proyectoverano.serviceinterfaces;

import pe.edu.upc.proyectoverano.entities.Proyectos;

import java.util.List;

public interface IProyetosService {
    public void insert(Proyectos proyectos);
    public List<Proyectos> list();
    public void delete(int idproyectos);
    public Proyectos listId(int idproyectos);
    public void update(Proyectos proyectos);
}
