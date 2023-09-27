package com.grupo08.gestiondetarea.Repositories;

import com.grupo08.gestiondetarea.Models.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,Long> {
}
