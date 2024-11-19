package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.terraplan.entities.Comentario;
import pe.edu.upc.terraplan.entities.Terreno;

import java.util.List;

public interface ITerrenoService {
    public List<Terreno> list();
    public void insert(Terreno terreno);
    public void delete(int id);
    public void update(Terreno terreno);
    public  List<String[]>CantidadTerrenosUbicaicon();
    Terreno findById(int id);
}
