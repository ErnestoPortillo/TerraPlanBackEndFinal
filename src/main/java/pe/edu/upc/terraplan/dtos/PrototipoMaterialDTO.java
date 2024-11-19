package pe.edu.upc.terraplan.dtos;

import pe.edu.upc.terraplan.entities.Material;
import pe.edu.upc.terraplan.entities.Prototipo;

public class PrototipoMaterialDTO {
    private int idPrototipoMaterial;
    private int idPrototipo;
    private String descripcionPrototipo;
    private int idMaterial;
    private String descripcionMaterial;

    // Getters y setters
    public int getIdPrototipoMaterial() {
        return idPrototipoMaterial;
    }

    public void setIdPrototipoMaterial(int idPrototipoMaterial) {
        this.idPrototipoMaterial = idPrototipoMaterial;
    }

    public int getIdPrototipo() {
        return idPrototipo;
    }

    public void setIdPrototipo(int idPrototipo) {
        this.idPrototipo = idPrototipo;
    }

    public String getDescripcionPrototipo() {
        return descripcionPrototipo;
    }

    public void setDescripcionPrototipo(String descripcionPrototipo) {
        this.descripcionPrototipo = descripcionPrototipo;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getDescripcionMaterial() {
        return descripcionMaterial;
    }

    public void setDescripcionMaterial(String descripcionMaterial) {
        this.descripcionMaterial = descripcionMaterial;
    }
}

