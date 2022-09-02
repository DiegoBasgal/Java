package buscas;

import puzzle.Direcao;

public class ResultadoBusca {
    private int especial = 0;
    private boolean encontrado = false;
    private Direcao[] caminho = null;

    private ResultadoBusca() {

    }
    public ResultadoBusca(boolean achado) {
        this.encontrado = achado;
        if(achado) {
            this.caminho = new Direcao[]{};
        }
    }
    public ResultadoBusca(boolean achado, Direcao[] caminho) {
        this.encontrado = achado;
        this.caminho = caminho;
    }

    public static ResultadoBusca criarCorte() {
        var result = new ResultadoBusca();
        result.especial = 1;
        return result;
    }
    public static ResultadoBusca criarLimite(int limite) {
        var result = new ResultadoBusca();
        result.especial = limite;
        return result;
    }

    public boolean foiEncontrado() {
        return encontrado;
    }
    public boolean cortado() {
        return especial > 0;
    }
    public int limite() {
        return especial;
    }
    public Direcao[] getCaminho() {
        return caminho;
    }
}
