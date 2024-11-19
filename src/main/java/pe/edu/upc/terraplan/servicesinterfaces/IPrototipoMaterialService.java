package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.terraplan.entities.Prototipo;
import pe.edu.upc.terraplan.entities.PrototipoMaterial;

import java.util.List;

public interface IPrototipoMaterialService {
    public List<PrototipoMaterial> list() ;
    public void insert(PrototipoMaterial prototipoMaterial) ;
    public void update(PrototipoMaterial prototipoMaterial) ;
    public void delete(int id) ;
    PrototipoMaterial findById(int id);
}
