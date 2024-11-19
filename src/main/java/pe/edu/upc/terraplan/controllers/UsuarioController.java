package pe.edu.upc.terraplan.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.terraplan.dtos.UsuarioDTO;
import pe.edu.upc.terraplan.entities.Usuario;
import pe.edu.upc.terraplan.entities.Rol;
import pe.edu.upc.terraplan.servicesinterfaces.IUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService uS;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper = new ModelMapper();

    // Método GET para listar todos los usuarios
    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public List<UsuarioDTO> listar() {
        return uS.list().stream().map(usuario -> {
            UsuarioDTO dto = new UsuarioDTO();
            dto.setIdUsuario(usuario.getIdUsuario());
            dto.setNombreCompleto(usuario.getNombreCompleto());
            dto.setEnabled(usuario.getEnabled());

            // Convertir lista de entidades Rol a lista de Strings (nombres de roles)
            List<String> roles = usuario.getRoles().stream()
                    .map(Rol::getNombreRol)
                    .collect(Collectors.toList());
            dto.setRoles(roles);

            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void insertar(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);

        // Codificar la contraseña antes de guardar
        if (usuario.getContrasenia() != null && !usuario.getContrasenia().isEmpty()) {
            String encodedPassword = passwordEncoder.encode(usuario.getContrasenia());
            usuario.setContrasenia(encodedPassword);
        }

        // Asociar roles con el usuario
        List<Rol> roles = usuarioDTO.getRoles().stream().map(nombreRol -> {
            Rol rol = new Rol();
            rol.setNombreRol(nombreRol);
            rol.setDescripcionRol(getDescripcionRol(nombreRol)); // Asignar descripción dinámica
            rol.setUsuario(usuario); // Asociar rol al usuario
            return rol;
        }).collect(Collectors.toList());

        usuario.setRoles(roles);

        uS.insert(usuario);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void modificar(@PathVariable("id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario.setIdUsuario(id);

        // Si la contraseña no es nula o vacía, se codifica
        if (usuarioDTO.getContrasenia() != null && !usuarioDTO.getContrasenia().isEmpty()) {
            String encodedPassword = passwordEncoder.encode(usuarioDTO.getContrasenia());
            usuario.setContrasenia(encodedPassword);
        } else {
            // Si no se envió una nueva contraseña, mantén la contraseña existente
            Usuario usuarioExistente = uS.findById(id);
            usuario.setContrasenia(usuarioExistente.getContrasenia());
        }

        // Asociar roles con el usuario
        List<Rol> roles = usuarioDTO.getRoles().stream().map(nombreRol -> {
            Rol rol = new Rol();
            rol.setNombreRol(nombreRol);
            rol.setDescripcionRol(getDescripcionRol(nombreRol)); // Asignar descripción dinámica
            rol.setUsuario(usuario); // Asociar rol al usuario
            return rol;
        }).collect(Collectors.toList());

        usuario.setRoles(roles);

        uS.update(usuario);
    }

    // Método helper para asignar descripciones
    private String getDescripcionRol(String nombreRol) {
        switch (nombreRol) {
            case "ADMIN":
                return "Rol de Administrador";
            case "CLIENTE":
                return "Rol de Cliente";
            case "ARQUITECTO":
                return "Rol de Arquitecto";
            default:
                return "Rol Desconocido";
        }
    }

    // Método DELETE para eliminar un usuario por ID
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public void eliminar(@PathVariable("id") Long id) {
        uS.delete(id);
    }

    // Método GET para obtener un usuario por ID
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENTE', 'ARQUITECTO')")
    public UsuarioDTO listarId(@PathVariable("id") Long id) {
        Optional<Usuario> usuarioOpt = Optional.ofNullable(uS.findById(id));
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            UsuarioDTO dto = new UsuarioDTO();
            dto.setIdUsuario(usuario.getIdUsuario());
            dto.setNombreCompleto(usuario.getNombreCompleto());
            dto.setEnabled(usuario.getEnabled());
            // Convertir lista de entidades Rol a lista de Strings
            List<String> roles = usuario.getRoles().stream()
                    .map(Rol::getNombreRol)
                    .collect(Collectors.toList());
            dto.setRoles(roles);

            return dto;
        } else {
            throw new RuntimeException("Usuario no encontrado con el ID: " + id);
        }
    }
}
