package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.terraplan.entities.Notificacion;
import pe.edu.upc.terraplan.entities.Permiso;

import java.util.List;

public interface IPermisoService {
    public List<Permiso>list();
    public void insert(Permiso permiso);
    public void delete(int id);
    public void update(Permiso permiso);
    Permiso findById(int id);
}
