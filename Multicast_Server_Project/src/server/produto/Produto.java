package server.produto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String loja;
    private String nome;
    private BigDecimal valor;

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto [loja=" + loja + ", nome=" + nome + ", valor=" + valor + "]";
    }

}
