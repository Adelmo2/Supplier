package pre_supplier.supplier.domain.preFornecedor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pre_supplier.supplier.domain.endereco.DadosEndereco;
import pre_supplier.supplier.domain.preFornecedor.ClasseJuridico;

import java.util.Date;

public record DadosCadastroPreFornecedor(

        @NotBlank(message = "Nome é Obrigatório...")
        String nome_fornecedor,

        @NotBlank
        String nome_fantasia,

        String nome_compras,

        @NotNull(message = "O Campo Fisico/Juridico não pode ser diferente de F/j")
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
        String desc_atividade,
        String stat_cancel,
        Date data_cancel
) {

}
