package pe.edu.upc.terraplan.entities;

import jakarta.persistence.*;
@Entity
@Table(name="Material")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMaterial;
    @Column( name="tipoMaterial",nullable = false,length =100 )
    private String tipoMaterial;
    @Column(name="costoMaterial",nullable = false)
    private float costoMaterial;
    @Column(name="cantidadMaterial",nullable = false)
    private float cantidadMaterial;

    public Material(){

    }

    public Material(int idMaterial,String tipoMaterial, float costoMaterial, float cantidadMaterial) {
        this.idMaterial = idMaterial;
        this.tipoMaterial = tipoMaterial;
        this.costoMaterial = costoMaterial;
        this.cantidadMaterial = cantidadMaterial;
    }

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
