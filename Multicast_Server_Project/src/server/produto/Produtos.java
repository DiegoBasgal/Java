package server.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Produtos {

    private static Produtos produtos;

    public static Produtos instance() {
        if (produtos == null) {
            produtos = new ProdutosFactory().criarProdutos();
        }
        return produtos;
    }

    private List<Produto> listProdutos = new ArrayList<Produto>();

    public void add(Produto produto) {
        this.listProdutos.add(produto);
    }

    public List<Produto> getProdutosContemName(String nome, String loja) {
        String nomeUpperCase = nome.toUpperCase();
        return this.listProdutos.stream().filter(p -> p.getNome().toUpperCase().contains(nomeUpperCase)
                && p.getLoja().equalsIgnoreCase(loja))
                .collect(Collectors.toList());
    }

}
