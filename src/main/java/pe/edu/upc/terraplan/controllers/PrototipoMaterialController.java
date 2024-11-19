package pe.edu.upc.terraplan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.PrototipoMaterialDTO;
import pe.edu.upc.terraplan.entities.Material;
import pe.edu.upc.terraplan.entities.Prototipo;
import pe.edu.upc.terraplan.entities.PrototipoMaterial;
import pe.edu.upc.terraplan.servicesinterfaces.IPrototipoMaterialService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/prototipos-material")
public class PrototipoMaterialController {

    @Autowired
    private IPrototipoMaterialService prototipoMaterialService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<PrototipoMaterialDTO> listar() {
        return prototipoMaterialService.list().stream().map(x -> {
            PrototipoMaterialDTO dto = new PrototipoMaterialDTO();

            dto.setIdPrototipoMaterial(x.getIdPrototipoMaterial());

            if (x.getPrototipo() != null) {
                dto.setIdPrototipo(x.getPrototipo().getIdPrototipo());
                dto.setDescripcionPrototipo(x.getPrototipo().getDescripcionPrototipo());
            }

            if (x.getMaterial() != null) {
                dto.setIdMaterial(x.getMaterial().getIdMaterial());
                dto.setDescripcionMaterial(x.getMaterial().getTipoMaterial());
            }

            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void insertar(@RequestBody PrototipoMaterialDTO dto) {
        PrototipoMaterial entity = new PrototipoMaterial();

        entity.setIdPrototipoMaterial(dto.getIdPrototipoMaterial());

        if (dto.getIdPrototipo() > 0) {
            Prototipo prototipo = new Prototipo();
            prototipo.setIdPrototipo(dto.getIdPrototipo());
            entity.setPrototipo(prototipo);
        }

        if (dto.getIdMaterial() > 0) {
            Material material = new Material();
            material.setIdMaterial(dto.getIdMaterial());
            entity.setMaterial(material);
        }

        prototipoMaterialService.insert(entity);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void modificar(@PathVariable("id") int id, @RequestBody PrototipoMaterialDTO dto) {
        PrototipoMaterial entity = new PrototipoMaterial();

        entity.setIdPrototipoMaterial(id);

        if (dto.getIdPrototipo() > 0) {
            Prototipo prototipo = new Prototipo();
            prototipo.setIdPrototipo(dto.getIdPrototipo());
            entity.setPrototipo(prototipo);
        }

        if (dto.getIdMaterial() > 0) {
            Material material = new Material();
            material.setIdMaterial(dto.getIdMaterial());
            entity.setMaterial(material);
        }

        prototipoMaterialService.update(entity);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void elimina(@PathVariable("id") Integer id) {
        prototipoMaterialService.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public PrototipoMaterialDTO findById(@PathVariable("id") int id) {
        PrototipoMaterial entity = prototipoMaterialService.findById(id);

        PrototipoMaterialDTO dto = new PrototipoMaterialDTO();

        dto.setIdPrototipoMaterial(entity.getIdPrototipoMaterial());

        if (entity.getPrototipo() != null) {
            dto.setIdPrototipo(entity.getPrototipo().getIdPrototipo());
            dto.setDescripcionPrototipo(entity.getPrototipo().getDescripcionPrototipo());
        }

        if (entity.getMaterial() != null) {
            dto.setIdMaterial(entity.getMaterial().getIdMaterial());
            dto.setDescripcionMaterial(entity.getMaterial().getTipoMaterial());
        }

        return dto;
    }
}
