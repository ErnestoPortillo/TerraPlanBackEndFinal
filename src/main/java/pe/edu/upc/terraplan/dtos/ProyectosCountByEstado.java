package pe.edu.upc.terraplan.dtos;

public class ProyectosCountByEstado {
    private String estado;
    private int cantidad;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
