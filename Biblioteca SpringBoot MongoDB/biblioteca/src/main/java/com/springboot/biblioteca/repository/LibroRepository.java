package com.springboot.biblioteca.repository;


import com.springboot.biblioteca.model.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibroRepository extends MongoRepository<Libro, String> {
}
