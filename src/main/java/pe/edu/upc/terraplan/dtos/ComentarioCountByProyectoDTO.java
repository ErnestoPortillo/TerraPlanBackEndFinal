package pe.edu.upc.terraplan.dtos;

public class ComentarioCountByProyectoDTO {
    private String nombreProyecto;
    private Long cantidadComentarios;

    public ComentarioCountByProyectoDTO() {
    }

    public ComentarioCountByProyectoDTO(String nombreProyecto, Long cantidadComentarios) {
        this.nombreProyecto = nombreProyecto;
        this.cantidadComentarios = cantidadComentarios;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public Long getCantidadComentarios() {
        return cantidadComentarios;
    }

    public void setCantidadComentarios(Long cantidadComentarios) {
        this.cantidadComentarios = cantidadComentarios;
    }
}
