package pe.edu.upc.terraplan.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Permiso")
public class Permiso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPermiso;
    @Column(name="nombrePermiso",nullable = false,length = 100)
    private String nombrePermiso;
    @Column(name="descripcionPermiso",nullable = false,length = 300)
    private String descripcionPermiso;
    @Column(name="fechaSubida",nullable = false)
    private LocalDate fechaSubida;
    @ManyToOne
    @JoinColumn(name="idProyecto")
    private  Proyecto proyecto;

    public Permiso() {
    }

    public Permiso(int idPermiso, String descripcionPermiso, String nombrePermiso, LocalDate fechaSubida, Proyecto proyecto) {
        this.idPermiso = idPermiso;
        this.descripcionPermiso = descripcionPermiso;
        this.nombrePermiso = nombrePermiso;
        this.fechaSubida = fechaSubida;
        this.proyecto = proyecto;
    }

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getDescripcionPermiso() {
        return descripcionPermiso;
    }

    public void setDescripcionPermiso(String descripcionPermiso) {
        this.descripcionPermiso = descripcionPermiso;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public LocalDate getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(LocalDate fechaSubida) {
        this.fechaSubida = fechaSubida;
    }
}
