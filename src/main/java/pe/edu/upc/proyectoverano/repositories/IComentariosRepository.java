package pe.edu.upc.proyectoverano.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyectoverano.entities.comentarios;

import java.util.List;

@Repository
public interface IComentariosRepository extends JpaRepository<comentarios,Integer> {
    @Query(value = "SELECT u.username, COUNT(c) AS cantidad_comentarios \n" +
            "FROM comentarios c \n" +
            "INNER JOIN Usuario u ON c.user_id = u.id \n" +
            "GROUP BY u.username\n" +
            "ORDER BY cantidad_comentarios DESC",nativeQuery = true)
    public List<String[]> cantidaddecomentariosporusuario();


}
