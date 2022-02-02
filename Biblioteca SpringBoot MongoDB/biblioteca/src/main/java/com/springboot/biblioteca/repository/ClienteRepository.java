package com.springboot.biblioteca.repository;


import com.springboot.biblioteca.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
