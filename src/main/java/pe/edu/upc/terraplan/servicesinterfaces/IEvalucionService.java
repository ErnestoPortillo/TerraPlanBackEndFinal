package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.entities.Evaluacion;

import java.util.List;

public interface IEvalucionService {
    public List<Evaluacion> list();
    public void insert(Evaluacion evaluacion);
    public void update(Evaluacion evaluacion);
    public void delete(int id);
    Evaluacion findById(int id);
}
