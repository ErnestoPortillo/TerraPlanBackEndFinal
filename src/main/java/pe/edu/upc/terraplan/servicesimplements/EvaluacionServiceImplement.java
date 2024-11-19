package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.entities.Evaluacion;
import pe.edu.upc.terraplan.repositories.IEvaluacionRepository;
import pe.edu.upc.terraplan.servicesinterfaces.IEvalucionService;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionServiceImplement implements IEvalucionService {
    @Autowired
    private IEvaluacionRepository eR;
    @Override
    public List<Evaluacion> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Evaluacion evaluacion) {
        eR.save(evaluacion);
    }

    @Override
    public void update(Evaluacion evaluacion) {
        eR.save(evaluacion);
    }

    @Override
    public void delete(int id) {
        eR.deleteById(id);
    }

    @Override
    public Evaluacion findById(int id) {
        Optional<Evaluacion> optional = eR.findById(id);
        return optional.orElse(null);  // Manejar excepción si es necesario
    }
}
