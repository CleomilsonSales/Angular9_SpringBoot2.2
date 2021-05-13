package br.com.cleomilsonsales.service;

import br.com.cleomilsonsales.model.Cliente;
import br.com.cleomilsonsales.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //pedindo para o spring escanear essa classe também
public class ClientesService {
    //injeção de dependencias via construtor
    private ClientesRepository repository;

    @Autowired //pegando instancia do repositorio
    public ClientesService (ClientesRepository repository){
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){
        //validando
    }

}
