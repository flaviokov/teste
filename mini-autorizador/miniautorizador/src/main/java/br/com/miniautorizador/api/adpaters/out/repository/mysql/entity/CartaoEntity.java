package br.com.miniautorizador.api.adpaters.out.repository.mysql.entity;

import br.com.miniautorizador.api.application.domain.Cartao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String numero;
    private BigDecimal saldo;
    private String senha;

    public CartaoEntity() {
    }

    public CartaoEntity(String numero, String senha) {
        this.numero = numero;
        this.senha = senha;
    }

    public CartaoEntity(Cartao cartao) {
        setNumero(cartao.getNumero());
        setSaldo(cartao.getSaldo());
        setSenha(cartao.getSenha());
        setId(cartao.getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartaoEntity entity = (CartaoEntity) o;
        return id.equals(entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
