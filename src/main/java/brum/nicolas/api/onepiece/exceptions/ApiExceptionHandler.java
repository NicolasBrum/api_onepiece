package brum.nicolas.api.onepiece.exceptions;

import brum.nicolas.api.onepiece.entities.exceptions.MissaoNotFoundException;
import brum.nicolas.api.onepiece.entities.exceptions.PirataNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensagemErro> methodArgumentNotValid(HttpServletRequest servletRequest, MethodArgumentNotValidException ex) {
        var erroMensagem = new MensagemErro(servletRequest, HttpStatus.UNPROCESSABLE_ENTITY,"campos invalidos!",ex.getBindingResult());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(erroMensagem);
    }

    @ExceptionHandler(PirataNotFoundException.class)
    public ResponseEntity<MensagemErro> pirataNotFound(HttpServletRequest servletRequest, PirataNotFoundException ex) {
        var erroMensagem =  new MensagemErro(servletRequest, HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(erroMensagem);
    }

    @ExceptionHandler(MissaoNotFoundException.class)
    public ResponseEntity<MensagemErro> missaoNotFoundException(HttpServletRequest servletRequest, MissaoNotFoundException ex) {
        var erroMensagem =  new MensagemErro(servletRequest, HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(erroMensagem);
    }
}
