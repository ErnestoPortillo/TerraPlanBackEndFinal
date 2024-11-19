package pe.edu.upc.terraplan.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Plano")
public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlano;
    @Column(name = "tipoPlano", nullable = false, length = 50)
    private String tipoPlano;
    @Column(name = "descripcionPlano", nullable = false, length = 250)
    private String descripcionPlano;
    @Column(name = "fechaPlano", nullable = false)
    private LocalDate fechaPlano;
    @ManyToOne
    @JoinColumn(name = "idTerreno")
    private Terreno terreno;

    public Plano() {
    }

    public Plano(int idPlano, String tipoPlano, String descripcionPlano, LocalDate fechaPlano, Terreno terreno) {
        this.idPlano = idPlano;
        this.tipoPlano = tipoPlano;
        this.descripcionPlano = descripcionPlano;
        this.fechaPlano = fechaPlano;
        this.terreno = terreno;
    }

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

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }
}
