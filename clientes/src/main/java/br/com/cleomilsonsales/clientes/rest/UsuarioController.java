package br.com.cleomilsonsales.clientes.rest;

import br.com.cleomilsonsales.clientes.model.entity.Usuario;
import br.com.cleomilsonsales.clientes.model.repository.UsuarioRepository;
import br.com.cleomilsonsales.clientes.rest.exception.UsuarioCadastradoException;
import br.com.cleomilsonsales.clientes.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor //se não for final não sera injetada a dependencia
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        try{
            usuarioService.salvar(usuario);
        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
