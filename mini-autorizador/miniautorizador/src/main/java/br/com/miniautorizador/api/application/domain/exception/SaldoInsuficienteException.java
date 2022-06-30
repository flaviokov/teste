package br.com.miniautorizador.api.application.domain.exception;

public class SaldoInsuficienteException extends TransacaoInconsistenteException {
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}
