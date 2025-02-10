package pe.edu.upc.proyectoverano.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.proyectoverano.dtos.TareaTotalRelizadaDTO;
import pe.edu.upc.proyectoverano.dtos.TareasDTO;
import pe.edu.upc.proyectoverano.entities.Tareas;
import pe.edu.upc.proyectoverano.serviceinterfaces.ITareaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tareas")

public class TareasController {
    @Autowired
    private ITareaService Ts;

    @GetMapping
    public List<TareasDTO> listar() {
        return Ts.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, TareasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody TareasDTO dto) {
        ModelMapper m = new ModelMapper();
        Tareas t = m.map(dto, Tareas.class);
        Ts.insert(t);
    }

    @GetMapping("/{id}")
    public TareasDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(Ts.listId(id), TareasDTO.class);
    }

    @PutMapping
    public void modificar(@RequestBody TareasDTO dto) {
        ModelMapper m = new ModelMapper();
        Tareas t = m.map(dto, Tareas.class);
        Ts.update(t);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        Ts.delete(id);
    }
    @GetMapping("/tareasconrealizacion")
    public List<TareaTotalRelizadaDTO> galeriareciente(){
        List<String[]> lista=Ts.verlastareasrealizadasynoralizadas();
        List<TareaTotalRelizadaDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            TareaTotalRelizadaDTO dto=new TareaTotalRelizadaDTO();
            dto.setEstado(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));

            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
