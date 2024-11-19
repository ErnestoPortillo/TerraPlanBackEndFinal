package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.RolDTO;
import pe.edu.upc.terraplan.entities.Rol;
import pe.edu.upc.terraplan.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private IRolService rolService;

    // Método GET para listar todos los roles
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<RolDTO> listar() {
        return rolService.list().stream().map(rol -> {
            // Crear una instancia del DTO
            RolDTO rolDTO = new RolDTO();

            // Mapear los campos comunes usando ModelMapper
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.map(rol, rolDTO);

            // Asignar el nombre del usuario manualmente
            rolDTO.setNombreUsuario(rol.getUsuario() != null ? rol.getUsuario().getNombreCompleto() : "No asignado");

            return rolDTO;
        }).collect(Collectors.toList());
    }

    // Método POST para registrar un nuevo rol
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void registrar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rolService.insert(rol);
    }

    // Método PUT para modificar un rol existente
    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol rol = m.map(dto, Rol.class);
        rolService.update(rol);
    }

    // Método DELETE para eliminar un rol por ID
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void eliminar(@PathVariable("id") Integer id) {
        rolService.delete(id);
    }
}
