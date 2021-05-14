package br.com.cleomilsonsales.clientes.rest;

import br.com.cleomilsonsales.clientes.model.entity.Cliente;
import br.com.cleomilsonsales.clientes.model.repository.ClienteRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //recebendo os status 201
    public Cliente salvar(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
