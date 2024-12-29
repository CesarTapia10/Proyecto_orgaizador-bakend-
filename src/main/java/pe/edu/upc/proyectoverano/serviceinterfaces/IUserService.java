package pe.edu.upc.proyectoverano.serviceinterfaces;

import pe.edu.upc.proyectoverano.entities.Usuario;

import java.util.List;

public interface IUserService {
    public void insert(Usuario usuario);

    public List<Usuario> list();

    public void delete(Long idUsuario);

    public Usuario listarId(Long idUsuario);
}
