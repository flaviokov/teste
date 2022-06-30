package br.com.miniautorizador.api.adpaters.in.api;

import br.com.miniautorizador.api.adpaters.in.api.model.request.TransacaoRequest;
import br.com.miniautorizador.api.adpaters.in.api.model.response.Data;
import br.com.miniautorizador.api.adpaters.in.api.model.response.TransacaoResponse;
import br.com.miniautorizador.api.application.ports.in.ProcessaTransacaoPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/transacoes")
@Validated
public class TransacaoController {

    private ProcessaTransacaoPort processaTransacaoPort;

    public TransacaoController(ProcessaTransacaoPort processaTransacaoPort) {
        this.processaTransacaoPort = processaTransacaoPort;
    }

    @PostMapping
    public ResponseEntity<Data<TransacaoResponse>> validaTransacao(@RequestBody @Valid TransacaoRequest request) {

        TransacaoResponse transacaoResponse = this.processaTransacaoPort.processa(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(new Data(transacaoResponse));
    }



}
