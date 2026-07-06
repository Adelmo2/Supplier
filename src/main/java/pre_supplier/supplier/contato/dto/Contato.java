package pre_supplier.supplier.contato.dto;

public record Contato(
        String nome,
        String departamento,
        String cargo,
        String telefone,
        String email,
        String observacao
) {
}
