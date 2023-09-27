package com.grupo08.gestiondetarea.Services;

import com.grupo08.gestiondetarea.Models.Usuario;
import com.grupo08.gestiondetarea.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicesimpl implements UsuarioServices {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> listadeUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        Boolean existe = usuarioRepository.existsById(id);
        if (existe) {
            Usuario usuarioEscogido = usuarioRepository.findById(id).get();
            return usuarioEscogido;
        } else {
            System.out.println("El id es invalido o no existe");
            return null;
        }
    }

    @Override
    public Usuario guardarUsuario(Usuario usuarioNuevo) {
        Usuario usuarioExiste = usuarioRepository.findByUsuarioNombre(usuarioNuevo.getUsuarioNombre());
        if (usuarioExiste != null){
            System.out.println("El nombre de usuario ya esta en uso");
            return null;
        }else {
            return usuarioRepository.save(usuarioNuevo);
        }
    }

    @Override
    public Usuario editarUsuarioPorId(Long id, Usuario usuarioActualizado) {
        Boolean existe = usuarioRepository.existsById(id);
        if (existe) {
            Usuario usuarioSeleccionado = usuarioRepository.findById(id).get();
            usuarioSeleccionado.setUsuarioNombre(usuarioActualizado.getUsuarioNombre());
            usuarioSeleccionado.setEmail(usuarioSeleccionado.getEmail());
            System.out.println("El usuario a sido actualizado");
            return usuarioRepository.save(usuarioSeleccionado);
        } else {
            System.out.println("El id no es valido");
            return null;
        }
    }

    @Override
    public void borrarUsuario(Long id) {
        usuarioRepository.deleteById(id);

    }
}