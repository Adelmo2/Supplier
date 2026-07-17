package pre_supplier.supplier.domain.preFornecedor;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import pre_supplier.supplier.domain.endereco.Endereco;
import pre_supplier.supplier.domain.preFornecedor.dto.DadosCadastroPreFornecedor;

import java.time.LocalDate;

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

    @Column(name = "nome_fornecedor")
    private String nomefornecedor;
    private String nome_fantasia;
    private String nome_compras;

    @Enumerated(EnumType.STRING)
    private ClasseJuridico classe_juridico;

    //@JsonIgnore
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
    private String stat_cancel;
    private LocalDate data_cancel;

    public PreFornecedor(DadosCadastroPreFornecedor dados) {
        this.nomefornecedor = dados.nome_fornecedor();
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

    public void atualizarInformacoes(@Valid DadosAtualizacaoPreFornecedor dados) {
        if (dados.nomefornecedor() != null) {
            this.nomefornecedor = dados.nomefornecedor();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void excluirPreForncedor() {
        this.stat_cancel = "C";
        this.data_cancel =  LocalDate.now();
    }
}
