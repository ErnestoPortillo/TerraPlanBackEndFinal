package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.MaterialDTO;
import pe.edu.upc.terraplan.dtos.PrototipoMaterialDTO;
import pe.edu.upc.terraplan.entities.Material;
import pe.edu.upc.terraplan.entities.PrototipoMaterial;
import pe.edu.upc.terraplan.servicesinterfaces.IMaterialService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private IMaterialService materialService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<MaterialDTO> listar() {
        return materialService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MaterialDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public  void insertar(@RequestBody MaterialDTO dto) {
        ModelMapper m = new ModelMapper();
        Material material=m.map(dto,Material.class);
        materialService.insert(material);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void modificar(@PathVariable("id") int id, @RequestBody MaterialDTO materialDTO) {
        ModelMapper m = new ModelMapper();
        Material material = m.map(materialDTO, Material.class);
        material.setIdMaterial(id); // Asignar el ID desde la URL
        materialService.update(material);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'ARQUITECTO')")
    public void elimina(@PathVariable ("id") Integer id){
        materialService.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public MaterialDTO findById(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        Material material = materialService.findById(id);
        return modelMapper.map(material, MaterialDTO.class);
    }
}
