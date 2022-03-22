package com.example.libreria.resource;

import com.example.libreria.model.Autor;
import com.example.libreria.model.Libro;
import com.example.libreria.model.LibroAutorCategoria;
import com.example.libreria.services.LibroServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RestController
@RequestMapping("/libro")
public class LibroResource {
    private final LibroServices libroServices;


    public LibroResource(LibroServices libroServices){
        this.libroServices = libroServices;
    }
    @GetMapping("/all")
    public ResponseEntity<List<LibroAutorCategoria>> getAllLibros(){
        List<Libro> libros = libroServices.findAllLibros();
        List<LibroAutorCategoria> libroAutorCategoria = new ArrayList<>();
        for (int i = 0; i<libros.size(); i++) {
            if (libros.get(i).getAutor() == null){
                libros.get(i).setAutor(new Autor());
            }
            libroAutorCategoria.add(new LibroAutorCategoria());
            libroAutorCategoria.get(i).setId(libros.get(i).getId());
            libroAutorCategoria.get(i).setTitulo(libros.get(i).getTitulo());
            libroAutorCategoria.get(i).setEdicion(libros.get(i).getEdicion());
            libroAutorCategoria.get(i).setAutor(libros.get(i).getAutor().getNombre() + " " + libros.get(i).getAutor().getApellido1());
            libroAutorCategoria.get(i).setCategoria(libros.get(i).getCategoria().getDescripcion());

        }
        
        return new ResponseEntity<>(libroAutorCategoria, HttpStatus.OK);
    }
    @GetMapping("getById/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable("id") Long id){
        Libro libro = libroServices.findLibroById(id);
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Libro> addLibro(@RequestBody Libro libro){
        Libro newLibro = libroServices.addLibro(libro);
        return new ResponseEntity<>(newLibro, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Libro> updateLibro(@RequestBody Libro libro, Long id){
        Libro updateLibro = libroServices.updateLibro(libro, id);
        return new ResponseEntity<>(updateLibro, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Libro> deleteLibro(@PathVariable("id") Long id){
        libroServices.deleteLibro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/autor/{dni}")
    public ResponseEntity<List<Libro>> getLibrosMismoAutor(@PathVariable("dni") String dni){
        List<Libro> libros = libroServices.findLibroByAutorId(dni);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }
    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<Libro>> getLibrosMismaCategoria(@PathVariable("id") Long id){
        List<Libro> libros = libroServices.findLibroByCategoriaId(id);
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }
}
