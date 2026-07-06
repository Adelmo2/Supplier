package pre_supplier.supplier.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String cod_logradouro;
    private String end_rua;
    private String end_numero;
    private String end_compl;
    private String num_cep;
    private String end_bairro;
    private String end_cidade;
    private String sigl_estado;
    private String cod_cidade;

    public Endereco(DadosEndereco dados) {
        this.cod_logradouro = dados.cod_logradouro();
        this.end_rua = dados.end_rua();
        this.end_numero = dados.end_numero();
        this.end_compl = dados.end_compl()  ;
        this.num_cep = dados.num_cep();
        this.end_bairro = dados.end_bairro();
        this.end_cidade = dados.end_cidade();
        this.sigl_estado = dados.sigl_estado();
        this.cod_cidade = dados.cod_cidade();
    }
}
