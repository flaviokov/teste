package br.com.miniautorizador.api.application.ports.out;

import br.com.miniautorizador.api.application.domain.Cartao;

import java.math.BigDecimal;

public class CriaCartaoCommand {

    private Cartao cartao;

    public CriaCartaoCommand(Cartao cartao) {
        this.cartao = cartao;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public static CriaCartaoCommand comCartao(String numero, String senha, BigDecimal saldo) {
        return new CriaCartaoCommand(new Cartao(numero,senha,saldo));
    }

}
