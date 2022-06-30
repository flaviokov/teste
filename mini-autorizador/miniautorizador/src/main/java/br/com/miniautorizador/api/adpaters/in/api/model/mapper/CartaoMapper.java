package br.com.miniautorizador.api.adpaters.in.api.model.mapper;

import br.com.miniautorizador.api.adpaters.in.api.model.response.CartaoResponse;
import br.com.miniautorizador.api.application.domain.Cartao;


public class CartaoMapper {

   public static CartaoResponse toCartaoResponse(Cartao cartao){
       return new CartaoResponse(cartao.getNumero(), cartao.getSenha(),cartao.getSaldo());
   }
}
