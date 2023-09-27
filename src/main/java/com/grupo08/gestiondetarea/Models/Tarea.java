package com.grupo08.gestiondetarea.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Tarea")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tareaId;

    @NotNull
    @Size(min = 3, max = 25)
    private String titulo;

    @NotNull
    private String descripcion;


    @Column(name = "Fecha de vencimiento")
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "usuarioId",nullable = false)
    private Usuario usuario;


    @JsonIgnore
    @OneToMany(mappedBy = "tarea", cascade = CascadeType.ALL)
    private List<Comentario> tareaComentario;

}
