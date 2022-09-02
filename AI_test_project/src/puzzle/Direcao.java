package puzzle;

public enum Direcao {
    CIMA,
    BAIXO,
    DIREITA,
    ESQUERDA;

    public boolean inversoDe(Direcao dir) {
        if(dir == null) return false;
        switch(dir) {
            case CIMA -> {
                return this == BAIXO;
            }
            case BAIXO -> {
                return this == CIMA;
            }
            case DIREITA -> {
                return this == ESQUERDA;
            }
            case ESQUERDA -> {
                return this == DIREITA;
            }
        }
        return false;
    }
}
