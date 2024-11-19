package pe.edu.upc.terraplan.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PermisosCountByProyectosDTO {
    private long idUsuario;
    private String nombreusuario;
    private String proyecto;
    private int numPermisos;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public int getNumPermisos() {
        return numPermisos;
    }

    public void setNumPermisos(int numPermisos) {
        this.numPermisos = numPermisos;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }
}
