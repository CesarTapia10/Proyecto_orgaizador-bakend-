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
    public void insert(Usuario usuario) {
        uR.save(usuario);
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
}
