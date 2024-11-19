package pe.edu.upc.terraplan.dtos;

public class TerrenoCountByProyectoDTO {
    private  int proyectoId;
    private String proyectoNombre;
    private int numTerrenos;

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getProyectoNombre() {
        return proyectoNombre;
    }

    public void setProyectoNombre(String proyectoNombre) {
        this.proyectoNombre = proyectoNombre;
    }

    public int getNumTerrenos() {
        return numTerrenos;
    }

    public void setNumTerrenos(int numTerrenos) {
        this.numTerrenos = numTerrenos;
    }
}
