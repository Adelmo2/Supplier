package pre_supplier.supplier.controller;

import org.springframework.web.bind.annotation.*;
import pre_supplier.supplier.domain.uf.DadosUf;

@RestController
@RequestMapping("uf")
public class UfController {

    @PostMapping
    public void Cadastrar(@RequestBody DadosUf dados) {
        System.out.println("Dados da UF: " + dados);

    }

}
