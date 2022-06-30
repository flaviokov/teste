package br.com.miniautorizador.api.adpaters.out.repository.mysql.exception;

import br.com.miniautorizador.api.adpaters.out.repository.mysql.entity.CartaoEntity;

public class CartaoExistenteException extends RuntimeException{
    private CartaoEntity cartao;

    public CartaoExistenteException(CartaoEntity cartao) {
        this.cartao = cartao;
    }

    public CartaoEntity getCartao() {
        return cartao;
    }
}
