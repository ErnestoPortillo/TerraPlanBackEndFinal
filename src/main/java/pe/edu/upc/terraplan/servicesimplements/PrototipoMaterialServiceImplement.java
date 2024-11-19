package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.entities.PrototipoMaterial;
import pe.edu.upc.terraplan.repositories.IPrototipoMaterialRepository;
import pe.edu.upc.terraplan.servicesinterfaces.IPrototipoMaterialService;

import java.util.List;
import java.util.Optional;

@Service
public class PrototipoMaterialServiceImplement implements IPrototipoMaterialService {
    @Autowired
    private IPrototipoMaterialRepository prototipoMaterialRepository;

    @Override
    public List<PrototipoMaterial> list() {
        return prototipoMaterialRepository.findAll();
    }

    @Override
    public void insert(PrototipoMaterial prototipoMaterial) {
        prototipoMaterialRepository.save(prototipoMaterial);
    }

    @Override
    public void update(PrototipoMaterial prototipoMaterial) {
        prototipoMaterialRepository.save(prototipoMaterial);
    }

    @Override
    public void delete(int id) {
        prototipoMaterialRepository.deleteById(id);
    }

    @Override
    public PrototipoMaterial findById(int id) {
        Optional<PrototipoMaterial> optional = prototipoMaterialRepository.findById(id);
        return optional.orElse(null);  // Manejar excepción si es necesario
    }
}
