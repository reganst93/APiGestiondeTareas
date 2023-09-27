package com.grupo08.gestiondetarea.Services;

import com.grupo08.gestiondetarea.Models.Comentario;

import java.util.List;

public interface ComentarioServices {
    List<Comentario> listaDeComentarios();

    Comentario buscarComentarioPorId (Long id);

    Comentario guardarComentario(Comentario comentarioNuevo);

    Comentario editarComentarioPorId (Long id, Comentario comentarioActualizado);
    void borrarComentario(long id);
}
