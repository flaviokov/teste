package br.com.miniautorizador.api.application.domain.exception;

public class TransacaoInconsistenteException extends RuntimeException {

    public TransacaoInconsistenteException(String message) {
        super(message);
    }
}
