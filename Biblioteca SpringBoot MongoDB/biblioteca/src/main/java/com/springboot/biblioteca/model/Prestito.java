package com.springboot.biblioteca.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Prestito")
public class Prestito {
    private String idCliente;
    private String idLibro;
}
