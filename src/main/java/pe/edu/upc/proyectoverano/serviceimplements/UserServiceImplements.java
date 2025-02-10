package pe.edu.upc.proyectoverano.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.proyectoverano.entities.Usuario;
import pe.edu.upc.proyectoverano.repositories.IUserRepository;
import pe.edu.upc.proyectoverano.serviceinterfaces.IUserService;

import java.util.List;

@Service
public class UserServiceImplements implements IUserService {
    @Autowired
    private IUserRepository uR;


    @Override
    public Usuario insert(Usuario usuario) {
        return uR.save(usuario);
    }

    @Override
    public List<Usuario> list() {
        return uR.findAll();
    }

    @Override
    public void delete(Long idUsuario) {
        uR.deleteById(idUsuario);
    }

    @Override
    public Usuario listarId(Long idUsuario) {
        return uR.findById(idUsuario).orElse(new Usuario());
    }

    @Override
    public void updateUser(Usuario user) {
        uR.save(user);
    }

    @Override
    public List<Usuario> searchUser(String email) {
        return uR.buscarPorEmail(email);
    }

    @Override
    public List<Usuario> searchByMail(String email) {
        return uR.buscarPorEmail2(email);
    }

    @Override
    public void insertarUsuarioConRol(String email, String password, String username) {
        uR.insertarUsuarioConRol(email,password,username);
    }
    @Override
    public List<Usuario> listByRole(String roleName) {
        return uR.findByRoleName(roleName);
    }

    @Override
    public Usuario finduser(String username) {
        return uR.findByUsername(username);
    }


}
