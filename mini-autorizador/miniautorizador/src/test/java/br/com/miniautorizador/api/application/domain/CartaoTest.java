package br.com.miniautorizador.api.application.domain;

import br.com.miniautorizador.api.application.domain.enums.StatusTransacao;
import br.com.miniautorizador.api.application.domain.exception.SaldoInsuficienteException;
import br.com.miniautorizador.api.application.domain.exception.SenhaCartaoInvalidaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CartaoTest {

    @Test
    @DisplayName("Deve validar a senha com sucesso")
    public void teste0() {

        //Dado
        var cartao = new Cartao("6549873025634501", "1010");

        //Quando
        var ehValida = cartao.senhaEhValida("1010");

        //Entao
        Assertions.assertTrue(ehValida);
    }

    @Test
    @DisplayName("Deve retorna senha invalida")
    public void teste1() {

        var cartao = new Cartao("6549873025634501", "5454");

        SenhaCartaoInvalidaException senhaCartaoInvalidaException = Assertions.assertThrows(SenhaCartaoInvalidaException.class, () -> cartao.senhaEhValida("112"));
        Assertions.assertEquals(StatusTransacao.SENHA_INVALIDA.name(),senhaCartaoInvalidaException.getMessage());
    }

    @Test
    @DisplayName("Deve retorna senha invalida quando a ela for nulo")
    public void teste2() {

        var cartao = new Cartao("6549873025634501", "9898");

        SenhaCartaoInvalidaException senhaCartaoInvalidaException = Assertions.assertThrows(SenhaCartaoInvalidaException.class, () -> cartao.senhaEhValida(null));
        Assertions.assertEquals(StatusTransacao.SENHA_INVALIDA.name(),senhaCartaoInvalidaException.getMessage());
    }

    @Test
    @DisplayName("Deve retorna senha invalida quando a ela for vazia")
    public void teste3() {

        var cartao = new Cartao("6549873025634501", "1000");

        SenhaCartaoInvalidaException senhaCartaoInvalidaException = Assertions.assertThrows(SenhaCartaoInvalidaException.class, () -> cartao.senhaEhValida(""));
        Assertions.assertEquals(StatusTransacao.SENHA_INVALIDA.name(),senhaCartaoInvalidaException.getMessage());
    }

    @Test
    @DisplayName("Deve validar o saldo com sucesso com valor menor que saldo")
    public void teste4() {

        //Dado
        var cartao = new Cartao("6549873025634501", "1122");

        //Quando
        var valorCompra = BigDecimal.valueOf(150);
        var temSaldoDisponivel = cartao.temSaldoDisponivel(valorCompra);

        //Entao
        Assertions.assertTrue(temSaldoDisponivel);
    }

    @Test
    @DisplayName("Deve validar o saldo com sucesso com valor igual a saldo")
    public void teste5() {

        //Dado
        var cartao = new Cartao("6549873025634501", "3322");

        //Quando
        var valorCompra = BigDecimal.valueOf(500);
        var temSaldoDisponivel = cartao.temSaldoDisponivel(valorCompra);

        //Entao
        Assertions.assertTrue(temSaldoDisponivel);
    }

    @Test
    @DisplayName("Deve validar o saldo com valor menor que saldo e retorna saldo insuficiente")
    public void teste6() {

        //Dado
        var cartao = new Cartao("6549873025634501", "6565");

        var valorCompra = BigDecimal.valueOf(700);

        SaldoInsuficienteException senhaCartaoInvalidaException = Assertions.assertThrows(SaldoInsuficienteException.class, () -> cartao.temSaldoDisponivel(valorCompra));
        Assertions.assertEquals(StatusTransacao.SALDO_INSUFICIENTE.name(),senhaCartaoInvalidaException.getMessage());
    }
}