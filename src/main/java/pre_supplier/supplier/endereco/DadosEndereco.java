package pre_supplier.supplier.endereco;

public record DadosEndereco(
        String cod_logradouro,
        String end_rua,
        String end_numero,
        String end_compl,
        String num_cep,
        String end_bairro,
        String end_cidade,
        String sigl_estado,
        String cod_cidade
) {
}


