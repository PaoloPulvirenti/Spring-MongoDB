package com.springboot.biblioteca.controller;


import com.springboot.biblioteca.model.Cliente;
import com.springboot.biblioteca.model.Libro;
import com.springboot.biblioteca.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/libro")
public class libroController {
    private LibroService libroService;

    public libroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping()
    public ResponseEntity<Libro> saveLibro(@RequestBody Libro libro) {
        return new ResponseEntity<Libro>(libroService.saveLibro(libro), HttpStatus.CREATED);
    }
}
