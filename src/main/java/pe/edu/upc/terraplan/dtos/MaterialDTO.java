package pe.edu.upc.terraplan.dtos;

public class MaterialDTO {
    private int idMaterial;
    private String tipoMaterial;
    private float costoMaterial;
    private float cantidadMaterial;

    // Getters y Setters
    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public float getCostoMaterial() {
        return costoMaterial;
    }

    public void setCostoMaterial(float costoMaterial) {
        this.costoMaterial = costoMaterial;
    }

    public float getCantidadMaterial() {
        return cantidadMaterial;
    }

    public void setCantidadMaterial(float cantidadMaterial) {
        this.cantidadMaterial = cantidadMaterial;
    }
}
