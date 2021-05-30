package br.com.cleomilsonsales.clientes.model.repository;

import br.com.cleomilsonsales.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);

    // select count(*) > 0 from usuario where username = :username
    boolean existsByUsername(String username);
}
