package pe.edu.upc.proyectoverano.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.proyectoverano.dtos.ColaboradoresDTO;
import pe.edu.upc.proyectoverano.entities.Colaboradores;
import pe.edu.upc.proyectoverano.serviceinterfaces.IColaboradoresService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradoresController {
    @Autowired
    private IColaboradoresService cS;
    @GetMapping
    public List<ColaboradoresDTO> listar(){
        return cS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ColaboradoresDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ColaboradoresDTO dto) {
        ModelMapper m = new ModelMapper();
        Colaboradores c = m.map(dto, Colaboradores.class);
        cS.insert(c);
    }

    @GetMapping("/{id}")
    public ColaboradoresDTO listarId(Integer id){
        ModelMapper m = new ModelMapper();
        ColaboradoresDTO dto=m.map(cS.listId(id),ColaboradoresDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody ColaboradoresDTO dto) {
        ModelMapper m = new ModelMapper();
        Colaboradores c = m.map(dto, Colaboradores.class);
        cS.update(c);
    }
}
