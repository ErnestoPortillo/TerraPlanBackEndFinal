package pe.edu.upc.terraplan.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.terraplan.entities.Usuario;
import pe.edu.upc.terraplan.repositories.IUsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreCompleto) throws UsernameNotFoundException {
        // Cambiar la búsqueda de 'username' a 'nombreCompleto'
        Usuario usuario = usuarioRepository.findOneByNombreCompleto(nombreCompleto);

        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe: %s", nombreCompleto));
        }

        // Obtener roles y autoridades
        List<GrantedAuthority> roles = new ArrayList<>();
        usuario.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombreRol()));
        });

        // Crear y retornar el objeto UserDetails
        UserDetails ud = new org.springframework.security.core.userdetails.User(
                usuario.getNombreCompleto(),
                usuario.getContrasenia(),
                usuario.getEnabled(),
                true, // accountNonExpired
                true, // credentialsNonExpired
                true, // accountNonLocked
                roles
        );

        return ud;
    }
}