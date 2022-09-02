import java.util.Random;

public class Pessoa {
    private final String id;
    private final String k_mestre;
    private int nonce = 0;

    public int gerarNonce() {
        Random rand = new Random();
        int MAX = 1000;
        return rand.nextInt(MAX);
    }

    public Pessoa(String id, String k_mestre){
        this.id = id;
        this.k_mestre = k_mestre;
    }

    public String getID(){
        return this.id;
    }

    public String getK_mestre(){
        return this.k_mestre;
    }

}
