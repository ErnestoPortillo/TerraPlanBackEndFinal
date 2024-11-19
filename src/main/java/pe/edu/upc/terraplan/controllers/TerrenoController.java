package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.EvaluacionDTO;
import pe.edu.upc.terraplan.dtos.TerrenoCountByDepartamentoDTO;
import pe.edu.upc.terraplan.dtos.TerrenoDTO;
import pe.edu.upc.terraplan.entities.Evaluacion;
import pe.edu.upc.terraplan.entities.Terreno;
import pe.edu.upc.terraplan.servicesinterfaces.ITerrenoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("terreno")
public class TerrenoController {
    @Autowired
    private ITerrenoService terrenoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<TerrenoDTO> listarTerrenos() {
        return terrenoService.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            TerrenoDTO terrenoDTO = m.map(x, TerrenoDTO.class);

            // Mapear manualmente el nombre del proyecto si está disponible
            if (x.getProyecto() != null) {
                terrenoDTO.setNombreProyecto(x.getProyecto().getNombreProyecto());
            }

            return terrenoDTO;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void insertar(@RequestBody TerrenoDTO terrenoDTO){
        ModelMapper m= new ModelMapper();
        Terreno t=m.map(terrenoDTO, Terreno.class);
        terrenoService.insert(t);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void modificar(@PathVariable("id") int id, @RequestBody TerrenoDTO terrenoDTO) {
        ModelMapper m = new ModelMapper();

        // Mapear DTO a entidad
        Terreno terreno = m.map(terrenoDTO, Terreno.class);

        // Establecer el ID en la entidad (asegurándonos de que coincida con la URL)
        terreno.setIdTerreno(id);

        terrenoService.update(terreno);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void eliminar(@PathVariable ("id")Integer id){
        terrenoService.delete(id);
    }

    @GetMapping("/terrenos_departamento") //funciona
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<TerrenoCountByDepartamentoDTO>cantidadTerrenosDepartamento(){
        List<String[]>lista=terrenoService.CantidadTerrenosUbicaicon();
        List<TerrenoCountByDepartamentoDTO>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            TerrenoCountByDepartamentoDTO dto=new TerrenoCountByDepartamentoDTO();
            dto.setUbicacionTerreno(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public TerrenoDTO findById(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        Terreno terreno = terrenoService.findById(id);
        return modelMapper.map(terreno, TerrenoDTO.class);
    }
}
