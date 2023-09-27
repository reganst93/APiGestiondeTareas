package com.grupo08.gestiondetarea.Services;

import com.grupo08.gestiondetarea.Models.Comentario;
import com.grupo08.gestiondetarea.Repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServicesimpl implements ComentarioServices{
    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> listaDeComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario buscarComentarioPorId(Long id) {
        Boolean existe = comentarioRepository.existsById(id);
        if (existe){
            Comentario comentarioEscogido = comentarioRepository.findById(id).get();
            return comentarioEscogido;
        }else {
            System.out.println("El id de Comentario es invalido");
            return null;
        }
    }

    @Override
    public Comentario guardarComentario(Comentario comentarioNuevo) {
        return comentarioRepository.save(comentarioNuevo);
    }

    @Override
    public Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado) {
        Boolean exite = comentarioRepository.existsById(id);
        if (exite){
            Comentario comentarioSeleccionado = comentarioRepository.findById(id).get();
            comentarioSeleccionado.setTexto(comentarioActualizado.getTexto());
            comentarioSeleccionado.setFechaCreacion(comentarioActualizado.getFechaCreacion());
            System.out.println("El comentario a sido actualizado");
            return comentarioRepository.save(comentarioSeleccionado);
        }else{
            System.out.println("El id del comentario no es valido");
            return null;
        }
    }

    @Override
    public void borrarComentario(long id) {
        comentarioRepository.deleteById(id);

    }
}