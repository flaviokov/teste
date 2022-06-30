package br.com.miniautorizador.api.adpaters.out.repository.mysql;

import br.com.miniautorizador.api.adpaters.out.repository.mysql.entity.CartaoEntity;
import br.com.miniautorizador.api.adpaters.out.repository.mysql.exception.CartaoExistenteException;
import br.com.miniautorizador.api.adpaters.out.repository.mysql.exception.CartaoNaoEncontradoException;
import br.com.miniautorizador.api.adpaters.out.repository.mysql.mapper.CartaoEntityMapper;
import br.com.miniautorizador.api.application.domain.Cartao;
import br.com.miniautorizador.api.application.ports.out.CartoesQueryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
 class CartoesQueryAdapter implements CartoesQueryPort {

    private CartaoRepository repository;

    public CartoesQueryAdapter(CartaoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cartao> buscaTodos() {
        return this.repository.findAll().stream().map(entity ->  CartaoEntityMapper.toCartao(entity)).collect(Collectors.toList());
    }

    @Override
    public Cartao buscaCartao(String numero,String senha) {
        var entity = this.repository.findCartaoEntityByNumero(numero).orElseThrow(() -> new CartaoExistenteException(new CartaoEntity(numero,senha)));

        return CartaoEntityMapper.toCartao(entity);
    }

    @Override
    public Cartao buscaSaldo(String numeroDoCartao) {
        try {

            var cartaoEntity = this.repository.findCartaoEntityByNumero(numeroDoCartao);

            CartaoEntity entity = cartaoEntity.orElseThrow(() -> new CartaoNaoEncontradoException("Cartao não encontrado!"));
            return CartaoEntityMapper.toCartao(entity);
        }catch (Exception e) {
            throw new CartaoNaoEncontradoException(e.getMessage());
        }
    }
}
