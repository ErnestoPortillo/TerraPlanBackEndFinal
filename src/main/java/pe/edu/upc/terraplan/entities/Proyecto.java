package pe.edu.upc.terraplan.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Proyecto")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idProyecto;
    @Column (name="nombreProyecto",nullable = false,length = 100)
    private String nombreProyecto;
    @Column (name="descripcionProyecto",nullable = false,length = 250)
    private String descripcionProyecto;
    @Column (name="fechaCreacionProyecto",nullable = false)
    private LocalDate fechaCreacionProyecto;
    @Column (name="estadoProyecto",nullable = false,length = 25)
    private String estadoProyecto;
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuarioProyecto;
    @JsonIgnore
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Terreno> terrenos;
    @JsonIgnore
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comentario> comentarios;

    public Proyecto() {
    }

    public Proyecto(int idProyecto, String nombreProyecto, String descripcionProyecto, LocalDate fechaCreacionProyecto, String estadoProyecto, Usuario usuarioProyecto, List<Comentario> comentarios, List<Terreno> terrenos) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.fechaCreacionProyecto = fechaCreacionProyecto;
        this.estadoProyecto = estadoProyecto;
        this.usuarioProyecto = usuarioProyecto;
        this.comentarios = comentarios;
        this.terrenos = terrenos;
    }

    // Getters y Setters

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcionProyecto() {
        return descripcionProyecto;
    }

    public void setDescripcionProyecto(String descripcionProyecto) {
        this.descripcionProyecto = descripcionProyecto;
    }

    public LocalDate getFechaCreacionProyecto() {
        return fechaCreacionProyecto;
    }

    public void setFechaCreacionProyecto(LocalDate fechaCreacionProyecto) {
        this.fechaCreacionProyecto = fechaCreacionProyecto;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public Usuario getUsuarioProyecto() {
        return usuarioProyecto;
    }

    public void setUsuarioProyecto(Usuario usuarioProyecto) {
        this.usuarioProyecto = usuarioProyecto;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Terreno> getTerrenos() {
        return terrenos;
    }

    public void setTerrenos(List<Terreno> terrenos) {
        this.terrenos = terrenos;
    }
}
