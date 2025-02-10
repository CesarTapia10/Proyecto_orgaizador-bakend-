package pe.edu.upc.proyectoverano.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.proyectoverano.entities.ProyectosconTareas;
import pe.edu.upc.proyectoverano.repositories.IProyectosRepository;
import pe.edu.upc.proyectoverano.repositories.IProyectosTareasRepository;
import pe.edu.upc.proyectoverano.serviceinterfaces.IProyectosTareasService;

import java.util.List;

@Service
public class ProyectosTareasServiceImplements implements IProyectosTareasService {
    @Autowired
    private IProyectosTareasRepository ptR;

    @Override
    public void insert(ProyectosconTareas proyectosconTareas) {
        ptR.save(proyectosconTareas);
    }

    @Override
    public List<ProyectosconTareas> list() {
        return ptR.findAll();
    }

    @Override
    public void delete(int idMproyectosconTareas) {
        ptR.deleteById(idMproyectosconTareas);
    }

    @Override
    public ProyectosconTareas listId(int idproyectosconTareas) {
        return ptR.findById(idproyectosconTareas).orElse(new ProyectosconTareas());
    }

    @Override
    public void update(ProyectosconTareas proyectosconTareas) {
        ptR.save(proyectosconTareas);
    }

    @Override
    public List<String[]> cantidaddetareasporusuarioconproyecto() {
        return ptR.cantidaddetareasporusuarioconproyecto();
    }
}
