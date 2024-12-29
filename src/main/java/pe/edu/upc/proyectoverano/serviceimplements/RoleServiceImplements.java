package pe.edu.upc.proyectoverano.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.proyectoverano.repositories.IRoleRepository;
import pe.edu.upc.proyectoverano.serviceinterfaces.IRoleService;
import pe.edu.upc.proyectoverano.entities.roles;

import java.util.List;

@Service
public class RoleServiceImplements implements IRoleService {
    @Autowired
    private IRoleRepository rR;

    @Override
    public void insert(roles rol) {
        rR.save(rol);
    }

    @Override
    public List<roles> list() {
        return rR.findAll();
    }

    @Override
    public void delete(Long idRol) {
        rR.deleteById(idRol);
    }

    @Override
    public roles listarId(Long idRol) {
        return rR.findById(idRol).orElse(new roles());
    }
}
