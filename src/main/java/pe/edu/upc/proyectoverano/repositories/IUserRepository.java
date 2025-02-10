package pe.edu.upc.proyectoverano.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.proyectoverano.entities.Usuario;

import java.util.List;

@Repository
public interface IUserRepository  extends JpaRepository<Usuario, Long> {
    public Usuario findOneByUsername(String username);

    Usuario findByUsername(String username);

    //BUSCAR POR NOMBRE
    @Query("select count(u.username) from Usuario u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);


    @Query("SELECT u FROM Usuario u JOIN u.roles r WHERE r.rol = :roleName")
    List<Usuario> findByRoleName(@Param("roleName") String roleName);

    @Query("SELECT d FROM Usuario d WHERE d.email LIKE %:email%")
    public List<Usuario> buscarPorEmail2(@Param("email") String email);


    @Query(value= "SELECT *\n" +
            "FROM public.usuario\n" +
            " WHERE email LIKE %:email%",nativeQuery = true)
    public List<Usuario> buscarPorEmail(@Param("email") String email);






    @Modifying
    @Transactional
    @Query(value = "CALL insertar_usuario_con_rol(:email, :password, :username)", nativeQuery = true)
    void insertarUsuarioConRol(@Param("email") String email,
                               @Param("password") String password,
                               @Param("username") String username);


}
