package pe.edu.upc.terraplan.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificacion;
    @Column(name = "tituloNotificacion", nullable = false,length = 100)
    private String tituloNotificacion;
    @Column(name = "mensajeNotificacion", nullable = false,length = 200)
    private String mensajeNotificacion;
    @Column(name = "fechaNotificacion", nullable = false,length = 200)
    private LocalDate fechaNotificacion;

    @ManyToOne
    @JoinColumn(name="idUsuario")
    Usuario usuario;

    public Notificacion() {
    }

    public Notificacion(int idNotificacion, String tituloNotificacion, String mensajeNotificacion, LocalDate fechaNotificacion, Usuario usuario) {
        this.idNotificacion = idNotificacion;
        this.tituloNotificacion = tituloNotificacion;
        this.mensajeNotificacion = mensajeNotificacion;
        this.fechaNotificacion = fechaNotificacion;
        this.usuario = usuario;
    }

    public String getTituloNotificacion() {
        return tituloNotificacion;
    }

    public void setTituloNotificacion(String tituloNotificacion) {
        this.tituloNotificacion = tituloNotificacion;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensajeNotificacion() {
        return mensajeNotificacion;
    }

    public void setMensajeNotificacion(String mensajeNotificacion) {
        this.mensajeNotificacion = mensajeNotificacion;
    }

    public LocalDate getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(LocalDate fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }
}
