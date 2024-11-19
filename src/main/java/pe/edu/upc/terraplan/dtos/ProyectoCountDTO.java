package pe.edu.upc.terraplan.dtos;

public class ProyectoCountDTO {
    private String nombreUsuario;
    private Long cantidadProyectos;

    public ProyectoCountDTO() {
    }

    public ProyectoCountDTO(String nombreUsuario, Long cantidadProyectos) {
        this.nombreUsuario = nombreUsuario;
        this.cantidadProyectos = cantidadProyectos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Long getCantidadProyectos() {
        return cantidadProyectos;
    }

    public void setCantidadProyectos(Long cantidadProyectos) {
        this.cantidadProyectos = cantidadProyectos;
    }
}
