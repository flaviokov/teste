package br.com.miniautorizador.api.adpaters.in.api.model.request;

import java.math.BigDecimal;

public record TransacaoRequest (

    String numero,
    String senha,
    BigDecimal valor
) { }
