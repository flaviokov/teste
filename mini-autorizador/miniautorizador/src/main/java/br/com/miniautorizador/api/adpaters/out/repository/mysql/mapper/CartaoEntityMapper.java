package br.com.miniautorizador.api.adpaters.out.repository.mysql.mapper;

import br.com.miniautorizador.api.adpaters.out.repository.mysql.entity.CartaoEntity;
import br.com.miniautorizador.api.application.domain.Cartao;


public class CartaoEntityMapper {

    public static Cartao toCartao(CartaoEntity entity) {
        return new Cartao(entity.getNumero(), entity.getSenha(),entity.getSaldo(), entity.getId());
    }

}
