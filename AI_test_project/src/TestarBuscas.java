import buscas.Busca;
import buscas.ResultadoBusca;
import buscas.trab3.*;
import buscas.trab4.*;
import puzzle.*;

public class TestarBuscas {
    public static void main(String[] args) {
        var puzzleTeste = new Puzzle(new int[][]{
                {7,8,0},
                {4,5,6},
                {1,3,2}});
        Main.apresentarEstados(puzzleTeste);
        testar(puzzleTeste);
    }
    private static void apresentarResultado(Busca metodo, long tempo, ResultadoBusca resultado) {
        System.out.print("\n" + metodo + ": ");
        if(resultado.foiEncontrado()) {
            System.out.println("caminho de tamanho " + resultado.getCaminho().length + " encontrado em " + tempo + " milisegundos");
        } else {
            System.out.println("resultado nao encontrado!");
        }
    }
    public static void testar(Puzzle p) {
        var buscas = new Busca[]{
                new BuscaEmLargura(),
                new BuscaEmProfundidade(),
                new BuscaEmProfundidadeLimitada(),
                new BuscaEmProfundidadeIterativa(),
                new BuscaGulosa(),
                new BuscaA(),
                new BuscaEmProfundidadeIterativoA(),
        };
        System.out.println("Executando todas as buscas:");
        for(var busca : buscas) {
            var start = System.currentTimeMillis();
            var result = busca.buscar(p);
            var end = System.currentTimeMillis();
            var tempo = end - start;
            apresentarResultado(busca, tempo, result);
        }
    }
}
