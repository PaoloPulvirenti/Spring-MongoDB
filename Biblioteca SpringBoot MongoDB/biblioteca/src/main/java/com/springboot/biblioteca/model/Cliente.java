package com.springboot.biblioteca.model;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Data
@Document("Cliente")
public class Cliente {

    @Id
    private String id;
    private String nome;
    private String cognome;
    private String email;
    private List<Libro> listaLibri= new ArrayList<>();

}
