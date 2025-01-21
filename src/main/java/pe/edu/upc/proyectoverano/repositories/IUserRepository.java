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


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    @Query("SELECT d FROM Usuario d WHERE d.email LIKE %:email%")
    public List<Usuario> buscarPorEmail(@Param("email") String email);


    @Query("SELECT d FROM Usuario d WHERE d.email =:email")
    public List<Usuario> buscarPorEmail2(@Param("email") String email);

    @Modifying
    @jakarta.transaction.Transactional
    @Query(value = "CALL insertar_usuario_con_rol(:email, :password, :username)", nativeQuery = true)
    void insertarUsuarioConRol(@Param("email") String email,
                               @Param("password") String password,
                               @Param("username") String username);


}
