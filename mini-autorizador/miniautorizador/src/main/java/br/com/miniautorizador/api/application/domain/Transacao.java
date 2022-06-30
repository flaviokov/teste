package br.com.miniautorizador.api.application.domain;

import java.math.BigDecimal;

public class Transacao {

    private final Cartao cartao;
    private final BigDecimal valor;
    private final String senha;

    private Transacao(Processa processa) {
        this.cartao = processa.cartao;
        this.valor = processa.valor;
        this.senha = processa.senha;
    }

    public static class Processa {

        private Cartao cartao;
        private BigDecimal valor;
        private String senha;

        public Processa(Cartao cartao) {
            this.cartao = cartao;
        }

        public Processa verificaSenha(String senha) {
            this.cartao.senhaEhValida(senha);
            this.senha = senha;
            return this;
        }

        public Processa verificaSaldo(BigDecimal valor) {
            this.cartao.temSaldoDisponivel(valor);
            this.valor = valor;
            return this;
        }

        public Transacao aplicaValor() {
            this.cartao.aplicaValor(this.valor);
            return new Transacao(this);
        }

    }

    public Cartao getCartao() {
        return cartao;
    }
}
