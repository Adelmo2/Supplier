package pre_supplier.supplier.domain.preFornecedor;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PreFornecedorRepository extends JpaRepository<PreFornecedor, Long> {
    @Query("""
            select p from PreFornecedor p
            where
            p.stat_cancel = ' '
            or p.stat_cancel is null
            """)
    Page<PreFornecedor> fornecedorAtivo(Pageable paginacao);

    @Query("""
            select max(p.nomefornecedor)
            from PreFornecedor p
            where
            p.nomefornecedor = :nomePreFornecedor
            """)
    String  fornecedorDuplicado(String nomePreFornecedor);
}
