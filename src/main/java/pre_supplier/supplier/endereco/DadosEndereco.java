package pre_supplier.supplier.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String cod_logradouro,

        @NotBlank
        String end_rua,

        String end_numero,

        String end_compl,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String num_cep,

        @NotBlank
        String end_bairro,

        @NotBlank
        String end_cidade,

        @NotBlank
        String sigl_estado,

        @NotBlank
        String cod_cidade
) {
}


