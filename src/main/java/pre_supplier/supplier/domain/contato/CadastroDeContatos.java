package pre_supplier.supplier.domain.contato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pre_supplier.supplier.domain.contato.validacoes.ValidadorCadastroDeContatos;
import pre_supplier.supplier.domain.preFornecedor.PreFornecedorRepository;
import pre_supplier.supplier.domain.validacaoException;

import java.util.List;

@Service
public class CadastroDeContatos {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PreFornecedorRepository preFornecedorRepository;

    @Autowired
    private List<ValidadorCadastroDeContatos> validadores;

    public DadosDetalhamentoContato cadastrar(DadosCadastroContato dados) {
        if (!preFornecedorRepository.existsById(dados.idPreFornecedor())) {
            throw new validacaoException("Id do Pre Fornecedor informado não existe!..");
        }

        var telefone = dados.telefone();
        if  (telefone == null) {
            throw new validacaoException("O Telefone não pode ser nulo!...");
        }

        if  (telefone.isEmpty()) {
            throw new validacaoException("O Telefone é obrigatório!...");
        }

        if  (telefone.length() < 11) {
            throw new validacaoException("O Telefone inválido. Precisa no mínimo 11 dígitos...");
        }

        validadores.forEach(v -> v.validar(dados));

        var temContato = contatoRepository.contatoDuplicado(dados.idPreFornecedor(), dados.nome()) ;
        System.out.println(" ####### temContato: " + temContato);
        if (temContato != null) {
            throw new validacaoException("Nome já cadastrado para o fornecedor: " + dados.idPreFornecedor());
        }

        var prefornecedor = preFornecedorRepository.findById(dados.idPreFornecedor()).get() ;
        var contato = new Contato(null, prefornecedor, dados.nome(), dados.departamento(), dados.cargo(), dados.telefone(), dados.email(), dados.observacao() );
        contatoRepository.save(contato);

        return new DadosDetalhamentoContato(contato) ;

    }
}
