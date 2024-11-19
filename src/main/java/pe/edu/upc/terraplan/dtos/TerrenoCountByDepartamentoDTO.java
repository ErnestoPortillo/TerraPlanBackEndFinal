package pe.edu.upc.terraplan.dtos;

public class TerrenoCountByDepartamentoDTO {
    private  String ubicacionTerreno;
    private int cantidad;

    public String getUbicacionTerreno() {
        return ubicacionTerreno;
    }

    public void setUbicacionTerreno(String ubicacionTerreno) {
        this.ubicacionTerreno = ubicacionTerreno;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
