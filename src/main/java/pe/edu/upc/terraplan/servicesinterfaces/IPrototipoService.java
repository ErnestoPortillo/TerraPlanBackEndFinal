package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.terraplan.entities.Evaluacion;
import pe.edu.upc.terraplan.entities.Prototipo;

import java.util.List;

public interface IPrototipoService {
    public List<Prototipo> list();
    public void insert(Prototipo prototipo);
    public void delete(int id);
    public void update(Prototipo prototipo);
    public List<String[]>listaMaterialesId(int idPrototipo);
    public List<String[]>costoPrototipo(int idPrototipo);
    Prototipo findById(int id);
}
