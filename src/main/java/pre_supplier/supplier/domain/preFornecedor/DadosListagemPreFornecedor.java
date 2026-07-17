package pre_supplier.supplier.domain.preFornecedor;

public record DadosListagemPreFornecedor(
        Long id,
        String nomefornecedor,
        ClasseJuridico classe_juridico,
        String cnpj_cpf,
        String telefone,
        String desc_atividade
) {
    public DadosListagemPreFornecedor(PreFornecedor preFornecedor) {
        this(preFornecedor.getId(),
                preFornecedor.getNomefornecedor(),
                preFornecedor.getClasse_juridico(),
                preFornecedor.getCnpj_cpf(),
                preFornecedor.getTelefone(),
                preFornecedor.getDesc_atividade()
        );
    }
}
