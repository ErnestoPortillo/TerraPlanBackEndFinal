package pe.edu.upc.terraplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.terraplan.entities.Material;

@Repository
public interface IMaterialRepository extends JpaRepository<Material, Integer> {
}
