package com.springboot.biblioteca.service;


import com.springboot.biblioteca.model.Cliente;
import com.springboot.biblioteca.model.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {
    Cliente saveCliente(Cliente cliente);
}
