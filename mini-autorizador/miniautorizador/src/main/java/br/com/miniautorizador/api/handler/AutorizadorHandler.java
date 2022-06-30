package br.com.miniautorizador.api.handler;

import br.com.miniautorizador.api.adpaters.in.api.model.response.CartaoResponse;
import br.com.miniautorizador.api.adpaters.in.api.model.response.Data;
import br.com.miniautorizador.api.adpaters.out.repository.mysql.exception.CartaoExistenteException;
import br.com.miniautorizador.api.adpaters.out.repository.mysql.exception.CartaoNaoEncontradoException;
import br.com.miniautorizador.api.application.domain.exception.TransacaoInconsistenteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;


@RestControllerAdvice
public class AutorizadorHandler  extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutorizadorHandler.class.getName());

    @ExceptionHandler(CartaoNaoEncontradoException.class)
    public ResponseEntity<Data<CartaoResponse>> handleCartaoNaoEncontradoException( CartaoNaoEncontradoException ex, WebRequest request) {

        var response = new Data<CartaoResponse>(new ErrrorResponse(ex.getMessage()));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Data<CartaoResponse>> handleConstraintViolationException( ConstraintViolationException ex, WebRequest request) {

        var response = new Data<CartaoResponse>(new ErrrorResponse(ex.getMessage()));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TransacaoInconsistenteException.class)
    public ResponseEntity<Data<CartaoResponse>> handleSaldoIndisponivelException( TransacaoInconsistenteException ex, WebRequest request) {

        LOGGER.info(ex.getMessage());
        var response = new Data<CartaoResponse>(new ErrrorResponse(ex.getMessage()));

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(CartaoExistenteException.class)
    public ResponseEntity<Data<CartaoResponse>> handleCartaoExistenteException( CartaoExistenteException ex, WebRequest request) {

        LOGGER.info(ex.getMessage());
        var response = new Data<>(new CartaoResponse(ex.getCartao().getNumero(), ex.getCartao().getSenha()));

        return new ResponseEntity<>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }


}
