package br.com.miniautorizador.api.adpaters.in.api.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

public class CartaoResponse {

    private String numero;
    private String senha;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal saldo;

    public CartaoResponse() {
    }

    public CartaoResponse(String numero, String senha) {
           this.numero = numero;
           this.senha = senha;
    }

    public CartaoResponse(String numero, String senha, BigDecimal saldo) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getNumero() {
        return numero;
    }

    public String getSenha() {
        return senha;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
