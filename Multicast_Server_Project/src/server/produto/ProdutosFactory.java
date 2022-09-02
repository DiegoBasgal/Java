package server.produto;

import java.math.BigDecimal;

public class ProdutosFactory {

    public Produtos criarProdutos() {
        Produtos produtos = new Produtos();

        Produto p = new Produto();
        p.setLoja("Loja A");
        p.setNome("Tomate");
        p.setValor(new BigDecimal(15.50));
        produtos.add(p);

        p = new Produto();
        p.setLoja("Loja A");
        p.setNome("Alface");
        p.setValor(new BigDecimal(15.50));
        produtos.add(p);

        p = new Produto();
        p.setLoja("Loja A");
        p.setNome("Espinafre");
        p.setValor(new BigDecimal(15.50));
        produtos.add(p);

        p = new Produto();
        p.setLoja("Loja B");
        p.setNome("Tomate");
        p.setValor(new BigDecimal(15.50));
        produtos.add(p);

        p = new Produto();
        p.setLoja("Loja B");
        p.setNome("Alface");
        p.setValor(new BigDecimal(15.50));
        produtos.add(p);

        p = new Produto();
        p.setLoja("Loja B");
        p.setNome("Espinafre");
        p.setValor(new BigDecimal(15.50));
        produtos.add(p);

        p = new Produto();
        p.setLoja("Loja C");
        p.setNome("Tomate");
        p.setValor(new BigDecimal(15.50));
        produtos.add(p);

        p = new Produto();
        p.setLoja("Loja C");
        p.setNome("Alface");
        p.setValor(new BigDecimal(15.50));
        produtos.add(p);

        p = new Produto();
        p.setLoja("Loja C");
        p.setNome("Espinafre");
        p.setValor(new BigDecimal(15.50));
        produtos.add(p);
        return produtos;

    }

}
