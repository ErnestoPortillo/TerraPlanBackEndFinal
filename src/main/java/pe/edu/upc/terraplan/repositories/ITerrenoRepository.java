package pe.edu.upc.terraplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.terraplan.entities.Terreno;

import java.util.List;

@Repository
public interface ITerrenoRepository extends JpaRepository<Terreno,Integer> {
    @Query(value ="SELECT t.ubicacion_terreno, COUNT(*) AS num_terrenos\n" +
            "FROM terreno t\n" +
            "GROUP BY t.ubicacion_terreno;" ,nativeQuery = true)
    public List<String[]>cantidadTerrenosUbicacion();
}
