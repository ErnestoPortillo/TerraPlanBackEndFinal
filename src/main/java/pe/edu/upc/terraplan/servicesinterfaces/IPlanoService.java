package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.entities.Plano;

import java.util.List;

public interface IPlanoService {
    public List<Plano> list();
    public void insert(Plano plano);
    public void update(Plano plano);
    public void delete(int id);
    Plano findById(int id);
}
