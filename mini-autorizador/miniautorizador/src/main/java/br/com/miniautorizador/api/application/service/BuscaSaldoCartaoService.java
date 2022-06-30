package br.com.miniautorizador.api.application.service;

import br.com.miniautorizador.api.adpaters.in.api.model.response.SaldoResponse;
import br.com.miniautorizador.api.application.ports.in.BuscaSaldoCartaoPort;
import br.com.miniautorizador.api.application.ports.out.CartoesQueryPort;
import org.springframework.stereotype.Service;

@Service
 class BuscaSaldoCartaoService implements BuscaSaldoCartaoPort {

    private CartoesQueryPort cartoesQueryPort;

    public BuscaSaldoCartaoService(CartoesQueryPort cartoesQueryPort) {
        this.cartoesQueryPort = cartoesQueryPort;
    }

    @Override
    public SaldoResponse buscaSaldoDoCartao(String numeroDoCartao) {
        var cartao =this.cartoesQueryPort.buscaSaldo(numeroDoCartao);
        return new SaldoResponse(cartao.getSaldo());
    }
}
