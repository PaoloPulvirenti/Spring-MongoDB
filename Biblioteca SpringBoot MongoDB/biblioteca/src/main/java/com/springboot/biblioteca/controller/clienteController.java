package com.springboot.biblioteca.controller;

import com.springboot.biblioteca.model.Cliente;
import com.springboot.biblioteca.model.Libro;
import com.springboot.biblioteca.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/cliente")
public class clienteController {

    private ClienteService clienteService;

    public clienteController(ClienteService clienteService) {this.clienteService = clienteService;}



    @PostMapping
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<Cliente>(clienteService.saveCliente(cliente), HttpStatus.CREATED);
    }
}
