package br.com.miniautorizador.api.handler;

public class ErrrorResponse {

    private final String mesagem;

    public ErrrorResponse(String mesagem) {
        this.mesagem = mesagem;
    }

    public String getMesagem() {
        return mesagem;
    }
}
