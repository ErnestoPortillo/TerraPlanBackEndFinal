package pe.edu.upc.terraplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.terraplan.entities.Prototipo;

import java.util.List;

@Repository
public interface IPrototipoRepository extends JpaRepository<Prototipo, Integer> {
    @Query(value = "select m.tipo_material,costo_material,pm.id_prototipo\n" +
            "From prototipo_material pm\n" +
            "Join material m on m.id_material=pm.id_material\n" +
            "where pm.id_prototipo=:idPrototipo\n" +
            "Group by m.tipo_material,costo_material,pm.id_prototipo\n",nativeQuery = true)
    public List<String[]>listaDeMateriales_prototipo(@Param("idPrototipo") Integer idPrototipo);

    @Query(value="SELECT pr.nombre_proyecto,\n" +
            "       t.id_terreno,\n" +
            "       t.ubicacion_terreno,\n" +
            "       pl.id_plano,\n" +
            "       pm.id_prototipo,\n" +
            "       SUM(m.costo_material) AS costo_total\n" +
            "FROM prototipo_material pm\n" +
            "JOIN material m ON m.id_material = pm.id_material\n" +
            "JOIN prototipo p ON p.id_prototipo = pm.id_prototipo\n" +
            "JOIN plano pl ON pl.id_plano = p.id_plano\n" +
            "JOIN terreno t ON t.id_terreno = pl.id_terreno\n" +
            "JOIN proyecto pr ON pr.id_proyecto = t.id_proyecto\n" +
            "WHERE pr.id_proyecto =:idProyecto\n" +
            "GROUP BY pr.nombre_proyecto,\n" +
            "         t.id_terreno,\n" +
            "         t.ubicacion_terreno,\n" +
            "         pl.id_plano,\n" +
            "         pm.id_prototipo;\n" +
            "\t\t ",nativeQuery = true)
    public List<String[]>prototipos_Proyectos(@Param("idProyecto")Integer idProyecto);
}
