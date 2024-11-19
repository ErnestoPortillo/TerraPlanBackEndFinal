package pe.edu.upc.terraplan.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Prototipo")
public class Prototipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrototipo;
    @Column(name ="tipoEstructuraPrototipo", nullable = false,length = 100)
    private String tipoEstructuraPrototipo;
    @Column(name ="descripcionPrototipo", nullable = false,length = 250)
    private String descripcionPrototipo;
    @Column(name = "fechaCreacionPrototipo", nullable = false)
    private LocalDate fechaCreacionPrototipo;
    @ManyToOne
    @JoinColumn(name = "idPlano")
    private Plano plano;

    public Prototipo() {
    }

    public Prototipo(int idPrototipo, String descripcionPrototipo, String tipoEstructuraPrototipo, LocalDate fechaCreacionPrototipo, Plano plano) {
        this.idPrototipo = idPrototipo;
        this.descripcionPrototipo = descripcionPrototipo;
        this.tipoEstructuraPrototipo = tipoEstructuraPrototipo;
        this.fechaCreacionPrototipo = fechaCreacionPrototipo;
        this.plano = plano;
    }

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

    public LocalDate getFechaCreacionPrototipo() {
        return fechaCreacionPrototipo;
    }

    public void setFechaCreacionPrototipo(LocalDate fechaCreacionPrototipo) {
        this.fechaCreacionPrototipo = fechaCreacionPrototipo;
    }

    public String getDescripcionPrototipo() {
        return descripcionPrototipo;
    }

    public void setDescripcionPrototipo(String descripcionPrototipo) {
        this.descripcionPrototipo = descripcionPrototipo;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
