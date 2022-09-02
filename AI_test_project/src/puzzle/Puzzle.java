package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Puzzle implements Comparable<Puzzle>{
    /**
     * Matriz de 3x3 de inteiros de 0 a 8, com o 0 representando o espaco branco
     */
    private final int[][] estado;
    /**
     * Variavel de suporte para localizar o espaco branco.
     */
    private final CoordenadaPuzzle X;
    /**
     * Nó anterior a esse
     */
    private Puzzle pai;
    /**
     * Direcao usada pelo pai para chegar no estado atual
     */
    private Direcao dirPai;
    /**
     * Tamanho do caminho usado para estimar o custo atual
     */
    private int tamCaminho = 0;

    /**
     * Constroi o puzzle a partir de um estado inicial, nao eh usado nos metodos de busca
     * @param estado Matriz de 3x3 de inteiros de 0 a 8, com o 0 representando o espaco branco
     * @throws EstadoInvalidoException Caso o estado passado nao seja 3x3 ou nao possua todos os numeros de 0 a 8
     */
    public Puzzle(int[][] estado) throws EstadoInvalidoException {
        this.estado = copiarEstado(estado);
        if(!estadoValido()) {
            throw new EstadoInvalidoException("Puzzle: estado passado ao construtor nao eh valido!\n" + this);
        }
        this.X = findX();
        this.pai = null;
        this.dirPai = null;
    }

    /**
     * Constroi uma copia completa a partir de outro Puzzle.
     * Tanto esse contrutor quanto o metodo copiar() podem ser usados para criar copias
     * @param other O outro Puzzle a ser copiado
     */
    public Puzzle(Puzzle other) {
        this.estado = copiarEstado(other.estado);
        this.X = other.X.copiar();
        this.pai = other.pai;
        this.dirPai = other.dirPai;
    }

    /**
     * Criar uma copia desse Puzzle e move a copia para uma direcao.
     * Se nao conseguir mover a copia entao retorna a si mesmo
     * @param dir Direcao que o filho vai mover
     * @return Retorna o filho se ele conseguiu mover, ao contrario retorna a si mesmo
     */
    public Puzzle criarFilho(Direcao dir) {
        var filho = new Puzzle(this);
        if(!filho.moverPara(dir)) return this;
        filho.pai = this;
        filho.dirPai = dir;
        filho.tamCaminho = tamCaminho + 1;
        return filho;
    }

    /**
     * Cria uma copia do Puzzle.
     * Tanto esse metodo quanto o construtor de copias podem ser usados para criar copias
     * @return A copia desse Puzzle
     */
    public Puzzle copiar() {
        return new Puzzle(this);
    }

    /**
     * Copia o estado interno do Puzzle
     * @param estado Estado interno de um Puzzle
     * @return Copia do estado
     */
    public static int[][] copiarEstado(int[][] estado) {
        var copia = new int[estado.length][estado[0].length];
        for(int i = 0; i < estado.length; i++) {
            copia[i] = estado[i].clone();
        }
        return copia;
    }

    /**
     * Retorna todos os possiveis movimentos possiveis com o etado atual do Puzzle
     * @return Array de Direcoes com a Direcoes possiveis
     */
    public Direcao[] getMovimentosPossiveis() {
        var direcoes = new ArrayList<Direcao>();
        for(var dir : Direcao.values()) {
            if (X.podeMoverPara(dir) && !dir.inversoDe(dirPai)) {
                direcoes.add(dir);
            }
        }
        var resultado = new Direcao[direcoes.size()];
        direcoes.toArray(resultado);
        return resultado;
    }

    /**
     * Retorna o caminho que o nó original percorreu para chegar nesse nó
     * @return Array de Direcoes com a direcoes percorridas
     */
    public Direcao[] getCaminhoPercorrido() {
        var caminho = new ArrayList<Direcao>();
        var no = this;
        while(no.pai != null) {
            caminho.add(no.dirPai);
            no = no.pai;
        }
        var resultado = new Direcao[caminho.size()];
        for(int i = 0; i < caminho.size(); i++) {
            resultado[i] = caminho.get(caminho.size() - 1 - i);
        }
        return resultado;
    }

    /**
     * Retorna a soma das distancia de manhattan de cada numero com aonde ele esta no estado objetivo
     */
    public int getDistanciaAoObjetivo() {
        if(distanciaAoObjetivo == null)
            distanciaAoObjetivo = createDistanciaAoObjetivo();
        return distanciaAoObjetivo;
    }

    private int createDistanciaAoObjetivo() {
        int distancialTotal = 0;
        for(int y = 0; y < 3; y++) {
            for(int x = 0; x < 3; x++) {
                distancialTotal += coordsObjetivo[estado[y][x]].distanciaManhattan(new CoordenadaPuzzle(x, y));
            }
        }
        return distancialTotal;
    }

    /**
     * Retorna o tamanho do caminho que o nó atual percorreu
     */
    public int getCustoCaminho() {
        return tamCaminho;
    }

    /**
     *  Deve ser usado apenas para avaliar estados na busca heuristica.
     *
     * @return A matriz que representa o estado objetivo do puzzle.
     */
    public static int[][] getEstadoObjetivo() {
        return estadoObjetivo;
    }

    /**
     * Tenta mover o espaco branco para uma direcao, se for uma direcao invalida entao nao move
     * @param dir Direcao para mover
     * @return "true" se conseguiu mover, "false" ao contrario
     */
    private boolean moverPara(Direcao dir) {
        var oldCoord = X.copiar();
        if(!X.moverPara(dir)) {
            return false;
        }
        var newCoord = X;
        setNumAt(oldCoord, getNumAt(newCoord));
        setNumAt(newCoord, 0);

        return true;
    }

    /**
     * Compara o estado interno de um Puzzle com outro
     * @param other Outro Puzzle a ser comparado com
     * @return "true" se forem iguais, "false" ao contrario
     */
    public boolean igual(Puzzle other) {
        return compararEstado(other.estado);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Puzzle puzzle = (Puzzle) o;

        return igual(puzzle);
    }

    @Override
    public int hashCode() {
        int result = 0;
        for(int i = 0; i < estado.length; i++) {
            for(int j = 0; j < estado[0].length; j++) {
                int factor = i * 3 + j;
                result ^= estado[i][j] << (factor * 3);
            }
        }
        return result;
    }

    /**
     * Compara esse Puzzle com o estado objetivo de getEstadoObjetivo()
     * @return "true" se os estados forem iguais, "false" ao contrario
     */
    public boolean estaResolvido() {
        return compararEstado(getEstadoObjetivo());
    }
    private boolean compararEstado(int[][] otherEstado) {
        for(int i = 0; i < estado.length; i++) {
            if(!Arrays.equals(estado[i], otherEstado[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Converte int[][] para String
     * @param estado Matriz base
     * @return String da matriz
     */
    public static String estadoToString(int[][] estado) {
        StringBuilder resultado = new StringBuilder();
        for(var linha : estado) {
            resultado.append(Arrays.toString(linha));
            resultado.append('\n');
        }
        return resultado.toString();
    }
    @Override
    public String toString() {
        return estadoToString(estado);
    }

    private int getNumAt(CoordenadaPuzzle coord) {
        return estado[coord.getY()][coord.getX()];
    }
    private void setNumAt(CoordenadaPuzzle coord, int num) {
        estado[coord.getY()][coord.getX()] = num;
    }
    private boolean estadoValido() {
        return estadoEh3x3() && estadoPossuiTodosOsNumeros();
    }
    private boolean estadoEh3x3() {
        if(estado.length != 3) {
            return false;
        }
        for(int[] linha : estado) {
            if(linha.length != 3) {
                return false;
            }
        }
        return true;
    }
    private boolean estadoPossuiTodosOsNumeros() {
        var numeros = new ArrayList<Integer>();
        for(int[] linha : estado) {
            for(int numero : linha) {
                numeros.add(numero);
            }
        }
        Collections.sort(numeros);
        for(int i = 0; i < 9; i++) {
            if(numeros.get(i) != i) {
                return false;
            }
        }
        return true;
    }
    private CoordenadaPuzzle findX() throws EstadoInvalidoException {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                if(estado[y][x] == 0) {
                    return new CoordenadaPuzzle(x, y);
                }
            }
        }
        throw new EstadoInvalidoException("Puzzle.findX(): X nao pode ser encontrado!");
    }
    private static int[][] createEstadoObjetivo() {
        return new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,0}};
    }
    private static CoordenadaPuzzle[] createCoordsObjetivo() {
        var coords = new CoordenadaPuzzle[9];
        for(int y = 0; y < estadoObjetivo.length; y++) {
            for(int x = 0; x < estadoObjetivo[0].length; x++) {
                coords[estadoObjetivo[y][x]] = new CoordenadaPuzzle(x, y);
            }
        }
        return coords;
    }


    @Override
    public int compareTo(Puzzle o) {
        for(int i = 0; i < estado.length; i++) {
            for(int j = 0; j < estado[0].length; j++) {
                if(estado[i][j] > o.estado[i][j]) return -1;
                if(estado[i][j] < o.estado[i][j]) return +1;
            }
        }
        return 0;
    }

    private static final int[][] estadoObjetivo = createEstadoObjetivo();
    private static final CoordenadaPuzzle[] coordsObjetivo = createCoordsObjetivo();
    private static Integer distanciaAoObjetivo = null;
}
