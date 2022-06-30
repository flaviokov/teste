package br.com.miniautorizador.api.adpaters.in.api;

import br.com.miniautorizador.api.adpaters.in.api.model.request.AutorizadorCartaoRequest;
import br.com.miniautorizador.api.adpaters.in.api.model.response.CartaoResponse;
import br.com.miniautorizador.api.adpaters.in.api.model.response.Data;
import br.com.miniautorizador.api.adpaters.in.api.model.response.ListaCartoesResponse;
import br.com.miniautorizador.api.adpaters.in.api.model.response.SaldoResponse;
import br.com.miniautorizador.api.application.ports.in.BuscaSaldoCartaoPort;
import br.com.miniautorizador.api.application.ports.in.CriaCartaoPort;
import br.com.miniautorizador.api.application.ports.in.ListaCartoesPort;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/api/v1/cartoes")
@Validated
public class CartaoController {

    private final CriaCartaoPort criaCartaoPort;

    private final ListaCartoesPort listaCartoesPort;

    private final BuscaSaldoCartaoPort buscaSaldoCartaoPort;

    public CartaoController(CriaCartaoPort criaCartaoPort, ListaCartoesPort listaCartoesPort, BuscaSaldoCartaoPort buscaSaldoCartaoPort) {
        this.criaCartaoPort = criaCartaoPort;
        this.listaCartoesPort = listaCartoesPort;
        this.buscaSaldoCartaoPort = buscaSaldoCartaoPort;
    }

    @PostMapping
    public ResponseEntity<Data<CartaoResponse>> criaCartao(@RequestBody @Valid AutorizadorCartaoRequest request) {
        var response = this.criaCartaoPort.from(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Data(response));
    }

    @GetMapping
    public ResponseEntity<Data<ListaCartoesResponse>> lista(){
        return ResponseEntity.ok(new Data(this.listaCartoesPort.buscaTodosOsCartoes()));
    }

    @GetMapping("{numero}/saldo")
    public ResponseEntity<Data<SaldoResponse>> buscaSaldoDoCartao(@PathVariable @Valid @NotBlank String numero){
        return ResponseEntity.ok(new Data(this.buscaSaldoCartaoPort.buscaSaldoDoCartao(numero)));
    }


}
