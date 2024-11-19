package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.PermisoDTO;
import pe.edu.upc.terraplan.dtos.ProyectoDTO;
import pe.edu.upc.terraplan.entities.Permiso;
import pe.edu.upc.terraplan.entities.Proyecto;
import pe.edu.upc.terraplan.servicesinterfaces.IPermisoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/permiso")
public class PermisoController {
    @Autowired
    private IPermisoService permisoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<PermisoDTO> listar() {
        return permisoService.list().stream().map(permiso -> {
            PermisoDTO permisoDTO = new PermisoDTO();
            permisoDTO.setIdPermiso(permiso.getIdPermiso());
            permisoDTO.setNombrePermiso(permiso.getNombrePermiso());
            permisoDTO.setDescripcionPermiso(permiso.getDescripcionPermiso());
            permisoDTO.setFechaSubida(permiso.getFechaSubida());

            // Validar si el proyecto es null
            if (permiso.getProyecto() != null) {
                permisoDTO.setIdProyecto(permiso.getProyecto().getIdProyecto());
                permisoDTO.setNombreProyecto(permiso.getProyecto().getNombreProyecto());
            } else {
                permisoDTO.setIdProyecto(0); // Valor por defecto si no hay proyecto
                permisoDTO.setNombreProyecto("Sin Proyecto"); // Texto predeterminado
            }

            return permisoDTO;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")

    public  void insertar(@RequestBody PermisoDTO dto) {
        ModelMapper m = new ModelMapper();
        Permiso permiso=m.map(dto,Permiso.class);
        permisoService.insert(permiso);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void modificar(@PathVariable("id") int id, @RequestBody PermisoDTO permisoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Permiso permiso = modelMapper.map(permisoDTO, Permiso.class);
        permiso.setIdPermiso(id); // Asegurar que el ID coincida con el de la URL
        permisoService.update(permiso);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")

    public void elimina(@PathVariable ("id") Integer id){
        permisoService.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public PermisoDTO findById(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        Permiso permiso = permisoService.findById(id);
        return modelMapper.map(permiso, PermisoDTO.class);
    }
}
