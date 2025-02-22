package pe.edu.upc.proyectoverano.serviceinterfaces;

import pe.edu.upc.proyectoverano.entities.roles;
import java.util.List;

public interface IRoleService {
    public void insert(roles rol);

    public List<roles> list();
    public void update(roles role);

    public void delete(Long idRol);

    public roles listarId(Long idRol);

    public List<roles> buscar(String rol);
}
