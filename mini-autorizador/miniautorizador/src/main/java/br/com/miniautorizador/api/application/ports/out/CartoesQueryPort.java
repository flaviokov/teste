package br.com.miniautorizador.api.application.ports.out;

import br.com.miniautorizador.api.application.domain.Cartao;

import java.util.List;

public interface CartoesQueryPort {

    List<Cartao> buscaTodos();

    Cartao buscaCartao(String numero,String senhs);

    Cartao buscaSaldo(String numeroDoCartao);
}
