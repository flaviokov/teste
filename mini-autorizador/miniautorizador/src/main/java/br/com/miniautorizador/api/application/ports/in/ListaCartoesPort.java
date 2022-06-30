package br.com.miniautorizador.api.application.ports.in;

import br.com.miniautorizador.api.adpaters.in.api.model.response.ListaCartoesResponse;

public interface ListaCartoesPort {

    ListaCartoesResponse buscaTodosOsCartoes();
}
