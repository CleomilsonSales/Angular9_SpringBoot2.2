package br.com.cleomilsonsales.clientes.rest;

import br.com.cleomilsonsales.clientes.model.entity.Cliente;
import br.com.cleomilsonsales.clientes.model.entity.ServicoPrestado;
import br.com.cleomilsonsales.clientes.model.repository.ClienteRepository;
import br.com.cleomilsonsales.clientes.model.repository.ServicoPrestadoRepository;
import br.com.cleomilsonsales.clientes.rest.dto.ServicoPrestadorDTO;
import br.com.cleomilsonsales.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor //para evitar fazer o construtor dos final que precisaria para injetar as dependencias
//@CrossOrigin("http://localhost:4200") - esta sendo feita pela class WebConfig
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadorDTO dto){
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
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));

        return repository.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome, //required = false - indica que esse parametro não é obrigatório
            @RequestParam(value = "mes", required = false) Integer mes
    ){
        return repository.findByNomeClienteAndMes("%"+nome+"%", mes);
    }
}
