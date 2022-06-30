package br.com.miniautorizador.api.application.ports.in;

import br.com.miniautorizador.api.adpaters.in.api.model.request.AutorizadorCartaoRequest;
import br.com.miniautorizador.api.adpaters.in.api.model.response.CartaoResponse;

public interface CriaCartaoPort {

    CartaoResponse from(AutorizadorCartaoRequest request);
}
