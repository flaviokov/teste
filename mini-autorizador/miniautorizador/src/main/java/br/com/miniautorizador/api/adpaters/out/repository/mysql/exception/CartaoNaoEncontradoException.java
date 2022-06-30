package br.com.miniautorizador.api.adpaters.out.repository.mysql.exception;

public class CartaoNaoEncontradoException extends RuntimeException {
    public CartaoNaoEncontradoException(String message) {
        super(message);
    }
}
