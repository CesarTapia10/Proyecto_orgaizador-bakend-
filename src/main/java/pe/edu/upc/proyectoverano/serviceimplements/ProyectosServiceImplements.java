package pe.edu.upc.proyectoverano.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.proyectoverano.entities.Proyectos;
import pe.edu.upc.proyectoverano.repositories.IProyectosRepository;
import pe.edu.upc.proyectoverano.serviceinterfaces.IProyetosService;

import java.util.List;

@Service
public class ProyectosServiceImplements implements IProyetosService {
    @Autowired
    private IProyectosRepository pR;

    @Override
    public void insert(Proyectos proyectos) {
        pR.save(proyectos);
    }

    @Override
    public List<Proyectos> list() {
        return pR.findAll();
    }

    @Override
    public void delete(int idproyectos) {
        pR.deleteById(idproyectos);
    }

    @Override
    public Proyectos listId(int idproyectos) {
        return pR.findById(idproyectos).orElse(new Proyectos());
    }

    @Override
    public void update(Proyectos proyectos) {
        pR.save(proyectos);
    }
}
