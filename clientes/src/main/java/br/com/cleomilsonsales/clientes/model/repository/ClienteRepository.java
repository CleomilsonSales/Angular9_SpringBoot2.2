package br.com.cleomilsonsales.clientes.model.repository;

import br.com.cleomilsonsales.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
