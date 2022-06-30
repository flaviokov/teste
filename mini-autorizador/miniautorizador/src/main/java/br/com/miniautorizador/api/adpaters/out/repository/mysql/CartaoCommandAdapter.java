package br.com.miniautorizador.api.adpaters.out.repository.mysql;

import br.com.miniautorizador.api.adpaters.out.repository.mysql.entity.CartaoEntity;
import br.com.miniautorizador.api.adpaters.out.repository.mysql.exception.CartaoExistenteException;
import br.com.miniautorizador.api.application.domain.Cartao;
import br.com.miniautorizador.api.application.ports.out.CartaoCommandPort;
import br.com.miniautorizador.api.application.ports.out.CriaCartaoCommand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
 class CartaoCommandAdapter implements CartaoCommandPort {

    private CartaoRepository repository;

    public CartaoCommandAdapter(CartaoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public CriaCartaoCommand salva(CriaCartaoCommand command) {
        var entity = new CartaoEntity(command.getCartao());
        try {
            if(this.repository.existsCartaoEntityByNumero(entity.getNumero())){
                throw new CartaoExistenteException(entity);
            }

            CartaoEntity cartaoEntity = this.repository.save(entity);
           return CriaCartaoCommand.comCartao(cartaoEntity.getNumero(), cartaoEntity.getSenha(), cartaoEntity.getSaldo());
       }catch (CartaoExistenteException e) {
           throw e;
       }
       catch (Exception e) {
           throw e;
       }
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public void atualizaSaldo(Cartao cartao) {
        try {
            this.repository.save(new CartaoEntity(cartao));
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
