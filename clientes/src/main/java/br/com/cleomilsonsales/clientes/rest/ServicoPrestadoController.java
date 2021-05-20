package br.com.cleomilsonsales.clientes.rest;

import br.com.cleomilsonsales.clientes.model.entity.Cliente;
import br.com.cleomilsonsales.clientes.model.entity.ServicoPrestado;
import br.com.cleomilsonsales.clientes.model.repository.ClienteRepository;
import br.com.cleomilsonsales.clientes.model.repository.ServicoPrestadoRepository;
import br.com.cleomilsonsales.clientes.rest.dto.ServicoPrestadorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor //para evitar fazer o construtor dos final
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository repository;

    @PostMapping
    public ServicoPrestado salvar(@RequestBody ServicoPrestadorDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado"));
        /*
        //Optional quer dizer que o objeto pode ter algo ou não(null)
        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
        //orElse eu quero o cliente encontrado, se não, me der um novo cliente - assim evitar o nullException
        Cliente cliente = clienteOptional.orElse(new Cliente());
        */
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor();
    }
}
