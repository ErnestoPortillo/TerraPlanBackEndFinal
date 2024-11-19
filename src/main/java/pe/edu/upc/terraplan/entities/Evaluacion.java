package pe.edu.upc.terraplan.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="Evaluacion")

public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEvaluacion;
    @Column(name="fechaEvaluacion",nullable = false)
    private LocalDate fechaEvaluacion;
    @Column(name="resultadoEvaluacion",nullable = false,length = 50)
    private String resultadoEvaluacion;
    @Column(name="comentariosEvaluacion",nullable = false,length = 250)
    private String comentariosEvaluacion;

    @ManyToOne
    @JoinColumn(name="idTerreno")
    private Terreno terreno;

    public Evaluacion() {
    }

    public Evaluacion(int idEvaluacion, String resultadoEvaluacion, LocalDate fechaEvaluacion, String comentariosEvaluacion, Terreno terreno) {
        this.idEvaluacion = idEvaluacion;
        this.resultadoEvaluacion = resultadoEvaluacion;
        this.fechaEvaluacion = fechaEvaluacion;
        this.comentariosEvaluacion = comentariosEvaluacion;
        this.terreno = terreno;
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public String getResultadoEvaluacion() {
        return resultadoEvaluacion;
    }

    public void setResultadoEvaluacion(String resultadoEvaluacion) {
        this.resultadoEvaluacion = resultadoEvaluacion;
    }

    public String getComentariosEvaluacion() {
        return comentariosEvaluacion;
    }

    public void setComentariosEvaluacion(String comentariosEvaluacion) {
        this.comentariosEvaluacion = comentariosEvaluacion;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }
}
