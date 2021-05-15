package br.com.cleomilsonsales.clientes.rest;

import br.com.cleomilsonsales.clientes.rest.exception.ApiErros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

//@RestController //para não usar um ResponseBody quando ouver retorno da aplicação
@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class) //interceptando essa exceção de validação
    @ResponseStatus(HttpStatus.BAD_REQUEST) //400
    public ApiErros handleValidationErros(MethodArgumentNotValidException ex){
        //LEMBRANDO: map pega um objeto e transforma em outro
        BindingResult bindingResult = ex.getBindingResult();

        List<String> messages = bindingResult.getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage()) //transformando um strem de objetos em uma stream de String
                .collect(Collectors.toList());
        return new ApiErros(messages);
    }

    @ExceptionHandler(ResponseStatusException.class) //intercepta erros e melhora a mensagem
    public ResponseEntity handlerResponseStatusException (ResponseStatusException ex){
        String mensagemErro = ex.getMessage();
        HttpStatus codigoStatus = ex.getStatus();
        ApiErros apiErros = new ApiErros(mensagemErro);
        return new ResponseEntity(apiErros,codigoStatus);
    }
}
