package br.com.cleomilsonsales.clientes.model.repository;

import br.com.cleomilsonsales.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
