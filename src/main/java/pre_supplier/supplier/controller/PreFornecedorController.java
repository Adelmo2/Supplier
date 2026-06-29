package pre_supplier.supplier.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pre_supplier.supplier.preFornecedor.DadosCadastroPreFornecedor;

@RestController
@RequestMapping("pre-fornecedores")
public class PreFornecedorController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroPreFornecedor dados) {
        System.out.println("Dados " + dados);

    }
}
