package pe.edu.upc.proyectoverano.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.proyectoverano.entities.Colaboradores;
import pe.edu.upc.proyectoverano.repositories.IColaboradoresRepository;
import pe.edu.upc.proyectoverano.serviceinterfaces.IColaboradoresService;

import java.util.List;

@Service
public class ColaboradoresServiceImplements implements IColaboradoresService {
    @Autowired
    private IColaboradoresRepository cR;

    @Override
    public void insert(Colaboradores colaboradores) {
        cR.save(colaboradores);
    }

    @Override
    public List<Colaboradores> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int idcolaboradores) {
        cR.deleteById(idcolaboradores);
    }

    @Override
    public Colaboradores listId(int idcolaboradores) {
        return cR.findById(idcolaboradores).orElse(new Colaboradores());
    }

    @Override
    public void update(Colaboradores colaboradores) {
        cR.save(colaboradores);
    }
}
