package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.entities.Notificacion;
import pe.edu.upc.terraplan.repositories.INotificacionRepository;
import pe.edu.upc.terraplan.servicesinterfaces.INotifacionService;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionServiceImplement implements INotifacionService {
    @Autowired
    private INotificacionRepository repositoryNotificacion;
    @Override
    public List<Notificacion> list() {
        return repositoryNotificacion.findAll();
    }

    @Override
    public void insert(Notificacion notificacion) {
        repositoryNotificacion.save(notificacion);
    }

    @Override
    public void delete(int id) {
        repositoryNotificacion.deleteById(id);
    }

    @Override
    public void update(Notificacion notificacion) {
        repositoryNotificacion.save(notificacion);
    }

    @Override
    public Notificacion findById(int id) {
        Optional<Notificacion> optional = repositoryNotificacion.findById(id);
        return optional.orElse(null);  // Manejar excepción si es necesario
    }
}
