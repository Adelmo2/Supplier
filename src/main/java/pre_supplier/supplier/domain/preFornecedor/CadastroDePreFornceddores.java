package pre_supplier.supplier.domain.preFornecedor;

import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pre_supplier.supplier.domain.contato.DadosDetalhamentoContato;
import pre_supplier.supplier.domain.preFornecedor.dto.DadosCadastroPreFornecedor;
import pre_supplier.supplier.domain.validacaoException;

@Service
public class CadastroDePreFornceddores {

    @Autowired
    private PreFornecedorRepository preFornecedorRepository;

    public DadosDetalhamentoPreFornecedor cadastrar(DadosCadastroPreFornecedor dados) {
        if (dados.cnpj_cpf() == null || dados.cnpj_cpf() == "") {
            if (dados.id_estrangeiro() == null || dados.id_estrangeiro() == "") {
                throw new validacaoException("O Id Estrangeiro precisa ser preenchido se não tiver o CNPJ!");
            }
        }

        var temFornecedor = preFornecedorRepository.fornecedorDuplicado(dados.nome_fornecedor());
        if (temFornecedor != null) {
            throw new validacaoException("Pré Fornecedor já cadastrado!");
        }

        var preFornecedor = new PreFornecedor(dados);
        preFornecedorRepository.save(preFornecedor);

        return new DadosDetalhamentoPreFornecedor(preFornecedor);

    }

}
