package pre_supplier.supplier.domain.contato;

import org.hibernate.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pre_supplier.supplier.domain.preFornecedor.PreFornecedorRepository;
import pre_supplier.supplier.domain.validacaoException;

@Service
public class CadastroDeContatos {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PreFornecedorRepository preFornecedorRepository;

    public void cadastrar(DadosCadastroContato dados) {
        if (!preFornecedorRepository.existsById(dados.idPreFornecedor())) {
            throw new validacaoException("Id do Pre Fornecedor não existe!..");
        }

        var telefone = dados.telefone();
        if  (telefone == null) {
            throw new validacaoException("O Telefone não pode ser nulo!...");
        }

        if  (telefone == "") {
            throw new validacaoException("O Telefone é obrigatório!...");
        }

        if  (telefone.length() < 11) {
            throw new validacaoException("O Telefone inválido. Precisa no minimo 10 dígitos...");
        }

        var prefornecedor = preFornecedorRepository.findById(dados.idPreFornecedor()).get() ;
        var contato = new Contato(null,  prefornecedor, dados.nome(), dados.departamento(), dados.cargo(), dados.telefone(), dados.email(), dados.observacao() );
        contatoRepository.save(contato);
    }
}
