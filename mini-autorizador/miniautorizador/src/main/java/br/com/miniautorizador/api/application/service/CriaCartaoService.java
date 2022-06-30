package br.com.miniautorizador.api.application.service;

import br.com.miniautorizador.api.adpaters.in.api.model.request.AutorizadorCartaoRequest;
import br.com.miniautorizador.api.adpaters.in.api.model.response.CartaoResponse;
import br.com.miniautorizador.api.application.domain.Cartao;
import br.com.miniautorizador.api.application.ports.in.CriaCartaoPort;
import br.com.miniautorizador.api.application.ports.out.CriaCartaoCommand;
import br.com.miniautorizador.api.application.ports.out.CartaoCommandPort;
import org.springframework.stereotype.Service;

@Service
 class CriaCartaoService implements CriaCartaoPort {

    private CartaoCommandPort cartaoCommandPort;

    public CriaCartaoService(CartaoCommandPort cartaoCommandPort) {
        this.cartaoCommandPort = cartaoCommandPort;
    }

    @Override
    public CartaoResponse from(AutorizadorCartaoRequest request) {

        var cartao = new Cartao(request.numeroCartao(),request.senha());

        var cartaoCommand = this.cartaoCommandPort.salva(new CriaCartaoCommand(cartao));

        return new CartaoResponse(cartaoCommand.getCartao().getNumero(),cartaoCommand.getCartao().getSenha());
    }
}
