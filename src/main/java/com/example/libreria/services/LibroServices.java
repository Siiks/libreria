package com.example.libreria.services;

import com.example.libreria.model.Autor;
import com.example.libreria.model.Libro;
import com.example.libreria.repo.LibroRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class LibroServices {
    private  LibroRepo libroRepo;
    private final String error = "No se ha encontrado al Libro";

    @Autowired
    public LibroServices(LibroRepo libroRepo) {
        this.libroRepo = libroRepo;
    }

    public Libro addLibro(Libro libro){
        return libroRepo.save(libro);
    }

    public List<Libro> findAllLibros(){
        return libroRepo.findAll();
    }

    public Libro findLibroById(Long id){
        return libroRepo.findLibroById(id).orElseThrow(() -> new IllegalArgumentException(error));
    }

    public void deleteLibro(Long id){
        libroRepo.deleteLibroById(id);
    }

    public Libro updateLibro(Libro libro, Long id){
        if (libroRepo.findLibroById(id).isPresent() == true){
            return libroRepo.save(libro);
        }else{
            throw new IllegalArgumentException("El libro no existe");
        }

    }

    public List<Libro> findLibroByAutorId(String dni){
        return libroRepo.findLibroByAutorDni(dni);
    }

    public List<Libro> findLibroByCategoriaId(Long id){
        return libroRepo.findLibroByCategoriaId(id);
    }
}

