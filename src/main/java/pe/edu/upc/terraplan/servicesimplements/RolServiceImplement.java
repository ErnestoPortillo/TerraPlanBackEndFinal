package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.entities.Rol;
import pe.edu.upc.terraplan.repositories.IRolRepository;
import pe.edu.upc.terraplan.servicesinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository rolRepository;

    @Override
    public List<Rol> list(){return rolRepository.findAll();}


    @Override
    public void insert(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void delete(int rolId) {
        rolRepository.deleteById(rolId);
    }

    @Override
    public void update(Rol rol) {
        rolRepository.save(rol);

    }
}

