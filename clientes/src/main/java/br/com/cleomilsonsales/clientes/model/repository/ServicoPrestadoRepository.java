package br.com.cleomilsonsales.clientes.model.repository;

import br.com.cleomilsonsales.clientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {
}
