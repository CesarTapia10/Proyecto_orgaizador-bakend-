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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.proyectoverano.dtos.RoleDTO;
import pe.edu.upc.proyectoverano.serviceinterfaces.IRoleService;
import pe.edu.upc.proyectoverano.entities.roles;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private IRoleService rR;

    @GetMapping
    public List<RoleDTO> listar(){
        return rR.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registrar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        roles r = m.map(dto, roles.class);
        rR.insert(r);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        rR.delete(id);
    }

    @GetMapping("/{id}")
    public RoleDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m=new ModelMapper();
        RoleDTO dto=m.map(rR.listarId(id),RoleDTO.class);
        return dto;
    }




}
