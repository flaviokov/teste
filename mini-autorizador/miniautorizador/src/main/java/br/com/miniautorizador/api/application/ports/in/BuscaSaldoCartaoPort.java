package br.com.miniautorizador.api.application.ports.in;

import br.com.miniautorizador.api.adpaters.in.api.model.response.SaldoResponse;

public interface BuscaSaldoCartaoPort {

    SaldoResponse buscaSaldoDoCartao(String numeroDoCartao);

}
