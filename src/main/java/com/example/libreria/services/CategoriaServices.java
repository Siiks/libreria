package com.example.libreria.services;

import com.example.libreria.model.Categoria;

import com.example.libreria.repo.CategoriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
    public class CategoriaServices{
        private final CategoriaRepo categoriaRepo;
        private final String error = "No se ha encontrado al Categoria";

        @Autowired
        public CategoriaServices(CategoriaRepo categoriaRepo){
            this.categoriaRepo = categoriaRepo;
        }

        public Categoria addCategoria(Categoria categoria){
            return categoriaRepo.save(categoria);
        }

        public List<Categoria> findAllCategorias(){
            return categoriaRepo.findAll();
        }

        public Categoria findCategoriaByDni(int id){
            return categoriaRepo.findCategoriaById(id).orElseThrow(() -> new IllegalArgumentException(error));
        }

        public void deleteCategoria(int id){
            categoriaRepo.deleteCategoriaById(id);
        }

        public Categoria updateCategoria(Categoria categoria){
            return categoriaRepo.save(categoria);
        }
    }

