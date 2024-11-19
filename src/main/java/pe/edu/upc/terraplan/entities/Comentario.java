package pe.edu.upc.terraplan.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;
    @Column(name = "contenidoComentario", nullable = false,length = 250)
    private String contenidoComentario;
    @Column(name = "fechaComentario", nullable = false)
    private LocalDate fechaComentario;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "idProyecto")
    private Proyecto proyecto;
    @ManyToOne
    @JoinColumn(name = "idEvaluacion")
    private Evaluacion evaluacion;

    public Comentario() {
    }

    public Comentario(String contenidoComentario, int idComentario, Usuario usuario, LocalDate fechaComentario, Proyecto proyecto, Evaluacion evaluacion) {
        this.contenidoComentario = contenidoComentario;
        this.idComentario = idComentario;
        this.usuario = usuario;
        this.fechaComentario = fechaComentario;
        this.proyecto = proyecto;
        this.evaluacion = evaluacion;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenidoComentario() {
        return contenidoComentario;
    }

    public void setContenidoComentario(String contenidoComentario) {
        this.contenidoComentario = contenidoComentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(LocalDate fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }
}
