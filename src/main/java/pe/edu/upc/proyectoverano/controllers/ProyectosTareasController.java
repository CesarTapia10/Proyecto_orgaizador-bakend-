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
import pe.edu.upc.proyectoverano.dtos.CantidaDeUsuarioConTareasyProyectosDTO;
import pe.edu.upc.proyectoverano.dtos.CantidadDeComentariosPorUsuarioDTO;
import pe.edu.upc.proyectoverano.dtos.ProyectosTareasDTO;
import pe.edu.upc.proyectoverano.entities.ProyectosconTareas;
import pe.edu.upc.proyectoverano.repositories.IProyectosTareasRepository;
import pe.edu.upc.proyectoverano.serviceinterfaces.IProyectosTareasService;

import java.util.ArrayList;
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
    public ProyectosTareasDTO listarId(@PathVariable("id") Integer id){
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
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        ptR.delete(id);
    }

    @GetMapping("/CantidadDeUusarioConTareasYPoryectos")
    public List<CantidaDeUsuarioConTareasyProyectosDTO> galeriareciente(){
        List<String[]> lista=ptR.cantidaddetareasporusuarioconproyecto();
        List<CantidaDeUsuarioConTareasyProyectosDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            CantidaDeUsuarioConTareasyProyectosDTO dto=new CantidaDeUsuarioConTareasyProyectosDTO();
            dto.setUsername(columna[0]);
            dto.setCantidad_tareas(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
