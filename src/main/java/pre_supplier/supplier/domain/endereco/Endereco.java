package pre_supplier.supplier.domain.endereco;

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

    public void atualizarInformacoes(DadosEndereco dados) {
        if (dados.cod_logradouro() != null) {
            this.cod_logradouro = dados.cod_logradouro();
        }
        if (dados.end_rua() != null) {
            this.end_rua = dados.end_rua();
        }
        if (dados.end_numero() != null) {
            this.end_numero = dados.end_numero();
        }
        if (dados.end_compl() != null) {
            this.end_compl = dados.end_compl();
        }
        if (dados.num_cep() != null) {
            this.num_cep = dados.num_cep();
        }
        if (dados.end_bairro() != null) {
            this.end_bairro = dados.end_bairro();
        }
        if (dados.end_cidade() != null) {
            this.end_cidade = dados.end_cidade();
        }
        if (dados.sigl_estado() != null) {
            this.sigl_estado = dados.sigl_estado();
        }
    }
}
