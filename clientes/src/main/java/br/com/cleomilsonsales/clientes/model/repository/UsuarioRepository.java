package br.com.cleomilsonsales.clientes.model.repository;

import br.com.cleomilsonsales.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
