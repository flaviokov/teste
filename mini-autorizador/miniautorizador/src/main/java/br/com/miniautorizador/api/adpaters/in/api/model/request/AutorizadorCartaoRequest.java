package br.com.miniautorizador.api.adpaters.in.api.model.request;

public record AutorizadorCartaoRequest(
      String numeroCartao,
      String senha
) {
}
