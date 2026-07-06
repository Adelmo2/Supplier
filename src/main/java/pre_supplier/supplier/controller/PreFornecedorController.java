package pre_supplier.supplier.controller;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pre_supplier.supplier.preFornecedor.PreFornecedor;
import pre_supplier.supplier.preFornecedor.PreFornecedorRepository;
import pre_supplier.supplier.preFornecedor.dto.DadosCadastroPreFornecedor;

@RestController
@RequestMapping("pre-fornecedores")
public class PreFornecedorController {

    @Autowired
    private PreFornecedorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroPreFornecedor dados) {
        //System.out.println("Dados " + dados);
        //System.out.println("Cidade: " + dados.endereco().cidade());
        repository.save(new PreFornecedor(dados));
    }
}
