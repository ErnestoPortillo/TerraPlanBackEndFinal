package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.entities.Material;
import pe.edu.upc.terraplan.repositories.IMaterialRepository;
import pe.edu.upc.terraplan.servicesinterfaces.IMaterialService;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServiceImplement implements IMaterialService {
    @Autowired
    private IMaterialRepository materialRepository;

    @Override
    public List<Material> list(){return materialRepository.findAll();}

    @Override
    public void insert(Material material) {
        materialRepository.save(material);
    }

    @Override
    public void delete(int id) {
        materialRepository.deleteById(id);
    }

    @Override
    public void update(Material material) {
        materialRepository.save(material);
    }

    @Override
    public Material findById(int id) {
        Optional<Material> optional = materialRepository.findById(id);
        return optional.orElse(null);  // Manejar excepción si es necesario
    }
}
