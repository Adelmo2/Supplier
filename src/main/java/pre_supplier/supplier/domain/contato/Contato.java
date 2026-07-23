package pre_supplier.supplier.domain.contato;

public record Contato(
        String nome,
        String departamento,
        String cargo,
        String telefone,
        String email,
        String observacao
) {
}
