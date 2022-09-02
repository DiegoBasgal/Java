import buscas.Busca;
import buscas.ResultadoBusca;
import buscas.trab3.BuscaEmLargura;
import buscas.trab3.BuscaEmProfundidade;
import buscas.trab3.BuscaEmProfundidadeIterativa;
import buscas.trab3.BuscaEmProfundidadeLimitada;
import buscas.trab4.BuscaA;
import buscas.trab4.BuscaEmProfundidadeIterativoA;
import buscas.trab4.BuscaGulosa;
import puzzle.Direcao;
import puzzle.EstadoInvalidoException;
import puzzle.Puzzle;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        apresentarExemplo();
        var sc = new Scanner(System.in);
        var puzzle = getPuzzleFromInput(sc);
        Metodo met = getMetodoFromInput(sc);
        apresentarEstados(puzzle);
        ResultadoBusca resultado = executarMetodo(puzzle, met, sc);

        if(resultado.foiEncontrado()) {
            System.out.println("Tamanho do caminho: " + resultado.getCaminho().length);
            System.out.println("Caminho encontrado (direcoes para mover o espaco branco):");
            apresentarCaminho(resultado.getCaminho());
        } else {
            System.out.println("O metodo nao encontrou um caminho!");
        }
    }


    private static void apresentarExemplo() {
        System.out.println("Exemplo de estado inicial (0 representa o espaco em branco):");
        System.out.println("Linha 1: 7 1 6");
        System.out.println("Linha 2: 0 2 4");
        System.out.println("Linha 3: 5 3 8");
    }

    public static void apresentarEstados(Puzzle p) {
        System.out.println("Estado inicial:\n" + p);
        System.out.println("Estado objetivo:\n" + Puzzle.estadoToString(Puzzle.getEstadoObjetivo()));
    }
    private static Puzzle getPuzzleFromInput(Scanner sc) {
        System.out.println("Digite o estado inicial:");
        var linhas = new int[3][3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Linha " + (i + 1) + ": ");
            for (int j = 0; j < 3; j++) {
                linhas[i][j] = sc.nextInt();
            }
        }
        try {
            return new Puzzle(linhas);
        } catch (EstadoInvalidoException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        return null;
    }

    private static Metodo getMetodoFromInput(Scanner sc) {
        boolean escolhido = false;
        int numEscolha = 0;
        while (!escolhido) {
            System.out.println("Escolha o metodo de busca:");
            System.out.println("\t1 - Busca em Largura");
            System.out.println("\t2 - Busca em Profundidade");
            System.out.println("\t3 - Busca em Profundidade Limitada");
            System.out.println("\t4 - Busca em Profundidade Iterativa");
            System.out.println("\t5 - Busca em Busca Gulosa");
            System.out.println("\t6 - Busca em Busca A*");
            System.out.println("\t7 - Busca em em Profundidade Iterativa com A*");
            System.out.println("\t8 - Todos");
            System.out.println("\t0 - Sair do Programa");
            System.out.print("Escolha: ");
            numEscolha = sc.nextInt();
            if(numEscolha == 0) {
                System.exit(0);
            } else if(numEscolha < 1 || numEscolha > 8) {
                continue;
            }
            escolhido = true;
        }
        return Metodo.numToMetodo(numEscolha);
    }
    private static ResultadoBusca executarMetodo(Puzzle p, Metodo met, Scanner sc) {
        if(met == Metodo.TODOS) {
            TestarBuscas.testar(p);
            System.exit(0);
        }
        var busca = Metodo.metToBusca(met);
        assert busca != null;

        int limite = 0;
        if(busca instanceof BuscaEmProfundidadeLimitada) {
            limite = getProfundidadeFromInput(sc);
        }

        System.out.println("Executando metodo de busca...");

        ResultadoBusca resultado;
        if(busca instanceof BuscaEmProfundidadeLimitada limitada) {
            resultado = limitada.buscar(p, limite);
        } else {
            resultado = busca.buscar(p);
        }
        return resultado;
    }
    private static int getProfundidadeFromInput(Scanner sc) {
        System.out.print("Digite a profundidade maxima: ");
        return sc.nextInt();
    }
    private static void apresentarCaminho(Direcao[] dirs) {
        for(var dir : dirs) {
            System.out.println(dir.name().toLowerCase(Locale.ROOT));
        }
    }

    private enum Metodo {
        LARGURA(1),
        PROFUN(2),
        PROFUN_LIMIT(3),
        PROFUN_ITER(4),
        GULOSA(5),
        BUSCA_A(6),
        PROFUN_ITER_A(7),
        TODOS(8);

        public final int num;

        Metodo(int num) {
            this.num = num;
        }
        public static Metodo numToMetodo(int num) {
            for(var metodo : Metodo.values()) {
                if(metodo.num == num) {
                    return metodo;
                }
            }
            return null;
        }
        public static Busca metToBusca(Metodo met) {
            switch (met) {
                case LARGURA -> {
                    return new BuscaEmLargura();
                }
                case PROFUN -> {
                    return new BuscaEmProfundidade();
                }
                case PROFUN_LIMIT -> {
                    return new BuscaEmProfundidadeLimitada();
                }
                case PROFUN_ITER -> {
                    return new BuscaEmProfundidadeIterativa();
                }
                case GULOSA -> {
                    return new BuscaGulosa();
                }
                case BUSCA_A -> {
                    return new BuscaA();
                }
                case PROFUN_ITER_A -> {
                    return new BuscaEmProfundidadeIterativoA();
                }
            }
            return null;
        }
    }
}
