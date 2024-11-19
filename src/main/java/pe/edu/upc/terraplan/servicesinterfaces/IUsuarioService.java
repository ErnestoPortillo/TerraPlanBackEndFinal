package pe.edu.upc.terraplan.servicesinterfaces;

import pe.edu.upc.terraplan.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public void delete(Long id);  // Cambiado de int a Long
    public void update(Usuario usuario);
    public Usuario findById(Long id) throws RuntimeException;
}
