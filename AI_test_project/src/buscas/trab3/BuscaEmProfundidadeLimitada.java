package buscas.trab3;

import buscas.Busca;
import buscas.ResultadoBusca;
import puzzle.Puzzle;

public class BuscaEmProfundidadeLimitada extends Busca {
    private int lim = 50;
    /**
     * Essa implementacao eh basicamente uma copia do pseudocodico dos slides do professor
     * @param limite Profundidade maxima a procurar
     */
    public ResultadoBusca buscar(Puzzle puzzle, int limite) {
        lim = limite;
        var resultado = profundidadeIterativa(puzzle, limite);
        if(resultado.foiEncontrado()) return resultado;
        return new ResultadoBusca(false);
    }
    private static ResultadoBusca profundidadeIterativa(Puzzle no, int limite) {
        if(no.estaResolvido()) return new ResultadoBusca(true, no.getCaminhoPercorrido());
        if(limite == 0) return ResultadoBusca.criarCorte();
        boolean ocorreuCorte = false;
        var direcoesPossiveis = no.getMovimentosPossiveis();
        for(var dir : direcoesPossiveis) {
            var filho = no.criarFilho(dir);
            var resultado = profundidadeIterativa(filho, limite - 1);
            if(resultado.cortado()) ocorreuCorte = true;
            else if(resultado.foiEncontrado())
                return resultado;
        }
        if(ocorreuCorte) return ResultadoBusca.criarCorte();

        return new ResultadoBusca(false);
    }
    /**
     * Overload com limite padrao de 50
     */
    @Override
    public ResultadoBusca buscar(Puzzle puzzle) {
        return buscar(puzzle, 50);
    }

    @Override
    public String toString() {
        return "Busca em Profundidade Limitada (limite = " + lim + ")";
    }

}
