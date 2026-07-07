package pre_supplier.supplier.preFornecedor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pre_supplier.supplier.endereco.Endereco;
import pre_supplier.supplier.preFornecedor.dto.DadosCadastroPreFornecedor;

@Table(name = "dat436")
@Entity(name = "PreFornecedor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PreFornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dat436")
    private Long id;
    private String nome_fornecedor;
    private String nome_fantasia;
    private String nome_compras;

    @Enumerated(EnumType.STRING)
    private ClasseJuridico classe_juridico;

    private String cnpj_cpf;
    private String num_inscr_estad;
    private String num_inscr_munip;
    private String id_estrangeiro;

    @Embedded
    private Endereco endereco;

    private String email;
    private String email_nfe;
    private String telefone;
    private String desc_atividade;

    public PreFornecedor(DadosCadastroPreFornecedor dados) {
        this.nome_fornecedor = dados.nome_fornecedor();
        this.nome_fantasia = dados.nome_fantasia();
        this.nome_compras = dados.nome_compras();
        this.classe_juridico = dados.classe_juridico();
        this.cnpj_cpf = dados.cnpj_cpf();
        this.num_inscr_estad = dados.num_inscr_estad();
        this.num_inscr_munip = dados.num_inscr_munip();
        this.id_estrangeiro = dados.id_estrangeiro();
        this.endereco = new Endereco(dados.endereco());
        this.email = dados.email();
        this.email_nfe = dados.email_nfe();
        this.telefone = dados.telefone();
        this.desc_atividade = dados.desc_atividade();
    }
}
