package com.springboot.biblioteca.service.impl;


import com.springboot.biblioteca.model.Cliente;
import com.springboot.biblioteca.model.Libro;
import com.springboot.biblioteca.repository.LibroRepository;
import com.springboot.biblioteca.service.LibroService;
import org.springframework.stereotype.Service;

@Service
public class libroServiceImpl implements LibroService {
    private LibroRepository libroRepository;

    public libroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }


}
