package pe.edu.upc.proyectoverano.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.proyectoverano.entities.roles;

import java.util.List;


@Repository
public interface IRoleRepository  extends JpaRepository<roles, Long> {
    @Query("SELECT r FROM roles r WHERE r.rol LIKE %:Tipo%")
    public List<roles> buscarRol(@Param("Tipo") String Tipo);
}
