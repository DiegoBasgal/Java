import java.util.Arrays;

public class FilaCircular {

    private Object[] fila;
    private int MAX;
    private int primeiro;
    private int ultimo;
    private int numElem;

    public FilaCircular(int tamanho){
        fila = new Object[tamanho];
        MAX = tamanho;
        primeiro = 0;
        ultimo = -1;
        numElem = 0;
    }

    public boolean vazia(){
        return numElem == 0;
    }

    public boolean cheia (){
        return numElem == MAX;
    }

    public void insere(Object elemento) {
        if(!cheia()){
            if(ultimo == MAX - 1)
                ultimo = -1;
            ultimo++;
            fila[ultimo] = elemento;
            numElem++;
        }
        else
            System.out.println("Fila Cheia");
    }

    public Object remove(){
        Object aux = null;
        if(!vazia()){
            if(primeiro == MAX)
                primeiro = 0;
            aux = fila[primeiro];
            fila[primeiro] = null;
            primeiro++;
            numElem--;
        }
        else{
            System.out.println("Fila vazia");
        }
        return aux;
    }

    public void primeiro(){
        System.out.println(fila[primeiro]);
    }

    public void ultimo(){
        System.out.println(fila[ultimo]);;
    }

    public int getTamanho() {
        return MAX;
    }

    public void setTamanho(int tamanho) {
        this.MAX = tamanho;
    }

    public Object getElemento(int i){
        return this.fila[i];
    }

    public void merge(FilaCircular f) {
        Object[] aux = this.fila;
        if(ultimo == MAX - 1){
            ultimo = -1;
            numElem = 0;
            setTamanho(MAX + f.getTamanho());
        }
        this.fila = new Object[MAX];
        for (int i = 0, j = 0; i < aux.length || j < f.getTamanho(); ++i, ++j) {
            if (i < aux.length)
                insere(aux[i]);
            if (j < f.getTamanho())
                insere(f.getElemento(j));
        }
        System.out.println("Merge das duas filas: " + Arrays.toString(this.fila));
    }
}

