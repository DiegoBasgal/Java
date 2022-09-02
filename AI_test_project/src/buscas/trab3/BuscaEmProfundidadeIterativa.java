package buscas.trab3;

import buscas.Busca;
import buscas.ResultadoBusca;
import puzzle.Puzzle;

public class BuscaEmProfundidadeIterativa extends Busca {
    private static final BuscaEmProfundidadeLimitada buscaLimitada = new BuscaEmProfundidadeLimitada();
    /**
     * Essa implementacao eh basicamente uma copia do pseudocodico dos slides do professor
     */
    @Override
    public ResultadoBusca buscar(Puzzle puzzle) {
        for(int limite = 0;; limite++) {
            var resultado = buscaLimitada.buscar(puzzle, limite);
            if(resultado.foiEncontrado()) return resultado;
        }
    }

    @Override
    public String toString() {
        return "Busca em Profundidade Iterativa";
    }
}
