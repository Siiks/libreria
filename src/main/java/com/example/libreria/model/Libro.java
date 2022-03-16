package com.example.libreria.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Libro implements Serializable {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
    @Getter
    @Setter
    private String titulo;
    @Getter
    @Setter
    @Column(nullable = false)
    private int edicion;
    @Getter
    @Setter
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "autor_dni")
    private Autor autor;
    @Getter
    @Setter
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
