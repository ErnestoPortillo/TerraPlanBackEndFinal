package pe.edu.upc.terraplan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombreCompleto", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(name = "contrasenia", nullable = false, length = 100)
    private String contrasenia;

    @Column(nullable = false)
    private Boolean enabled;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Rol> roles = new ArrayList<>();

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(Long idUsuario, String nombreCompleto, String contrasenia, Boolean enabled, List<Rol> roles) {
        this.idUsuario = idUsuario;
        this.nombreCompleto = nombreCompleto;
        this.contrasenia = contrasenia;
        this.enabled = enabled;
        this.roles = roles;
    }

    // Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        // Asignar usuario a cada rol
        this.roles.clear();
        if (roles != null) {
            roles.forEach(rol -> rol.setUsuario(this));
            this.roles.addAll(roles);
        }
    }
}
