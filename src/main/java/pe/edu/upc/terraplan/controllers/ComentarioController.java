package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.ComentarioCountDTO;
import pe.edu.upc.terraplan.dtos.ComentarioDTO;
import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.servicesinterfaces.IComentarioService;
import pe.edu.upc.terraplan.servicesinterfaces.IUsuarioService;
import pe.edu.upc.terraplan.servicesinterfaces.IProyectoService;
import pe.edu.upc.terraplan.servicesinterfaces.IEvalucionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private IComentarioService comentarioService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IProyectoService proyectoService;

    @Autowired
    private IEvalucionService evaluacionService;

    // Insertar un comentario
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void insertar(@RequestBody ComentarioDTO comentarioDTO) {
        ModelMapper m = new ModelMapper();
        Comentario comentario = m.map(comentarioDTO, Comentario.class);

        // Validar y asignar relaciones
        comentario.setUsuario(comentarioDTO.getIdUsuario() != 0 ? usuarioService.findById(comentarioDTO.getIdUsuario()) : null);
        comentario.setProyecto(comentarioDTO.getIdProyecto() != 0 ? proyectoService.findById(comentarioDTO.getIdProyecto()) : null);
        comentario.setEvaluacion(comentarioDTO.getIdEvaluacion() != 0 ? evaluacionService.findById(comentarioDTO.getIdEvaluacion()) : null);

        comentarioService.insert(comentario);
    }

    // Listar todos los comentarios
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<ComentarioDTO> listar() {
        return comentarioService.list().stream().map(x -> {
            ModelMapper mapper = new ModelMapper();
            ComentarioDTO dto = mapper.map(x, ComentarioDTO.class);

            // Mapear nombres y resultados desde las relaciones
            dto.setNombreUsuario(x.getUsuario() != null ? x.getUsuario().getNombreCompleto() : "Desconocido");
            dto.setNombreProyecto(x.getProyecto() != null ? x.getProyecto().getNombreProyecto() : "No asignado");
            dto.setResultadoEvaluacion(x.getEvaluacion() != null ? x.getEvaluacion().getResultadoEvaluacion() : "Sin resultado");

            return dto;
        }).collect(Collectors.toList());
    }

    // Modificar un comentario existente
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void modificar(@RequestBody ComentarioDTO comentarioDTO) {
        ModelMapper m = new ModelMapper();
        Comentario comentario = m.map(comentarioDTO, Comentario.class);

        // Validar y asignar relaciones
        comentario.setUsuario(comentarioDTO.getIdUsuario() != 0 ? usuarioService.findById(comentarioDTO.getIdUsuario()) : null);
        comentario.setProyecto(comentarioDTO.getIdProyecto() != 0 ? proyectoService.findById(comentarioDTO.getIdProyecto()) : null);
        comentario.setEvaluacion(comentarioDTO.getIdEvaluacion() != 0 ? evaluacionService.findById(comentarioDTO.getIdEvaluacion()) : null);

        comentarioService.update(comentario);
    }

    // Eliminar un comentario por ID
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void eliminar(@PathVariable("id") Integer id) {
        comentarioService.delete(id);
    }

    @GetMapping("/contar-por-usuario/{idUsuario}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<ComentarioCountDTO> contarComentariosPorUsuario(@PathVariable("idUsuario") Long idUsuario) {
        return comentarioService.contarComentariosPorUsuarioRaw(idUsuario).stream()
                .map(obj -> new ComentarioCountDTO((String) obj[0], (Long) obj[1]))
                .collect(Collectors.toList());
    }

    // Buscar un comentario por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public ComentarioDTO findById(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        Comentario comentario = comentarioService.findById(id);

        // Convertir a DTO y manejar relaciones nulas
        ComentarioDTO dto = modelMapper.map(comentario, ComentarioDTO.class);
        dto.setIdUsuario(comentario.getUsuario() != null ? comentario.getUsuario().getIdUsuario() : 0);
        dto.setIdProyecto(comentario.getProyecto() != null ? comentario.getProyecto().getIdProyecto() : 0);
        dto.setIdEvaluacion(comentario.getEvaluacion() != null ? comentario.getEvaluacion().getIdEvaluacion() : 0);

        return dto;
    }
}
