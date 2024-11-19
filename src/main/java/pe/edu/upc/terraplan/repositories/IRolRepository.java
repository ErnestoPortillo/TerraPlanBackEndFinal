package pe.edu.upc.terraplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.terraplan.entities.Rol;
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
}
