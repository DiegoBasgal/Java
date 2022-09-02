package puzzle;

class CoordenadaPuzzle {
    private int x = 0;
    private int y = 0;

    public CoordenadaPuzzle(int x, int y) throws EstadoInvalidoException {
        setX(x);
        setY(y);
    }
    public CoordenadaPuzzle(CoordenadaPuzzle other) {
        this.x = other.x;
        this.y = other.y;
    }
    public CoordenadaPuzzle copiar() {
        return new CoordenadaPuzzle(this);
    }
    public int getX() {
        return x;
    }
    public void setX(int x) throws EstadoInvalidoException{
        if(x < 0) throw new EstadoInvalidoException("CoordenadaPuzzle: x nao pode ser menor que 0!");
        if(x > 2) throw new EstadoInvalidoException("CoordenadaPuzzle: x nao pode ser maior que 2!");
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) throws EstadoInvalidoException {
        if(y < 0) throw new EstadoInvalidoException("CoordenadaPuzzle: y nao pode ser menor que 0!");
        if(y > 2) throw new EstadoInvalidoException("CoordenadaPuzzle: y nao pode ser maior que 2!");
        this.y = y;
    }
    public boolean podeMoverPara(Direcao dir) {
        switch (dir) {
            case CIMA -> {
                return y > 0;
            }
            case BAIXO -> {
                return y < 2;
            }
            case DIREITA -> {
                return x < 2;
            }
            case ESQUERDA -> {
                return x > 0;
            }
        }
        return false;
    }
    public boolean moverPara(Direcao dir) {
        if(!podeMoverPara(dir)) {
            return false;
        }
        switch (dir) {
            case CIMA -> y--;
            case BAIXO -> y++;
            case DIREITA -> x++;
            case ESQUERDA -> x--;
        }
        return true;
    }
    public boolean igual(CoordenadaPuzzle other) {
        return x == other.x && y == other.y;
    }
    public int distanciaManhattan(CoordenadaPuzzle other) {
        return Math.abs(x - other.x) + Math.abs(y - other.y);
    }
}
