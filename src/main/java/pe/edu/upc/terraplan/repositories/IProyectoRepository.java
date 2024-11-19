package pe.edu.upc.terraplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.terraplan.dtos.ProyectoCountDTO;
import pe.edu.upc.terraplan.dtos.TerrenoDTO;
import pe.edu.upc.terraplan.entities.Proyecto;

import java.util.List;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Integer> {

    // Query para contar proyectos por usuario
    @Query("SELECT new pe.edu.upc.terraplan.dtos.ProyectoCountDTO(p.usuarioProyecto.nombreCompleto, COUNT(p)) " +
            "FROM Proyecto p WHERE p.usuarioProyecto.idUsuario = :idUsuario GROUP BY p.usuarioProyecto.nombreCompleto")
    public List<ProyectoCountDTO> contarProyectosPorUsuario(@Param("idUsuario") Long idUsuario);

   @Query(value= "SELECT pr.nombre_proyecto as Nombre, Count(*) Num_permiso\n" +
           "From Proyecto pr\n" +
           "inner join  Permiso  pe on pr.id_proyecto= pe.id_proyecto\n" +
           "where pr.id_usuario=:idUsuario\n" +
           "Group by pr.nombre_proyecto",nativeQuery = true)
    public List<String[]>permisosPorProyecto_Usuario(@Param("idUsuario")Long idUsuario);

    @Query(value= "SELECT pr.id_usuario AS id_usuario,u.nombre_completo as usuario,pr.nombre_proyecto AS Nombre, COUNT(*) AS Num_permiso\n" +
            "FROM Proyecto pr\n" +
            "INNER JOIN Permiso pe ON pr.id_proyecto = pe.id_proyecto\n" +
            "INNER JOIN Usuario u On u.id_usuario= pr.id_usuario\n" +
            "GROUP BY pr.nombre_proyecto,pr.id_usuario,u.nombre_completo;",nativeQuery = true)
    public List<String[]>permisosPorProyecto();

    @Query(value = "SELECT p.id_proyecto, p.nombre_proyecto as Nombre, Count(*) AS num_Terrenos\n" +
            "FROM proyecto p\n" +
            "Join Terreno t on p.id_proyecto= t.id_proyecto\n" +
            "Group by p.id_proyecto, p.nombre_proyecto ",nativeQuery = true)
    public List<String[]>numeroTerrenosProyecto();

    @Query(value="SELECT t.*\n" +
            "FROM Terreno t\n" +
            "JOIN Proyecto p ON p.id_proyecto = t.id_proyecto\n" +
            "WHERE p.id_proyecto =:idProyecto;",nativeQuery = true)
    public List<String[]>contarTerrenosPorProyecto(@Param("idProyecto")  Integer idProyecto);

    @Query(value = "Select p.estado_proyecto as estado, Count(*)\n" +
            "FROM Proyecto p \n" +
            "Group by p.estado_proyecto", nativeQuery = true)
    public List<String[]> contarProyectosPorEstado();

    @Query(value="Select u.id_usuario,u.nombre_completo,p.nombre_proyecto,p.estado_proyecto\n" +
            "FROM Proyecto p \n" +
            "Join Usuario u on p.id_usuario= u.id_usuario\n" +
            "where p.estado_proyecto=:estadoProyecto\n" +
            "Group by  u.id_usuario,u.nombre_completo,p.nombre_proyecto,p.estado_proyecto",nativeQuery = true)
    public List<String[]>ListarProyectosPorEstado(@Param("estadoProyecto") String estadoProyecto);
}
