package pre_supplier.supplier.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pre_supplier.supplier.preFornecedor.*;
import pre_supplier.supplier.preFornecedor.dto.DadosCadastroPreFornecedor;

import java.util.List;

@RestController
@RequestMapping("prefornecedores")
public class PreFornecedorController {

    @Autowired
    private PreFornecedorRepository repository;

//    @PostMapping
//    @Transactional
//    public void cadastrar(@RequestBody @Valid DadosCadastroPreFornecedor dados) {
//        repository.save(new PreFornecedor(dados));
//    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPreFornecedor dados, UriComponentsBuilder uriBuilder) {
        //é necessário retornar os codigos  201 (Created), para devolver o corpo, cabeçalho e o link do endereço.
        var preFornecedor = new PreFornecedor(dados);
        repository.save(preFornecedor);

        var uri = uriBuilder.path("/prefornecedores/{id}").buildAndExpand(preFornecedor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPreFornecedor(preFornecedor));
    }

    @GetMapping
    @RequestMapping("/mainlist")
    //public Page<DadosListagemPreFornecedor> listar(Pageable paginacao) {
    public ResponseEntity <Page<DadosListagemPreFornecedor>> listar(@PageableDefault(size = 50, sort = {"nomefornecedor"}) Pageable paginacao) {
        //ou se tivesse um campo do tipo boolean ativo seria = var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        //para ver todos seria = var page = repository.findAll(paginacao).map(DadosListagemPreFornecedor::new);
        var page = repository.fornecedorAtivo(paginacao).map(DadosListagemPreFornecedor::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping
    @RequestMapping("/listartodos")
    public List<PreFornecedor> listarTodos() {
        return repository.findAll();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPreFornecedor dados) {
        //System.out.println("* * * * * dados: " + dados);
        var preFornecedor = repository.getReferenceById(dados.id());
        preFornecedor.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoPreFornecedor(preFornecedor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    //public void deletar(@PathVariable Long id) {
    //ResponseEntity = devolve uma resposta para o cliente da API.
    public ResponseEntity deletar(@PathVariable Long id) {
        System.out.println("*** ID PARA DELETAR: " + id);
        //Esse comand faz a exclusão fisica do registro no DB.
        //repository.deleteById(id);

        var preFornecedor = repository.getReferenceById(id);
        preFornecedor.excluirPreForncedor();
        return ResponseEntity.noContent().build(); //devolve 204 indicando que foi ok e que não tem conteúdo paa retornar.
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var preFornecedor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPreFornecedor(preFornecedor));
    }
}
