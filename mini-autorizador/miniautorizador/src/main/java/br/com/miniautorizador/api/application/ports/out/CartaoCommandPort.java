package br.com.miniautorizador.api.application.ports.out;

import br.com.miniautorizador.api.application.domain.Cartao;

public interface CartaoCommandPort {

    CriaCartaoCommand salva( CriaCartaoCommand command);

    void atualizaSaldo(Cartao cartao);
}
