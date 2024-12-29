package pe.edu.upc.proyectoverano.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.proyectoverano.dtos.ProyectosTareasDTO;
import pe.edu.upc.proyectoverano.entities.ProyectosconTareas;
import pe.edu.upc.proyectoverano.repositories.IProyectosTareasRepository;
import pe.edu.upc.proyectoverano.serviceinterfaces.IProyectosTareasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proyectoscontareas")
public class ProyectosTareasController {
    @Autowired
    private IProyectosTareasService ptR;


    @GetMapping
    public List<ProyectosTareasDTO> listar(){
        return ptR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ProyectosTareasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ProyectosTareasDTO dto) {
        ModelMapper m = new ModelMapper();
        ProyectosconTareas pt = m.map(dto, ProyectosconTareas.class);
        ptR.insert(pt);
    }

    @GetMapping("/{id}")
    public ProyectosTareasDTO listarId(Integer id){
        ModelMapper m = new ModelMapper();
        ProyectosTareasDTO dto=m.map(ptR.listId(id),ProyectosTareasDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody ProyectosTareasDTO dto) {
        ModelMapper m = new ModelMapper();
        ProyectosconTareas pt = m.map(dto, ProyectosconTareas.class);
        ptR.update(pt);
    }
}
