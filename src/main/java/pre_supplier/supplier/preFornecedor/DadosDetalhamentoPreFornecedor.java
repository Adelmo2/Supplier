package pre_supplier.supplier.preFornecedor;
import pre_supplier.supplier.endereco.Endereco;

public record DadosDetalhamentoPreFornecedor(
        Long id,
        String nomefornecedor,
        String nome_fantasia,
        String nome_compras,
        ClasseJuridico classeJuridico,
        String cnpj_cpf,
        String num_inscr_estad,
        String num_inscr_munip,
        String id_estrangeiro,
        Endereco endereco,
        String email,
        String email_nfe,
        String telefone,
        String desc_atividade,
        String stat_cancel
)
{
    public DadosDetalhamentoPreFornecedor(PreFornecedor preFornecedor) {
        this(preFornecedor.getId(),
                preFornecedor.getNomefornecedor(),
                preFornecedor.getNome_fantasia(),
                preFornecedor.getNome_compras(),
                preFornecedor.getClasse_juridico(),
                preFornecedor.getCnpj_cpf(),
                preFornecedor.getNum_inscr_estad(),
                preFornecedor.getNum_inscr_munip(),
                preFornecedor.getId_estrangeiro(),
                preFornecedor.getEndereco(),
                preFornecedor.getEmail(),
                preFornecedor.getEmail_nfe(),
                preFornecedor.getTelefone(),
                preFornecedor.getDesc_atividade(),
                preFornecedor.getStat_cancel()
        );
    }
}
