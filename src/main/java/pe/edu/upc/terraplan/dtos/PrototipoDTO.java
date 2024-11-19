package pe.edu.upc.terraplan.dtos;

import java.time.LocalDate;

public class PrototipoDTO {
    private int idPrototipo;
    private String tipoEstructuraPrototipo;
    private String descripcionPrototipo;
    private LocalDate fechaCreacionPrototipo;
    private int idPlano; // Solo el ID del plano
    private String descripcionPlano; // Descripción del plano para visualización

    // Getters y Setters
    public int getIdPrototipo() {
        return idPrototipo;
    }

    public void setIdPrototipo(int idPrototipo) {
        this.idPrototipo = idPrototipo;
    }

    public String getTipoEstructuraPrototipo() {
        return tipoEstructuraPrototipo;
    }

    public void setTipoEstructuraPrototipo(String tipoEstructuraPrototipo) {
        this.tipoEstructuraPrototipo = tipoEstructuraPrototipo;
    }

    public String getDescripcionPrototipo() {
        return descripcionPrototipo;
    }

    public void setDescripcionPrototipo(String descripcionPrototipo) {
        this.descripcionPrototipo = descripcionPrototipo;
    }

    public LocalDate getFechaCreacionPrototipo() {
        return fechaCreacionPrototipo;
    }

    public void setFechaCreacionPrototipo(LocalDate fechaCreacionPrototipo) {
        this.fechaCreacionPrototipo = fechaCreacionPrototipo;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public String getDescripcionPlano() {
        return descripcionPlano;
    }

    public void setDescripcionPlano(String descripcionPlano) {
        this.descripcionPlano = descripcionPlano;
    }
}
