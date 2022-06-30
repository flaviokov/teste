package br.com.miniautorizador.api.adpaters.in.api.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class TransacaoResponse {

    private String status;

    public TransacaoResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
