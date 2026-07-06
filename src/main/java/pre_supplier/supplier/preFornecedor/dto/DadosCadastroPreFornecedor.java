package pre_supplier.supplier.preFornecedor.dto;

import pre_supplier.supplier.contato.dto.Contato;
import pre_supplier.supplier.endereco.DadosEndereco;
import pre_supplier.supplier.preFornecedor.ClasseJuridico;

public record DadosCadastroPreFornecedor(
        String nome_fornecedor,
        String nome_fantasia,
        String nome_compras,
        ClasseJuridico classe_juridico,
        String cnpj_cpf,
        String num_inscr_estad,
        String num_inscr_munip,
        String id_estrangeiro,
        DadosEndereco endereco,
        Contato contato
) {

}
