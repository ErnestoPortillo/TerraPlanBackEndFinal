package pe.edu.upc.terraplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.terraplan.dtos.ComentarioCountByProyectoDTO;
import pe.edu.upc.terraplan.entities.Comentario;


import java.util.List;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario, Integer> {

    //QUERY1 -NUMERO DE COMENTARIO POR USUARIO
    @Query(value = "SELECT u.nombre_completo AS nombreUsuario, COUNT(c.id_comentario) AS cantidadComentarios " +
            "FROM comentario c JOIN usuario u ON c.id_usuario = u.id_usuario " +
            "WHERE u.id_usuario = :idUsuario " +
            "GROUP BY u.nombre_completo", nativeQuery = true)
    List<Object[]> contarComentariosPorUsuarioRaw(@Param("idUsuario") Long idUsuario);



    //Query Angie
    @Query("SELECT new pe.edu.upc.terraplan.dtos.ComentarioCountByProyectoDTO(p.nombreProyecto, COUNT(c.idComentario)) " +
            "FROM Comentario c " +
            "JOIN c.proyecto p " +
            "WHERE p.idProyecto = :idProyecto " +
            "GROUP BY p.nombreProyecto")
    List<ComentarioCountByProyectoDTO> contarComentariosPorProyecto(@Param("idProyecto") int idProyecto);
}