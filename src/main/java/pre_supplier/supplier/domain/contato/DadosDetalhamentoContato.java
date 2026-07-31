package pre_supplier.supplier.domain.contato;

import jakarta.validation.constraints.NotNull;

public record DadosDetalhamentoContato(
    Long idContato,
    Long idPreFornecedor,
    String departamento,
    String cargo,
    String telefone,
    String email,
    String observacao
) {
}
