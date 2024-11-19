package pe.edu.upc.terraplan.dtos;

import java.time.LocalDate;

public class PlanoDTO {
    private int idPlano;
    private String tipoPlano;
    private String descripcionPlano;
    private LocalDate fechaPlano;
    private int idTerreno; // Solo el ID del terreno
    private String descripcionTerreno; // Descripción del terreno

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

    public String getDescripcionPlano() {
        return descripcionPlano;
    }

    public void setDescripcionPlano(String descripcionPlano) {
        this.descripcionPlano = descripcionPlano;
    }

    public LocalDate getFechaPlano() {
        return fechaPlano;
    }

    public void setFechaPlano(LocalDate fechaPlano) {
        this.fechaPlano = fechaPlano;
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
