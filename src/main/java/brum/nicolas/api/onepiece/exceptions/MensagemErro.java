package brum.nicolas.api.onepiece.exceptions;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString
public class MensagemErro {
    private String caminho;
    private int statusCode;
    private String mensagem;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> erros;

    public MensagemErro(HttpServletRequest request, HttpStatus statusCode, String mensagem) {
        this.statusCode = statusCode.value();
        this.mensagem = mensagem;
        this.caminho = request.getRequestURI();
    }


    public MensagemErro(HttpServletRequest request, HttpStatus statusCode, String mensagem, BindingResult bindingResult) {
        this.statusCode = statusCode.value();
        this.mensagem = mensagem;
        this.caminho = request.getRequestURI();
        addErros(bindingResult);
    }

    private void addErros(BindingResult bindingResult) {
        this.erros = new HashMap<>();

        for(FieldError fieldError : bindingResult.getFieldErrors()) {
            erros.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
