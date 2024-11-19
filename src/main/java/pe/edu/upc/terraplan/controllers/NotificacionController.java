package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.NotificacionDto;
import pe.edu.upc.terraplan.entities.Notificacion;
import pe.edu.upc.terraplan.entities.Usuario;
import pe.edu.upc.terraplan.servicesinterfaces.INotifacionService;
import pe.edu.upc.terraplan.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificacion")
public class NotificacionController {

    @Autowired
    private INotifacionService notificacionService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<NotificacionDto> listar() {
        return notificacionService.list().stream().map(notificacion -> {
            NotificacionDto dto = new NotificacionDto();
            dto.setIdNotificacion(notificacion.getIdNotificacion());
            dto.setTituloNotificacion(notificacion.getTituloNotificacion());
            dto.setMensajeNotificacion(notificacion.getMensajeNotificacion());
            dto.setFechaNotificacion(notificacion.getFechaNotificacion());

            // Mapear información del usuario
            if (notificacion.getUsuario() != null) {
                dto.setIdUsuario(notificacion.getUsuario().getIdUsuario().intValue());
                dto.setNombreUsuario(notificacion.getUsuario().getNombreCompleto());
            }

            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void insertar(@RequestBody NotificacionDto dto) {
        if (dto.getIdUsuario() <= 0) {
            throw new IllegalArgumentException("El ID del usuario es obligatorio y debe ser mayor a 0.");
        }

        Usuario usuario = usuarioService.findById((long) dto.getIdUsuario());
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con ID: " + dto.getIdUsuario());
        }

        Notificacion notificacion = new Notificacion();
        notificacion.setTituloNotificacion(dto.getTituloNotificacion());
        notificacion.setMensajeNotificacion(dto.getMensajeNotificacion());
        notificacion.setFechaNotificacion(dto.getFechaNotificacion());
        notificacion.setUsuario(usuario);

        notificacionService.insert(notificacion);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void modificar(@PathVariable("id") int id, @RequestBody NotificacionDto dto) {
        ModelMapper m = new ModelMapper();
        Notificacion notificacion = m.map(dto, Notificacion.class);

        // Recuperar el usuario usando el idUsuario del DTO
        Usuario usuario = usuarioService.findById((long) dto.getIdUsuario());
        notificacion.setUsuario(usuario);

        // Asegurarse de asignar el ID de la notificación correctamente
        notificacion.setIdNotificacion(id);
        notificacionService.update(notificacion);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void elimina(@PathVariable("id") Integer id) {
        notificacionService.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public NotificacionDto findById(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        Notificacion notificacion = notificacionService.findById(id);
        return modelMapper.map(notificacion, NotificacionDto.class);
    }
}
