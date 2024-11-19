package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.terraplan.entities.Notificacion;

import java.util.List;

public interface INotifacionService {
    public List<Notificacion> list();
    public void insert(Notificacion notificacion);
    public void delete(int id);
    public void update(Notificacion notificacion);
    Notificacion findById(int id);
}
