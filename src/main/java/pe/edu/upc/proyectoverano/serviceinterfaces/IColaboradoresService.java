package pe.edu.upc.proyectoverano.serviceinterfaces;

import pe.edu.upc.proyectoverano.entities.Colaboradores;

import java.util.List;

public interface IColaboradoresService {
    public void insert(Colaboradores colaboradores);
    public List<Colaboradores> list();
    public void delete(int idcolaboradores);
    public Colaboradores listId(int idcolaboradores);
    public void update(Colaboradores colaboradores);
}
