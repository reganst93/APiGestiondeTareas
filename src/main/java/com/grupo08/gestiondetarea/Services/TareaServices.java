package com.grupo08.gestiondetarea.Services;

import com.grupo08.gestiondetarea.Models.Tarea;

import java.util.List;

public interface TareaServices {
    List<Tarea> listaDeTareas();

    Tarea buscarTareaPorId (Long id);

    Tarea guardarTarea(Tarea tareaNueva);

    Tarea editarTareaPorId (Long id, Tarea tareaActualizada);

    void borrarTarea (Long id);
}
