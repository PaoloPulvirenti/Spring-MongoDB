package com.springboot.biblioteca.service;

import com.springboot.biblioteca.model.Cliente;
import com.springboot.biblioteca.model.Libro;
import com.springboot.biblioteca.model.Prestito;
import org.springframework.stereotype.Service;

@Service
public interface PrestitoService {
    Cliente addLibro(String cliente, Libro libro);
    Cliente addLibroPOST(Prestito prestito);
    Cliente removeLibro(String cliente, Libro libro);
    Cliente removeLibroPOST(Prestito prestito);
}
