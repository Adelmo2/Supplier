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
    public DadosDetalhamentoContato(Contato contato) {
        this(contato.getId(),
                contato.getPreFornecedor().getId(),
                contato.departamento,
                contato.getCargo(),
                contato.getTelefone(),
                contato.getEmail(),
                contato.observacao);
    }
}
