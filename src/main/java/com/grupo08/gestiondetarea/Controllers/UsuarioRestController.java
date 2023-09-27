package com.grupo08.gestiondetarea.Controllers;

import com.grupo08.gestiondetarea.Models.Usuario;
import com.grupo08.gestiondetarea.Services.UsuarioServices;
import com.grupo08.gestiondetarea.Services.UsuarioServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
    @Autowired
    UsuarioServicesimpl usuarioService;

    @GetMapping("/lista")
    public List<Usuario> listaDeUsuarios(){
        List<Usuario> listaMostrar = usuarioService.listadeUsuarios();
        return listaMostrar;
    }
    @GetMapping("/{id}")
    public Usuario usuarioPorId (@PathVariable Long id){
        Usuario usuarioMostrar = usuarioService.buscarUsuarioPorId(id);
        return usuarioMostrar;
    }
    @PostMapping("/nuevo")
    public Usuario guardarNuevoUsuario (@RequestBody Usuario usuarioNuevo) {
        Usuario usuarioParaGuardar = usuarioService.guardarUsuario(usuarioNuevo);
        return usuarioParaGuardar;
    }

    @PutMapping("/editar/{id}")
    public Usuario editarUsuarioPorId (@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        Usuario usuarioEditado = usuarioService.editarUsuarioPorId(id,usuarioActualizado);
        return usuarioEditado;
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarCursoPorId (@PathVariable Long id){
        usuarioService.borrarUsuario(id);
        return "El Usuario a sido borrado exitosamente";
    }
}
