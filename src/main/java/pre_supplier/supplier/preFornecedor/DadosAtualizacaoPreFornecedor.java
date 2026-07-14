package pre_supplier.supplier.preFornecedor;

import jakarta.validation.constraints.NotNull;
import pre_supplier.supplier.endereco.DadosEndereco;

public record DadosAtualizacaoPreFornecedor(
        @NotNull
        Long id,

        String nomefornecedor,
        String telefone,
        DadosEndereco endereco
) {
}
