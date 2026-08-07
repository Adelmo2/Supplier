package pre_supplier.supplier.domain.contato.validacoes;

import org.springframework.stereotype.Component;
import pre_supplier.supplier.domain.contato.DadosCadastroContato;
import pre_supplier.supplier.domain.validacaoException;

@Component
public class ValidarEmail implements ValidadorCadastroDeContatos {
    public void validar(DadosCadastroContato dados) {
        var email = dados.email();

        if (email == null) {
            return;
        }

        if (email.length() <= 15) {
            throw new validacaoException("E-mail Inválido! O tamanho não pode ser inferior a 15 caracteres");
        }

        if (!email.contains("@") ) {
            throw new validacaoException("Email inválido.");
        }
    }
}
