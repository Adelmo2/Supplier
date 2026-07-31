package pre_supplier.supplier.domain.contato;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import pre_supplier.supplier.domain.preFornecedor.PreFornecedor;

@Table(name = "dat437")
@Entity(name = "Contato")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recnum")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dat436")
    private PreFornecedor preFornecedor;

    String nome;
    String departamento;
    String cargo;
    String telefone;
    String email;
    String observacao;
}
