package pre_supplier.supplier.domain.contato;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroContato(

    @NotNull
    Long idPreFornecedor,

    @NotNull
    String nome,

    String departamento,
    String cargo,
    String telefone,
    String email,
    String observacao
) {
}
