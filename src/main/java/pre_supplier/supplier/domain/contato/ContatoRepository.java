package pre_supplier.supplier.domain.contato;

import org.apache.el.lang.ELArithmetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

    @Query("""
            select max(c.nome)
            from Contato c
            where
            c.preFornecedor.id = :id
            and
            c.nome = :NomeContato
            """)
     String contatoDuplicado(Long id, String NomeContato);
}
