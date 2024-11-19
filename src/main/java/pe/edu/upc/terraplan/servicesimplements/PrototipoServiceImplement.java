package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.entities.Prototipo;
import pe.edu.upc.terraplan.repositories.IPrototipoRepository;
import pe.edu.upc.terraplan.servicesinterfaces.IPrototipoService;

import java.util.List;
import java.util.Optional;

@Service()
public class PrototipoServiceImplement implements IPrototipoService {
    @Autowired
    private IPrototipoRepository prototipoRepository;

    @Override
    public List<Prototipo> list() {
        return prototipoRepository.findAll();
    }

    @Override
    public void insert(Prototipo prototipo) {
        prototipoRepository.save(prototipo);
    }

    @Override
    public void delete(int id) {
        prototipoRepository.deleteById(id);
    }

    @Override
    public void update(Prototipo prototipo) {
        prototipoRepository.save(prototipo);
    }

    @Override
    public List<String[]> listaMaterialesId(int idPrototipo) {
        return prototipoRepository.listaDeMateriales_prototipo(idPrototipo);
    }

    @Override
    public List<String[]> costoPrototipo(int idPrototipo) {
        return prototipoRepository.prototipos_Proyectos(idPrototipo);
    }
    @Override

    public Prototipo findById(int id) {
        Optional<Prototipo> optional = prototipoRepository.findById(id);
        return optional.orElse(null);  // Manejar excepción si es necesario
    }
}
