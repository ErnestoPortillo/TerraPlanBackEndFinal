package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.EvaluacionDTO;
import pe.edu.upc.terraplan.dtos.PlanoDTO;
import pe.edu.upc.terraplan.entities.Evaluacion;
import pe.edu.upc.terraplan.entities.Plano;
import pe.edu.upc.terraplan.servicesinterfaces.IPlanoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plano")
public class PlanoController {
    @Autowired
    private IPlanoService planoService;
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<PlanoDTO> listar() {
        return planoService.list().stream().map(plano -> {
            ModelMapper m = new ModelMapper();
            PlanoDTO dto = m.map(plano, PlanoDTO.class);

            if (plano.getTerreno() != null) {
                dto.setIdTerreno(plano.getTerreno().getIdTerreno());
                dto.setDescripcionTerreno(plano.getTerreno().getDescripcionTerreno());
            }
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public  void insertar(@RequestBody PlanoDTO planoDTO) {
        ModelMapper m = new ModelMapper();
        Plano plano=m.map(planoDTO,Plano.class);
        planoService.insert(plano);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void modificar(@PathVariable("id") int id, @RequestBody PlanoDTO planoDTO) {
        ModelMapper m = new ModelMapper();

        // Mapear el DTO a la entidad
        Plano plano = m.map(planoDTO, Plano.class);

        // Asignar el ID recibido por parámetro
        plano.setIdPlano(id);

        // Llamar al servicio para actualizar
        planoService.update(plano);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")

    public void elimina(@PathVariable ("id") Integer id){
        planoService.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public PlanoDTO findById(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        Plano plano = planoService.findById(id);
        return modelMapper.map(plano, PlanoDTO.class);
    }
}
