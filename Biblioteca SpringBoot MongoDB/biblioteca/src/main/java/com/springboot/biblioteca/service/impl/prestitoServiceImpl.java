package com.springboot.biblioteca.service.impl;

import com.springboot.biblioteca.model.Cliente;
import com.springboot.biblioteca.model.Libro;
import com.springboot.biblioteca.model.Prestito;
import com.springboot.biblioteca.repository.ClienteRepository;
import com.springboot.biblioteca.repository.LibroRepository;
import com.springboot.biblioteca.service.PrestitoService;
import org.springframework.stereotype.Service;

@Service
public class prestitoServiceImpl implements PrestitoService {

    private LibroRepository libroRepository;
    private ClienteRepository clienteRepository;

    public prestitoServiceImpl(LibroRepository libroRepository, ClienteRepository clienteRepository) {
        this.libroRepository = libroRepository;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente addLibro(String cliente,Libro libro) {
        Cliente saveCliente= clienteRepository.findById(cliente)
                .orElseThrow(()->new RuntimeException(
                        String.format("Non ho trovato nessuno con questo ID %s",cliente)));
        Libro saveLibro= libroRepository.findById(libro.getId())
                .orElseThrow(()->new RuntimeException(
                        String.format("Non ho trovato nessun libro con questo ID %s",libro.getId())));
        if(saveLibro.getPrestito()== null) {
            saveLibro.setPrestito("Occupato");
            libroRepository.save(saveLibro);
            saveLibro.setPrestito(null);
            saveCliente.getListaLibri().add(saveLibro);
            return clienteRepository.save(saveCliente);
        }
        else
        {
           throw new RuntimeException(String.format("Il libro %s e' gia' occupato",libro.getId()));
        }

    }

    @Override
    public Cliente addLibroPOST(Prestito prestito) {
        Cliente saveCliente= clienteRepository.findById(prestito.getIdCliente())
                .orElseThrow(()->new RuntimeException(
                        String.format("Non ho trovato nessuno con questo ID %s",prestito.getIdCliente())));
        Libro saveLibro= libroRepository.findById(prestito.getIdLibro())
                .orElseThrow(()->new RuntimeException(
                        String.format("Non ho trovato nessun libro con questo ID %s",prestito.getIdLibro())));
        if(saveLibro.getPrestito()== null) {
            saveLibro.setPrestito("Occupato");
            libroRepository.save(saveLibro);
            saveLibro.setPrestito(null);
            saveCliente.getListaLibri().add(saveLibro);
            return clienteRepository.save(saveCliente);
        }
        else
        {
            throw new RuntimeException(String.format("Il libro %s e' gia' occupato",prestito.getIdLibro()));
        }
    }

    @Override
    public Cliente removeLibro(String cliente, Libro libro) {
        Cliente saveCliente= clienteRepository.findById(cliente)
                .orElseThrow(()->new RuntimeException(
                        String.format("Non ho trovato nessuno con questo ID %s",cliente)));

        for(int i=0;i<saveCliente.getListaLibri().size();i++){
        if(saveCliente.getListaLibri().get(i).getId().equals(libro.getId())) {
            saveCliente.getListaLibri().remove(i);
            Libro saveLibro= libroRepository.findById(libro.getId())
                    .orElseThrow(()->new RuntimeException(
                            String.format("il cliente %s non ha il libro %s",cliente,libro.getId())));
            saveLibro.setPrestito(null);
            libroRepository.save(saveLibro);
            return clienteRepository.save(saveCliente);
            }
        }
            return clienteRepository.save(saveCliente);
    }

    @Override
    public Cliente removeLibroPOST(Prestito prestito) {
        Cliente saveCliente= clienteRepository.findById(prestito.getIdCliente())
                .orElseThrow(()->new RuntimeException(
                        String.format("Non ho trovato nessuno con questo ID %s",prestito.getIdCliente())));

        for(int i=0;i<saveCliente.getListaLibri().size();i++){
            if(saveCliente.getListaLibri().get(i).getId().equals(prestito.getIdLibro())) {
                saveCliente.getListaLibri().remove(i);
                Libro saveLibro= libroRepository.findById(prestito.getIdLibro())
                        .orElseThrow(()->new RuntimeException(
                                String.format("il cliente %s non ha il libro %s",prestito.getIdCliente(),prestito.getIdLibro())));
                saveLibro.setPrestito(null);
                libroRepository.save(saveLibro);
                return clienteRepository.save(saveCliente);
            }
        }
        return clienteRepository.save(saveCliente);
    }
}
