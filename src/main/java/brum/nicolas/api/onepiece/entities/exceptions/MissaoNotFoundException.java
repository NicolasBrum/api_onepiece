package brum.nicolas.api.onepiece.entities.exceptions;


public class MissaoNotFoundException extends RuntimeException {
    public MissaoNotFoundException(String mensagem) {
        super(mensagem);
    }
}
