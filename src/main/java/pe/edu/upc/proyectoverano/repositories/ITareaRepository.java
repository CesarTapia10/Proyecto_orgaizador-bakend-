package pe.edu.upc.proyectoverano.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyectoverano.entities.Tareas;

import java.util.List;

@Repository
public interface ITareaRepository extends JpaRepository<Tareas,Integer> {
    //tareas realizadas y no realizadas
    @Query(value = "SELECT t.estado, COUNT(t) \n" +
            "FROM Tareas t \n" +
            "WHERE t.estado IN ('realizado', 'no realizado') \n" +
            "GROUP BY t.estado",nativeQuery = true)
    public List<String[]> verlastareasrealizadasynoralizadas();
}
