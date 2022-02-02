package com.springboot.biblioteca.controller;

import com.springboot.biblioteca.model.Cliente;
import com.springboot.biblioteca.model.Libro;
import com.springboot.biblioteca.model.Prestito;
import com.springboot.biblioteca.service.ClienteService;
import com.springboot.biblioteca.service.LibroService;
import com.springboot.biblioteca.service.PrestitoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prenotazione")
public class prestitoController {

    private LibroService libroService;
    private ClienteService clienteService;
    private PrestitoService prestitoService;

    public prestitoController(LibroService libroService, ClienteService clienteService,PrestitoService prestitoService) {
        this.libroService = libroService;
        this.clienteService = clienteService;
        this.prestitoService = prestitoService;
    }

    @PostMapping("prestito")
    public ResponseEntity<Cliente> addLibroPOST(@RequestBody Prestito prestito )
    {
        return new ResponseEntity<Cliente>(prestitoService.addLibroPOST(prestito), HttpStatus.OK);
    }
    @PostMapping("remove")
    public ResponseEntity<Cliente> removeLibroPOST(@RequestBody Prestito prestito )
    {
        return new ResponseEntity<Cliente>(prestitoService.removeLibroPOST(prestito), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> addLibro(@PathVariable("id") String clienteId , @RequestBody Libro libro )
    {
        return new ResponseEntity<Cliente>(prestitoService.addLibro(clienteId,libro), HttpStatus.OK);
    }

    @PutMapping("remove/{id}")
    public ResponseEntity<Cliente> removeLibro(@PathVariable("id") String clienteId , @RequestBody Libro libro )
    {
        return new ResponseEntity<Cliente>(prestitoService.removeLibro(clienteId,libro), HttpStatus.OK);
    }
}
