package pe.edu.upc.terraplan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.terraplan.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    // Cambiar para buscar por nombreCompleto
    public Usuario findOneByNombreCompleto(String nombreCompleto);

    // Buscar cantidad de usuarios por nombre de usuario
    @Query("select count(u.nombreCompleto) from Usuario u where u.nombreCompleto = :nombreCompleto")
    public int buscarUsername(@Param("nombreCompleto") String nombreCompleto);

    // Insertar roles
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO roles (nombre_rol, user_id) VALUES (:nombreRol, :userId)", nativeQuery = true)
    public void insRol(@Param("nombreRol") String nombreRol, @Param("userId") Long userId);


}
