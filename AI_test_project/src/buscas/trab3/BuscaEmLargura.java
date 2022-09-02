package buscas.trab3;

import buscas.Busca;
import buscas.ResultadoBusca;
import puzzle.Puzzle;

import java.util.LinkedList;
import java.util.TreeSet;

public class BuscaEmLargura extends Busca {
    /**
     * Essa implementacao eh basicamente uma copia do pseudocodico dos slides do professor
     */
    @Override
    public ResultadoBusca buscar(Puzzle puzzle) {
        if(puzzle.estaResolvido()) return new ResultadoBusca(true);
        var fronteira = new LinkedList<Puzzle>();
        fronteira.add(puzzle);
        var explorados = new TreeSet<Puzzle>();
        while(!fronteira.isEmpty()) {
            var no = fronteira.pop();
            if(!explorados.add(no)) continue;
            var direcoesPossiveis = no.getMovimentosPossiveis();
            for(var dir : direcoesPossiveis) {
                var filho = no.criarFilho(dir);
                if(!explorados.contains(filho)) {
                    if(filho.estaResolvido()) return new ResultadoBusca(true, filho.getCaminhoPercorrido());
                    fronteira.add(filho);
                }
            }
        }
        return new ResultadoBusca(false);
    }

    @Override
    public String toString() {
        return "Busca em Largura";
    }
}
