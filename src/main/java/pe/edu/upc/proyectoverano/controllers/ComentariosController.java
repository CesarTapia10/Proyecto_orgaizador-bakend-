package pe.edu.upc.proyectoverano.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.proyectoverano.dtos.ComentariosDTO;
import pe.edu.upc.proyectoverano.serviceinterfaces.IComentariosService;


import pe.edu.upc.proyectoverano.entities.comentarios;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {
    @Autowired
    private IComentariosService cs;

    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping
    public List<ComentariosDTO> listar(){
        return cs.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ComentariosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ComentariosDTO dto) {
        ModelMapper m = new ModelMapper();
        comentarios c = m.map(dto, comentarios.class);
        cs.insert(c);
    }

    @GetMapping("/{id}")
    public ComentariosDTO listarId(Integer id){
        ModelMapper m = new ModelMapper();
        ComentariosDTO dto=m.map(cs.listId(id),ComentariosDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody ComentariosDTO dto) {
        ModelMapper m = new ModelMapper();
        comentarios c = m.map(dto, comentarios.class);
        cs.update(c);
    }
}
