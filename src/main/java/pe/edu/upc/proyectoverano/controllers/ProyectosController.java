package pe.edu.upc.proyectoverano.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.proyectoverano.dtos.ProyectosDTO;
import pe.edu.upc.proyectoverano.entities.Proyectos;
import pe.edu.upc.proyectoverano.serviceinterfaces.IProyetosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proyectos")
public class ProyectosController {
    @Autowired
    private IProyetosService cs;

    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping
    public List<ProyectosDTO> listar(){
        return cs.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ProyectosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ProyectosDTO dto) {
        ModelMapper m = new ModelMapper();
        Proyectos p = m.map(dto, Proyectos.class);
        cs.insert(p);
    }

    @GetMapping("/{id}")
    public ProyectosDTO listarId(Integer id){
        ModelMapper m = new ModelMapper();
        ProyectosDTO dto=m.map(cs.listId(id),ProyectosDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody ProyectosDTO dto) {
        ModelMapper m = new ModelMapper();
        Proyectos p = m.map(dto, Proyectos.class);
        cs.update(p);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        cs.delete(id);
    }
}
