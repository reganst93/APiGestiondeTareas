package com.grupo08.gestiondetarea.Controllers;

import com.grupo08.gestiondetarea.Models.Tarea;
import com.grupo08.gestiondetarea.Services.TareaServicesimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaRestController {
    @Autowired
    TareaServicesimpl tareaServices;

    @GetMapping("/lista")
    public List<Tarea> listadeTareas() {
        List<Tarea> listaMostrar = tareaServices.listaDeTareas();
        return listaMostrar;
    }

    @GetMapping("/{id}")
    public Tarea tareaPorId(@PathVariable Long id) {
        Tarea tareaMostrar = tareaServices.buscarTareaPorId(id);
        return tareaMostrar;

    }

    @PostMapping("/nueva")
    public Tarea guardarTareaNueva(@RequestBody Tarea tareaNueva) {
        Tarea tareaParaGuardar = tareaServices.guardarTarea(tareaNueva);
        return tareaParaGuardar;
    }

    @PutMapping("/editar/{id}")
    public Tarea editarTareaPorId (@PathVariable Long id, @RequestBody Tarea tareaActualizada){
        Tarea tareaEditada = tareaServices.editarTareaPorId(id,tareaActualizada);
        return tareaEditada;
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarTareaPorId (@PathVariable Long id){
        tareaServices.borrarTarea(id);
        return "La tarea a sido borrada existosamente";
    }

}

