package com.example.libreria.model;

import com.example.libreria.model.Autor;
import com.example.libreria.model.Categoria;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

public class LibroAutorCategoria {


    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String titulo;

    @Getter
    @Setter
    private int edicion;

    @Getter
    @Setter
    private String autor;

    @Getter
    @Setter
    private String categoria;
}
