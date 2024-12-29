package pe.edu.upc.proyectoverano.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyectoverano.entities.Proyectos;

@Repository
public interface IProyectosRepository extends JpaRepository<Proyectos,Integer> {
}
