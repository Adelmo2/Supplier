package pre_supplier.supplier.preFornecedor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pre_supplier.supplier.contato.dto.Contato;
import pre_supplier.supplier.endereco.DadosEndereco;
import pre_supplier.supplier.preFornecedor.ClasseJuridico;

public record DadosCadastroPreFornecedor(

        @NotBlank
        String nome_fornecedor,

        @NotBlank
        String nome_fantasia,

        String nome_compras,

        @NotNull
        ClasseJuridico classe_juridico,

        String cnpj_cpf,
        String num_inscr_estad,
        String num_inscr_munip,
        String id_estrangeiro,

        @NotNull @Valid DadosEndereco endereco,

        @NotBlank
        @Email
        String email,

        String email_nfe,
        String telefone,
        String desc_atividade
) {

}
