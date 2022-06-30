package br.com.miniautorizador.api.application.service;

import br.com.miniautorizador.api.adpaters.in.api.model.mapper.CartaoMapper;
import br.com.miniautorizador.api.adpaters.in.api.model.response.CartaoResponse;
import br.com.miniautorizador.api.adpaters.in.api.model.response.ListaCartoesResponse;
import br.com.miniautorizador.api.application.ports.in.ListaCartoesPort;
import br.com.miniautorizador.api.application.ports.out.CartoesQueryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
 class ListaCartoesService implements ListaCartoesPort {

    private CartoesQueryPort cartoesQueryPort;

    public ListaCartoesService(CartoesQueryPort cartoesQueryPort) {
        this.cartoesQueryPort = cartoesQueryPort;
    }

    @Override
    public ListaCartoesResponse buscaTodosOsCartoes() {

        List<CartaoResponse> collect = this.cartoesQueryPort.buscaTodos()
                .stream()
                .map(cartao -> CartaoMapper.toCartaoResponse(cartao))
                .collect(Collectors.toList());

        return new ListaCartoesResponse(collect);
    }
}
