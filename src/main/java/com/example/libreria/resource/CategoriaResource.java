package com.example.libreria.resource;

import com.example.libreria.model.Categoria;
import com.example.libreria.services.CategoriaServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource{
    private final CategoriaServices categoriaServices;

    public CategoriaResource(CategoriaServices categoriaServices) {
        this.categoriaServices = categoriaServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        List<Categoria> categorias = categoriaServices.findAllCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<Categoria> getCategoriasById(@PathVariable("id") int id){
        Categoria categoria = categoriaServices.findCategoriaByDni(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria){
        Categoria newCategoria = categoriaServices.addCategoria(categoria);
        return new ResponseEntity<>(newCategoria, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria){
        Categoria updateCategoria = categoriaServices.updateCategoria(categoria);
        return new ResponseEntity<>(updateCategoria, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Categoria> deleteCategoria(@PathVariable("dni") int id){
        categoriaServices.deleteCategoria(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
