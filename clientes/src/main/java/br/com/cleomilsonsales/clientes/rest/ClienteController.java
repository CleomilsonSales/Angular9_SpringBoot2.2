package br.com.cleomilsonsales.clientes.rest;

import br.com.cleomilsonsales.clientes.model.entity.Cliente;
import br.com.cleomilsonsales.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200") //permite comunição entre o backend é o frontend por estarem em dominios diferentes
public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //Recebendo os status 201
    public Cliente salvar(@RequestBody @Valid Cliente cliente){
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente acharPorId(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //É um status de sucesso que não retornou nada
    public void deletar(@PathVariable Integer id){
        //vai pesquisar o cliente, se não achar retorna um 404-not_found

        repository
                .findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE; //se encontrar deleta e retorna apenas um type para não retornar um nulo e não cair na exceção
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Cliente clienteUp){
        repository
                .findById(id)
                .map(cliente -> {
                    clienteUp.setId(cliente.getId());
                    /* ou passo as colunas que serão atualizadas
                    cliente.setNome(clienteUp.getNome());
                    cliente.setCpf(clienteUp.getCpf());
                    return repository.save(cliente);
                    * */
                    return repository.save(clienteUp);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }



}
