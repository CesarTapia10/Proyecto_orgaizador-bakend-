package pe.edu.upc.proyectoverano.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyectoverano.entities.ProyectosconTareas;

@Repository
public interface IProyectosTareasRepository extends JpaRepository<ProyectosconTareas,Integer> {
}
