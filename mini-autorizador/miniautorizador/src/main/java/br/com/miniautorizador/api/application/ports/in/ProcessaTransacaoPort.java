package br.com.miniautorizador.api.application.ports.in;

import br.com.miniautorizador.api.adpaters.in.api.model.request.TransacaoRequest;
import br.com.miniautorizador.api.adpaters.in.api.model.response.TransacaoResponse;

public interface ProcessaTransacaoPort {

    TransacaoResponse processa(TransacaoRequest request);

}
