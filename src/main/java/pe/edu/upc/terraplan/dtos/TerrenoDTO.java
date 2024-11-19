package pe.edu.upc.terraplan.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TerrenoDTO {
    private int idTerreno;
    private String ubicacionTerreno;
    private float tamanioTerreno;
    private String descripcionTerreno;
    private int idProyecto; // Solo el ID del proyecto
    private String nombreProyecto; // Opcional para visualización

    // Getters y Setters
    public int getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(int idTerreno) {
        this.idTerreno = idTerreno;
    }

    public String getUbicacionTerreno() {
        return ubicacionTerreno;
    }

    public void setUbicacionTerreno(String ubicacionTerreno) {
        this.ubicacionTerreno = ubicacionTerreno;
    }

    public float getTamanioTerreno() {
        return tamanioTerreno;
    }

    public void setTamanioTerreno(float tamanioTerreno) {
        this.tamanioTerreno = tamanioTerreno;
    }

    public String getDescripcionTerreno() {
        return descripcionTerreno;
    }

    public void setDescripcionTerreno(String descripcionTerreno) {
        this.descripcionTerreno = descripcionTerreno;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }
}
