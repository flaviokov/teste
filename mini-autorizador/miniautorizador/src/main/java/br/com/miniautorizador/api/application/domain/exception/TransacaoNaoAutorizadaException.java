package br.com.miniautorizador.api.application.domain.exception;

public class TransacaoNaoAutorizadaException extends TransacaoInconsistenteException {
    public TransacaoNaoAutorizadaException(String message) {
        super(message);
    }
}
