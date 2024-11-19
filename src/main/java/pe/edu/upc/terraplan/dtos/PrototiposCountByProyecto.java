package pe.edu.upc.terraplan.dtos;

public class PrototiposCountByProyecto {
    private String Proyecto;
    private int idTerreno;
    private String ubicacion;
    private int idPlano;
    private int idPrototipo;
    private  float costoTotal;

    public String getProyecto() {
        return Proyecto;
    }

    public void setProyecto(String proyecto) {
        Proyecto = proyecto;
    }

    public int getIdTerreno() {
        return idTerreno;
    }

    public void setIdTerreno(int idTerreno) {
        this.idTerreno = idTerreno;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public int getIdPrototipo() {
        return idPrototipo;
    }

    public void setIdPrototipo(int idPrototipo) {
        this.idPrototipo = idPrototipo;
    }
}