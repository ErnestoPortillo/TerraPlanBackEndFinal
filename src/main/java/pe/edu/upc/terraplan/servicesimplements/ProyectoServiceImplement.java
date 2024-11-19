package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.dtos.ProyectoCountDTO;
import pe.edu.upc.terraplan.entities.Notificacion;
import pe.edu.upc.terraplan.entities.Proyecto;
import pe.edu.upc.terraplan.repositories.IProyectoRepository;
import pe.edu.upc.terraplan.servicesinterfaces.IProyectoService;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServiceImplement implements IProyectoService {

    @Autowired
    private IProyectoRepository pR;
    @Override
    public List<Proyecto> list() {
        return pR.findAll();
    }

    @Override
    public void insert(Proyecto proyecto) {
        pR.save(proyecto);
    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public void update(Proyecto proyecto) {
        pR.save(proyecto);
    }

    @Override
    public List<ProyectoCountDTO> contarProyectosPorUsuario(Long idUsuario) {
        return pR.contarProyectosPorUsuario(idUsuario);
    }

    @Override
    public List<String[]> contarPermisosDeProyectosPorUsuario(Long idUsuario) {
        return pR.permisosPorProyecto_Usuario(idUsuario);
    }

    @Override
    public List<String[]> contarPermisosDeProyectos() {
        return pR.permisosPorProyecto();
    }

    @Override
    public List<String[]> contarTerrenosDeProyectos() {
        return pR.numeroTerrenosProyecto();
    }

    @Override
    public List<String[]> contarTerrenosPorProyecto(int idProyecto) {
        return pR.contarTerrenosPorProyecto(idProyecto);
    }
    @Override
    public List<String[]> contarEstadosPorProyecto() {
        return pR.contarProyectosPorEstado();
    }

    @Override
    public List<String[]> listarProyectosPorEstado(String estado) {
        return pR.ListarProyectosPorEstado(estado);
    }

    @Override
    public Proyecto findById(int id) {
        Optional<Proyecto> optional = pR.findById(id);
        return optional.orElse(null);  // Manejar excepción si es necesario
    }
}
