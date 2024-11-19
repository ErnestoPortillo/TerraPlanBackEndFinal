package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.*;
import pe.edu.upc.terraplan.entities.Notificacion;
import pe.edu.upc.terraplan.entities.Proyecto;
import pe.edu.upc.terraplan.servicesinterfaces.IProyectoService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {
    @Autowired
    private IProyectoService proyectoService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<ProyectoDTO> listar() {
        return proyectoService.list().stream().map(proyecto -> {
            // Crear instancia de ModelMapper
            ModelMapper modelMapper = new ModelMapper();

            // Mapear las propiedades principales del Proyecto a ProyectoDTO
            ProyectoDTO proyectoDTO = modelMapper.map(proyecto, ProyectoDTO.class);

            // Asignar manualmente los campos relacionados con el Usuario
            if (proyecto.getUsuarioProyecto() != null) {
                proyectoDTO.setIdUsuario(proyecto.getUsuarioProyecto().getIdUsuario());
                proyectoDTO.setNombreUsuario(proyecto.getUsuarioProyecto().getNombreCompleto());
            }

            return proyectoDTO;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")

    public  void insertar(@RequestBody ProyectoDTO dto) {
        ModelMapper m = new ModelMapper();
        Proyecto proyecto=m.map(dto, Proyecto.class);
        proyectoService.insert(proyecto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void modificar(@PathVariable("id") int id, @RequestBody ProyectoDTO proyectoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Proyecto proyecto = modelMapper.map(proyectoDTO, Proyecto.class);

        // Asignar el ID desde la ruta al proyecto
        proyecto.setIdProyecto(id);

        // Realizar la actualización
        proyectoService.update(proyecto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")

    public void elimina(@PathVariable ("id") Integer id){
        proyectoService.delete(id);
    }

    @GetMapping("/contar-por-usuario/{idUsuario}")//sifunciona
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<ProyectoCountDTO> contarProyectosPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return proyectoService.contarProyectosPorUsuario(idUsuario);
    }
    @GetMapping("/contar_proyectos_estado")  //si funciona
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<ProyectosCountByEstado>contarEstadosPorProyecto()
    {
        List<String[]>lista= proyectoService.contarEstadosPorProyecto();
        List<ProyectosCountByEstado>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            ProyectosCountByEstado dto=new ProyectosCountByEstado();
            dto.setEstado(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/listar_proyectos_estado/{estadoProyecto}")//si funciona
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<ProyectosListByEstado>listarProyectosEstado(@PathVariable String estadoProyecto)
    {
        List<String[]>lista=proyectoService.listarProyectosPorEstado(estadoProyecto);
        List<ProyectosListByEstado>listaDTO=new ArrayList<>();
        for(String[] columna:lista){
            ProyectosListByEstado dto=new ProyectosListByEstado();
            dto.setIdUsuario(Integer.parseInt(columna[0]));
            dto.setNombre(columna[1]);
            dto.setProyecto(columna[2]);
            dto.setEstado(columna[3]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
    @GetMapping("/permisos_proyectos") // si funciona
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public  List<PermisosCountByProyectosDTO>contarPermisosPorProyectos(){
        List<String[]>lista=proyectoService.contarPermisosDeProyectos();
        List<PermisosCountByProyectosDTO>listaDto= new ArrayList<>();
        for(String[]columna:lista){
            PermisosCountByProyectosDTO dto=new PermisosCountByProyectosDTO();
            dto.setIdUsuario(Long.parseLong(columna[0]));
            dto.setNombreusuario(columna[1]);
            dto.setProyecto(columna[2]);
            dto.setNumPermisos(Integer.parseInt(columna[3]));
            listaDto.add(dto);
        }
        return listaDto;
    }
    @GetMapping("/permisos_proyectos_usuario/{idUsuario}") // funciona
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public  List<PermisosCountByProyectosDTO>contarPermisosPorProyectosUsuario(@PathVariable Long idUsuario){
        List<String[]>lista=proyectoService.contarPermisosDeProyectosPorUsuario(idUsuario);
        List<PermisosCountByProyectosDTO>listaDto= new ArrayList<>();
        for(String[]columna:lista){
            PermisosCountByProyectosDTO dto=new PermisosCountByProyectosDTO();
            dto.setProyecto(columna[0]);
            dto.setNumPermisos(Integer.parseInt(columna[1]));
            listaDto.add(dto);
        }
        return listaDto;
    }
    @GetMapping("/terrenos_proyectos")  //si funciona
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public  List<TerrenoCountByProyectoDTO>contarTerrenosPorProyectos()
    {
        List<String[]>lista=proyectoService.contarTerrenosDeProyectos();
        List<TerrenoCountByProyectoDTO>listaDto= new ArrayList<>();
        for(String[]columna:lista){
            TerrenoCountByProyectoDTO dto= new TerrenoCountByProyectoDTO();
            dto.setProyectoId(Integer.parseInt(columna[0]));
            dto.setProyectoNombre(columna[1]);
            dto.setNumTerrenos(Integer.parseInt(columna[2]));
            listaDto.add(dto);
        }
        return listaDto;
    }
    @GetMapping("/terrenos_por_proyecto/{idProyecto}") //funciona
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<TerrenoDTO> contarTerrenosPorProyecto(@PathVariable("idProyecto")Integer idProyecto){
        List<String[]>lista=proyectoService.contarTerrenosPorProyecto(idProyecto);
        List<TerrenoDTO>listaDto= new ArrayList<>();
        for (String[] columna:lista){
            TerrenoDTO dto= new TerrenoDTO();
            dto.setIdTerreno(Integer.parseInt(columna[0]));
            dto.setUbicacionTerreno(columna[1]);
            dto.setTamanioTerreno(Float.parseFloat(columna[2]));
            dto.setDescripcionTerreno(columna[3]);
            listaDto.add(dto);

        }
        return listaDto;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public ProyectoDTO findById(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        Proyecto proyecto = proyectoService.findById(id);
        return modelMapper.map(proyecto, ProyectoDTO.class);
    }
}