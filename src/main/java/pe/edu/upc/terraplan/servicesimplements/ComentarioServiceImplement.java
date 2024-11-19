package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.dtos.ComentarioCountByProyectoDTO;
import pe.edu.upc.terraplan.dtos.ComentarioCountDTO;
import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.entities.Permiso;
import pe.edu.upc.terraplan.repositories.IComentarioRepository;
import pe.edu.upc.terraplan.servicesinterfaces.IComentarioService;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServiceImplement implements IComentarioService {

    @Autowired
    private IComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> list() {
        return comentarioRepository.findAll();
    }

    @Override
    public void insert(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public void update(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public void delete(int id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public List<Object[]> contarComentariosPorUsuarioRaw(Long idUsuario) {
        return comentarioRepository.contarComentariosPorUsuarioRaw(idUsuario);
    }

    @Override
    public List<ComentarioCountByProyectoDTO> contarComentariosPorProyecto(int idProyecto) {
        return comentarioRepository.contarComentariosPorProyecto(idProyecto);
    }

    @Override
    public Comentario findById(int id) {
        Optional<Comentario> optional = comentarioRepository.findById(id);
        return optional.orElse(null);  // Manejar excepción si es necesario
    }
}
