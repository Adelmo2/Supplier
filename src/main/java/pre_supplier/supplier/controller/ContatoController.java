package pre_supplier.supplier.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pre_supplier.supplier.domain.contato.CadastroDeContatos;
import pre_supplier.supplier.domain.contato.DadosCadastroContato;

@RestController
@RequestMapping("contatos")
public class ContatoController {

    @Autowired
    private CadastroDeContatos cadastroDeContatos;

    //@Autowired
    //private Contato contato;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarr(@RequestBody @Valid DadosCadastroContato dados) {
        //contatos.cadastrar(dados);
        //var idPrefornecedor = dados.idPreFornecedor();
        var dto = cadastroDeContatos.cadastrar(dados);
        return ResponseEntity.ok(dto);
        //return ResponseEntity.ok(new DadosDetalhamentoContato(contato.getId(), idPrefornecedor , contato.getDepartamento(), contato.getCargo(), contato.getTelefone(), contato.getEmail(), contato.getObservacao()));

    }

}
