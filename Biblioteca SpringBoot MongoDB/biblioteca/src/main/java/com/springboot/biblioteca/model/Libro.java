package com.springboot.biblioteca.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("Libro")
public class Libro {

    @Id
    private String id;
    private String nome;
    private String scaffale;
    private String prestito;
}
