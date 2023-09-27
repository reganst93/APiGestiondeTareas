package com.grupo08.gestiondetarea.Repositories;

import com.grupo08.gestiondetarea.Models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
}
