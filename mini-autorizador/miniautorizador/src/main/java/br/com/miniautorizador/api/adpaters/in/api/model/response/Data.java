package br.com.miniautorizador.api.adpaters.in.api.model.response;

import br.com.miniautorizador.api.handler.ErrrorResponse;

public class Data<T> {

    T data;
    ErrrorResponse error;

    public Data(ErrrorResponse error) {
        this.error = error;
    }

    public Data(T data) {
        this.data = data;
    }

    public ErrrorResponse getError() {
        return error;
    }

    public T getData() {
        return data;
    }
}
