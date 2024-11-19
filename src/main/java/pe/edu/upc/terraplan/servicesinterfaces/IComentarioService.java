package pe.edu.upc.terraplan.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.terraplan.dtos.ComentarioCountByProyectoDTO;
import pe.edu.upc.terraplan.dtos.ComentarioCountDTO;
import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.entities.Permiso;

import java.util.List;

public interface IComentarioService {
    public List<Comentario> list();
    public void insert(Comentario comentario);
    public void update(Comentario comentario);
    public void delete(int id);
    public List<Object[]> contarComentariosPorUsuarioRaw( Long idUsuario);
    List<ComentarioCountByProyectoDTO> contarComentariosPorProyecto(int idProyecto);
    Comentario findById(int id);
}