package pre_supplier.supplier.domain.preFornecedor;

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
    //ou se tivesse um campo do tipo boolean ativo seria =  Page<PreFornecedor> findAllByAtivoTrue(Pageable paginacao);
}
