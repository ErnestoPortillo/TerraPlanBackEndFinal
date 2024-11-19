package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.ComentarioDTO;
import pe.edu.upc.terraplan.dtos.EvaluacionDTO;
import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.entities.Evaluacion;
import pe.edu.upc.terraplan.servicesinterfaces.IEvalucionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evaluacion")
public class EvaluacionController {
    @Autowired
    private IEvalucionService eS;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<EvaluacionDTO> listar() {
        return eS.list().stream().map(evaluacion -> {
            ModelMapper m = new ModelMapper();
            EvaluacionDTO dto = m.map(evaluacion, EvaluacionDTO.class);

            // Mapear los campos idTerreno y descripcionTerreno desde el terreno asociado
            if (evaluacion.getTerreno() != null) {
                dto.setIdTerreno(evaluacion.getTerreno().getIdTerreno());
                dto.setDescripcionTerreno(evaluacion.getTerreno().getDescripcionTerreno());
            }
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void insertar(@RequestBody EvaluacionDTO dto) {
        ModelMapper m= new ModelMapper();
        Evaluacion evaluacion= m.map(dto, Evaluacion.class);
        eS.insert(evaluacion);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void modificar(@PathVariable("id") int id, @RequestBody EvaluacionDTO evaluacionDTO) {
        ModelMapper m = new ModelMapper();
        Evaluacion e = m.map(evaluacionDTO, Evaluacion.class);

        // Asignar el ID de la URL al objeto Evaluacion
        e.setIdEvaluacion(id);

        eS.update(e);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void eliminar(@PathVariable ("id")Integer id){
        eS.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public EvaluacionDTO findById(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        Evaluacion evaluacion = eS.findById(id);
        return modelMapper.map(evaluacion, EvaluacionDTO.class);
    }
}
