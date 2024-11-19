package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.terraplan.entities.Rol;

import java.util.List;
public interface IRolService {
    public List<Rol>list();
    public void insert(Rol rol);
    public void delete(int id);
    public void update(Rol rol);
}
