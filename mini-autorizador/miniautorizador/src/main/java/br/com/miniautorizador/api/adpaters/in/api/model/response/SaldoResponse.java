package br.com.miniautorizador.api.adpaters.in.api.model.response;

import java.math.BigDecimal;

public class SaldoResponse {

    private final BigDecimal saldo;

    public SaldoResponse(BigDecimal saldo) {
           this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
