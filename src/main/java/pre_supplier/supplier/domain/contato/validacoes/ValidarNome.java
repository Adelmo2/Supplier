package pre_supplier.supplier.domain.contato.validacoes;

import org.springframework.stereotype.Component;
import pre_supplier.supplier.domain.contato.DadosCadastroContato;
import pre_supplier.supplier.domain.validacaoException;

@Component
public class ValidarNome implements ValidadorCadastroDeContatos  {
    public void validar(DadosCadastroContato dados) {
        var nomeContato = dados.nome();
        if (nomeContato.length() <= 10) {
            throw new validacaoException("Nome Inválido! O tamanho não pode ser inferior a 10 caracteres");
        }

        if (!nomeContato.contains(" ") ) {
            throw new validacaoException("Nome Inválido! Falta o sobrenome.");
        }
    }
}
