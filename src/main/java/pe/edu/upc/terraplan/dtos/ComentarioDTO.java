package pe.edu.upc.terraplan.dtos;

import java.time.LocalDate;

public class ComentarioDTO {
    private int idComentario;
    private String contenidoComentario;
    private LocalDate fechaComentario;
    private Long idUsuario;         // Solo ID del usuario
    private int idProyecto;         // Solo ID del proyecto
    private int idEvaluacion;       // Solo ID de la evaluación

    // Campos adicionales para visualización
    private String nombreUsuario;       // Nombre del usuario
    private String nombreProyecto;      // Nombre del proyecto
    private String resultadoEvaluacion; // Resultado de la evaluación

    // Getters y Setters
    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenidoComentario() {
        return contenidoComentario;
    }

    public void setContenidoComentario(String contenidoComentario) {
        this.contenidoComentario = contenidoComentario;
    }

    public LocalDate getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDate fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getResultadoEvaluacion() {
        return resultadoEvaluacion;
    }

    public void setResultadoEvaluacion(String resultadoEvaluacion) {
        this.resultadoEvaluacion = resultadoEvaluacion;
    }
}
