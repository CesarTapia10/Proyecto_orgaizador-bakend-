package pe.edu.upc.proyectoverano.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.proyectoverano.entities.Tareas;
import pe.edu.upc.proyectoverano.repositories.ITareaRepository;
import pe.edu.upc.proyectoverano.serviceinterfaces.ITareaService;

import java.util.List;

@Service
public class TareasServiceImplements implements ITareaService {
    @Autowired
    private ITareaRepository tR;

    @Override
    public void insert(Tareas tareas) {
        tR.save(tareas);
    }

    @Override
    public List<Tareas> list() {
        return tR.findAll();
    }

    @Override
    public void delete(int idtareas) {
        tR.deleteById(idtareas);
    }

    @Override
    public Tareas listId(int idtareas) {
        return tR.findById(idtareas).orElse(new Tareas());
    }

    @Override
    public void update(Tareas tareas) {
        tR.save(tareas);
    }
}
