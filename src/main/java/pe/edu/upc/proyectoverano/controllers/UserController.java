package pe.edu.upc.proyectoverano.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.proyectoverano.dtos.UserDTO;
import pe.edu.upc.proyectoverano.dtos.UsersNoPassDTO;
import pe.edu.upc.proyectoverano.entities.Usuario;
import pe.edu.upc.proyectoverano.serviceinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private IUserService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/registroNoAuth")
    public void registrarNoAuth(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.insert(u);
    }

    @PostMapping
    public ResponseEntity<UserDTO> registrar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario us = m.map(dto, Usuario.class);
        String encodedPassword = passwordEncoder.encode(us.getPassword());
        us.setPassword(encodedPassword);
        Usuario newUser = uS.insert(us);
        UserDTO userResponse = m.map(newUser, UserDTO.class);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }
    @PutMapping
    public void modificar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuario u = m.map(dto, Usuario.class);
        String encodedPassword = passwordEncoder.encode(u.getPassword());
        u.setPassword(encodedPassword);
        uS.updateUser(u);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        uS.delete(id);
    }

    @GetMapping("/{id}")
    public UserDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.listarId(id), UserDTO.class);
        return dto;
    }

    @GetMapping
    public List<UserDTO> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @GetMapping("/buscarUsuario")
    public List<UserDTO> buscarUsuario(@RequestParam String email){
        return uS.searchUser(email).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/NoAuth/{email}")
    public List<UsersNoPassDTO> buscarUsuarioNoAuth(@PathVariable String email){
        return uS.searchUser(email).stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x, UsersNoPassDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO dto) {
        ModelMapper mapper = new ModelMapper();
        Usuario user = mapper.map(dto, Usuario.class);

        // Codificar la contraseña
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        // Llamar al procedimiento almacenado a través del repositorio
        uS.insertarUsuarioConRol(user.getEmail(), encodedPassword, user.getUsername());

        return ResponseEntity.ok("Usuario creado con rol correctamente");
    }

    @GetMapping("/role/{roleName}")
    public List<UserDTO> listByRole(@PathVariable("roleName") String roleName) {
        return uS.listByRole(roleName).stream().map(y -> {
            ModelMapper m = new ModelMapper();
            return m.map(y, UserDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/nombreusuario")
    public UserDTO encontraruser(@RequestParam String nombreuser){
        ModelMapper m = new ModelMapper();
        UserDTO dto = m.map(uS.finduser(nombreuser), UserDTO.class);
        return dto;
    }



}
