package br.com.miniautorizador.api.adpaters.in.api.model.response;

import java.util.List;

public class ListaCartoesResponse {

    private final List<CartaoResponse> cartoes;

    public ListaCartoesResponse(List<CartaoResponse> cartoes) {

        this.cartoes = cartoes;
    }

    public List<CartaoResponse> getCartoes() {
        return cartoes;
    }
}
