package pe.edu.upc.proyectoverano.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyectoverano.entities.ProyectosconTareas;

import java.util.List;

@Repository
public interface IProyectosTareasRepository extends JpaRepository<ProyectosconTareas,Integer> {
    @Query(value = "\n" +
            "SELECT u.username, COUNT(DISTINCT t.id) AS cantidad_tareas \n" +
            "FROM Tareas t \n" +
            "JOIN proyectoscon_tareas pt ON t.id = pt.tareas_id\n" +
            "JOIN Usuario u ON t.user_id = u.id \n" +
            "GROUP BY u.username \n" +
            "ORDER BY cantidad_tareas DESC",nativeQuery = true)
    public List<String[]> cantidaddetareasporusuarioconproyecto();
}
