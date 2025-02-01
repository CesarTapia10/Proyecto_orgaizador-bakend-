package pe.edu.upc.proyectoverano.serviceinterfaces;

import pe.edu.upc.proyectoverano.entities.Usuario;

import java.util.List;

public interface IUserService {
    public void insert(Usuario usuario);

    public List<Usuario> list();

    public void delete(Long idUsuario);

    public Usuario listarId(Long idUsuario);

    public void updateUser(Usuario user);

    public List<Usuario> searchUser(String email);

    public  List<Usuario> searchByMail(String email);

    void insertarUsuarioConRol(String email, String password,
                               String username);
    public List<Usuario> listByRole(String roleName);
}
