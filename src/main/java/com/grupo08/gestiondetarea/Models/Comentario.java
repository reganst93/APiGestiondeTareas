package com.grupo08.gestiondetarea.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Comentario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comentarioId;

    @NotNull
    private String texto;

    @Column(name = "Fecha de creacion")
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaCreacion;


    @ManyToOne
    @JoinColumn(name = "tareaid", nullable = false)
    private Tarea tarea;

}
