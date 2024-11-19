package pe.edu.upc.terraplan.dtos;

import java.time.LocalDate;

public class EvaluacionDTO {
    private int idEvaluacion;
    private LocalDate fechaEvaluacion;
    private String resultadoEvaluacion;
    private String comentariosEvaluacion;
    private int idTerreno; // Campo adicional para mostrar el ID del terreno
    private String descripcionTerreno; // Campo adicional para mostrar la descripción del terreno

    // Getters y Setters
    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getResultadoEvaluacion() {
        return resultadoEvaluacion;
    }

    public void setResultadoEvaluacion(String resultadoEvaluacion) {
        this.resultadoEvaluacion = resultadoEvaluacion;
    }

    public String getComentariosEvaluacion() {
        return comentariosEvaluacion;
    }

    public void setComentariosEvaluacion(String comentariosEvaluacion) {
        this.comentariosEvaluacion = comentariosEvaluacion;
    }

    public int getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(int idTerreno) {
        this.idTerreno = idTerreno;
    }

    public String getDescripcionTerreno() {
        return descripcionTerreno;
    }

    public void setDescripcionTerreno(String descripcionTerreno) {
        this.descripcionTerreno = descripcionTerreno;
    }
}
