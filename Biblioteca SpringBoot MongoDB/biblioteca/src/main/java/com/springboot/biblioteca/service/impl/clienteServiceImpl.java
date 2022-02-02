package com.springboot.biblioteca.service.impl;


import com.springboot.biblioteca.model.Cliente;
import com.springboot.biblioteca.model.Libro;
import com.springboot.biblioteca.repository.ClienteRepository;
import com.springboot.biblioteca.repository.LibroRepository;
import com.springboot.biblioteca.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class clienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    public clienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}
