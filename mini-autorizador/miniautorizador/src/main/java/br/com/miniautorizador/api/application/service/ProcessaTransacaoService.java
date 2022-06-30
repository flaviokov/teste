package br.com.miniautorizador.api.application.service;

import br.com.miniautorizador.api.adpaters.in.api.model.request.TransacaoRequest;
import br.com.miniautorizador.api.adpaters.in.api.model.response.TransacaoResponse;
import br.com.miniautorizador.api.application.domain.Transacao;
import br.com.miniautorizador.api.application.domain.enums.StatusTransacao;
import br.com.miniautorizador.api.application.ports.in.ProcessaTransacaoPort;
import br.com.miniautorizador.api.application.ports.out.CartaoCommandPort;
import br.com.miniautorizador.api.application.ports.out.CartoesQueryPort;
import org.springframework.stereotype.Service;

@Service
 class ProcessaTransacaoService implements ProcessaTransacaoPort {

    private CartoesQueryPort cartoesQueryPort;

    private CartaoCommandPort cartaoCommandPort;

    public ProcessaTransacaoService(CartoesQueryPort cartoesQueryPort, CartaoCommandPort cartaoCommandPort) {
        this.cartoesQueryPort = cartoesQueryPort;
        this.cartaoCommandPort = cartaoCommandPort;
    }

    @Override
    public TransacaoResponse processa(TransacaoRequest request) {

        var cartao = this.cartoesQueryPort.buscaCartao(request.numero(),request.senha());

        Transacao transacao = new Transacao.Processa(cartao)
                    .verificaSenha(request.senha())
                    .verificaSaldo(request.valor())
                    .aplicaValor();

        this.cartaoCommandPort.atualizaSaldo(transacao.getCartao());

        return new TransacaoResponse(StatusTransacao.AUTORIZADO.name());

    }
}
