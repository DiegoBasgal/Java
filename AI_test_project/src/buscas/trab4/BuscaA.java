package buscas.trab4;

import buscas.Busca;
import buscas.ResultadoBusca;
import puzzle.Puzzle;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class BuscaA extends Busca {
    /**
     * Implementacao igual a busca gulosa, mas com a fronteira sendo ordenada
     * com base nas soma das distancia de manhattan de cada numero com aonde ele esta no estado objetivo
     * + o tamanho do caminho do nó atual
     */
    @Override
    public ResultadoBusca buscar(Puzzle puzzle) {
        if(puzzle.estaResolvido()) return new ResultadoBusca(true);
        var fronteira = new PriorityQueuePuzzleOrdenadoA();
        fronteira.add(puzzle);
        var explorados = new TreeSet<Puzzle>();
        while(!fronteira.isEmpty()) {
            var no = fronteira.poll();
            assert no != null;
            if(!explorados.add(no)) continue;
            var direcoesPossiveis = no.getMovimentosPossiveis();
            for(var dir : direcoesPossiveis) {
                var filho = no.criarFilho(dir);
                if(!explorados.contains(filho)) {
                    if (filho.estaResolvido()) return new ResultadoBusca(true, filho.getCaminhoPercorrido());
                    fronteira.add(filho);
                }
            }
        }
        return new ResultadoBusca(false);
    }
    private static int custo(Puzzle no) {
        return no.getDistanciaAoObjetivo() + no.getCustoCaminho();
    }
    private static class PriorityQueuePuzzleOrdenadoA extends PriorityQueue<Puzzle> {
        PriorityQueuePuzzleOrdenadoA() {
            super(Comparator.comparingInt(BuscaA::custo));
        }
    }

    @Override
    public String toString() {
        return "Busca A*";
    }
}
