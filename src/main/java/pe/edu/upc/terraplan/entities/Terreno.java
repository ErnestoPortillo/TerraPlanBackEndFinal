package pe.edu.upc.terraplan.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Terreno")
public class Terreno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTerreno;
    @Column(name="ubicacionTerreno", nullable=false,length = 255)
    private String ubicacionTerreno;
    @Column(name="tamanioTerreno", nullable=false)
    private String tamanioTerreno;
    @Column(name="descripcionTerreno",nullable = false,length = 300)
    private String descripcionTerreno;
    @ManyToOne
    @JoinColumn(name = "idProyecto", nullable = false)
    private Proyecto proyecto;

    public Terreno() {
    }

    public Terreno(int idTerreno, String ubicacionTerreno, String tamanioTerreno, String descripcionTerreno, Proyecto proyecto) {
        this.idTerreno = idTerreno;
        this.ubicacionTerreno = ubicacionTerreno;
        this.tamanioTerreno = tamanioTerreno;
        this.descripcionTerreno = descripcionTerreno;
        this.proyecto = proyecto;
    }

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

    public String getTamanioTerreno() {
        return tamanioTerreno;
    }

    public void setTamanioTerreno(String tamanioTerreno) {
        this.tamanioTerreno = tamanioTerreno;
    }

    public String getDescripcionTerreno() {
        return descripcionTerreno;
    }

    public void setDescripcionTerreno(String descripcionTerreno) {
        this.descripcionTerreno = descripcionTerreno;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}