package pe.edu.upc.terraplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.terraplan.entities.Evaluacion;

@Repository
public interface IEvaluacionRepository extends JpaRepository<Evaluacion,Integer> {
}
