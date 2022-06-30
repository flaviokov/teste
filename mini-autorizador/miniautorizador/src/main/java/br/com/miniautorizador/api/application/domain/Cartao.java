package br.com.miniautorizador.api.application.domain;

import br.com.miniautorizador.api.application.domain.enums.StatusTransacao;
import br.com.miniautorizador.api.application.domain.exception.SaldoInsuficienteException;
import br.com.miniautorizador.api.application.domain.exception.SenhaCartaoInvalidaException;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class Cartao {

    private Long id;
    private String numero;
    private AtomicReference<BigDecimal> saldo;
    private String senha;

    public Cartao(String numero, String senha) {
        this.numero = numero;
        this.saldo = new AtomicReference<>(comSaldo());
        this.senha = senha;
    }

    public Cartao(String numero, String senha,BigDecimal saldo) {
        this.numero = numero;
        this.saldo = new AtomicReference<>(saldo);
        this.senha = senha;
    }

    public Cartao(String numero, String senha,BigDecimal saldo,Long id) {
        this.numero = numero;
        this.saldo = new AtomicReference<>(saldo);
        this.senha = senha;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo.get();
    }

    public String getSenha() {
        return senha;
    }

    private static BigDecimal comSaldo() {
        return new BigDecimal(500);
    }

    public void aplicaValor(BigDecimal valor) {
        var novoSaldo = getSaldo().subtract(valor);
        this.saldo.getAndSet( novoSaldo);
    }

    public boolean senhaEhValida(String senha) {
        if(Objects.nonNull(getSenha()) && getSenha().equals(senha)){
            return Boolean.TRUE;
        }
        throw new SenhaCartaoInvalidaException(StatusTransacao.SENHA_INVALIDA.name());
    }

    public boolean temSaldoDisponivel(BigDecimal valor) {
        if (Objects.nonNull(getSaldo()) && getSaldo().floatValue() >= valor.floatValue()){
            return Boolean.TRUE;
        }
        throw new SaldoInsuficienteException(StatusTransacao.SALDO_INSUFICIENTE.name());
    }

}
