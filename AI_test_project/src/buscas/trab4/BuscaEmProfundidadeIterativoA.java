package buscas.trab4;

import buscas.Busca;
import buscas.ResultadoBusca;
import puzzle.Puzzle;

import java.util.TreeSet;

public class BuscaEmProfundidadeIterativoA extends Busca {
    /**
     * Essa implementacao eh basicamente uma copia do pseudocodico dos slides do professor
     * exceto que nao busca nós ja explorados
     */
    @Override
    public ResultadoBusca buscar(Puzzle puzzle) {

        var limite = custo(puzzle);
        while(true) {
            var explorados = new TreeSet<Puzzle>();
            var resultado = profundidadeIterativa(puzzle, limite, explorados);
            if(resultado.foiEncontrado()) return resultado;
            limite = resultado.limite();
            if(limite == Integer.MAX_VALUE) return new ResultadoBusca(false);
        }
    }
    private static ResultadoBusca profundidadeIterativa(Puzzle no, int limite, TreeSet<Puzzle> explorados) {
        explorados.add(no);
        var custoNo = custo(no);
        if(custoNo > limite) return ResultadoBusca.criarLimite(custoNo);
        if(no.estaResolvido()) return new ResultadoBusca(true, no.getCaminhoPercorrido());

        int proximoLimite = Integer.MAX_VALUE;
        var direcoesPossiveis = no.getMovimentosPossiveis();
        for(var dir : direcoesPossiveis) {
            var filho = no.criarFilho(dir);
            if(!explorados.contains(filho)) {
                var result = profundidadeIterativa(filho, limite, explorados);
                if(result.foiEncontrado()) return result;
                proximoLimite = Integer.min(proximoLimite, result.limite());
            }
        }
        return ResultadoBusca.criarLimite(proximoLimite);

    }
    private static int custo(Puzzle no) {
        return no.getDistanciaAoObjetivo() + no.getCustoCaminho();
    }

    @Override
    public String toString() {
        return "Busca em Profundidade Iterativa com A*";
    }
}
