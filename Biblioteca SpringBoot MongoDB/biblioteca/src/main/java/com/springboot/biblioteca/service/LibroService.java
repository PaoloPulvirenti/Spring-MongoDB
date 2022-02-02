package com.springboot.biblioteca.service;

import com.springboot.biblioteca.model.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibroService {
    Libro saveLibro(Libro libro);
}
