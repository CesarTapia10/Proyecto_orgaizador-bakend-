package pe.edu.upc.proyectoverano.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.proyectoverano.entities.comentarios;
import pe.edu.upc.proyectoverano.repositories.IComentariosRepository;
import pe.edu.upc.proyectoverano.serviceinterfaces.IComentariosService;

import java.util.List;

@Service
public class ComentariosServiceImplements implements IComentariosService {
    @Autowired
    private IComentariosRepository cR;

    @Override
    public void insert(comentarios comentarios) {
        cR.save(comentarios);
    }

    @Override
    public List<comentarios> list() {
        return cR.findAll();
    }

    @Override
    public void delete(int idcomentarios) {
        cR.deleteById(idcomentarios);
    }

    @Override
    public comentarios listId(int idcomentarios) {
        return cR.findById(idcomentarios).orElse(new comentarios());
    }

    @Override
    public void update(comentarios comentarios) {
        cR.save(comentarios);
    }
}
