package br.com.miniautorizador.api.adpaters.out.repository.mysql;

import br.com.miniautorizador.api.adpaters.out.repository.mysql.entity.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

interface CartaoRepository extends JpaRepository<CartaoEntity,Long> {

    @Query("SELECT c FROM CartaoEntity c WHERE c.numero = :numero")
    Optional<CartaoEntity> findCartaoEntityByNumero(@Param(value = "numero") String numero);

    boolean existsCartaoEntityByNumero(@Param(value = "numero") String numero);
}
