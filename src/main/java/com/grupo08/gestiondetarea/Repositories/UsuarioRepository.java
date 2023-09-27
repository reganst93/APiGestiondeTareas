package com.grupo08.gestiondetarea.Repositories;

import com.grupo08.gestiondetarea.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsuarioNombre(String usuarioNombre);
}
