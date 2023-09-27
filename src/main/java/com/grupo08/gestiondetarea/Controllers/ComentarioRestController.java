package com.grupo08.gestiondetarea.Controllers;

import com.grupo08.gestiondetarea.Models.Comentario;
import com.grupo08.gestiondetarea.Services.ComentarioServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioRestController {
    @Autowired
    ComentarioServicesimpl comentarioServices;
    @GetMapping("/lista")
    public List<Comentario> listaDeComentarios(){
        List<Comentario> listaMostrar = comentarioServices.listaDeComentarios();
        return listaMostrar;
    }
    @GetMapping("/{id}")
    public Comentario comentarioPorId (@PathVariable Long id) {
       Comentario comentarioMostrar = comentarioServices.buscarComentarioPorId(id);
        return comentarioMostrar;
    }
    @PostMapping("/nuevo")
    public Comentario guardarComentarioNuevo(@RequestBody Comentario comentarioNuevo) {
        Comentario comentarioParaGuardar= comentarioServices.guardarComentario(comentarioNuevo);
        return comentarioParaGuardar;
    }

    @PutMapping("/editar/{id}")
    public Comentario editarComentario (@PathVariable Long id, @RequestBody Comentario comentarioActualizado){
        Comentario comentarioeditado= comentarioServices.editarComentarioPorId(id,comentarioActualizado);
        return comentarioeditado;
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarComentarios(@PathVariable Long id){
        comentarioServices.borrarComentario(id);
        return "El comentario a sido borrado existosamente";
    }

}
