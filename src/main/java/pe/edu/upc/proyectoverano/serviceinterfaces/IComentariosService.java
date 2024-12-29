package pe.edu.upc.proyectoverano.serviceinterfaces;

import pe.edu.upc.proyectoverano.entities.comentarios;

import java.util.List;

public interface IComentariosService {
    public void insert(comentarios comentarios);
    public List<comentarios> list();
    public void delete(int idcomentarios);
    public comentarios listId(int idcomentarios);
    public void update(comentarios comentarios);
}
