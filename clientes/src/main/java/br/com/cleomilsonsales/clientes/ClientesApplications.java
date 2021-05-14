package br.com.cleomilsonsales.clientes;

import br.com.cleomilsonsales.clientes.model.entity.Cliente;
import br.com.cleomilsonsales.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication //inicializa a aplicação e escanea as injeção de dependências
public class ClientesApplications {
    //testando a inserção de cliente
    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository repository){
        return args -> {
            Cliente cliente = Cliente
                    .builder()
                    .cpf("12345678911")
                    .nome("Saori Miranda")
                    .build();
            repository.save(cliente);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ClientesApplications.class, args);
    }
}
