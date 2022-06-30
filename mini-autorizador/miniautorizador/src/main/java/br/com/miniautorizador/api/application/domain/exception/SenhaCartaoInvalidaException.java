package br.com.miniautorizador.api.application.domain.exception;

public class SenhaCartaoInvalidaException extends TransacaoInconsistenteException{
    public SenhaCartaoInvalidaException(String message) {
        super(message);
    }
}
