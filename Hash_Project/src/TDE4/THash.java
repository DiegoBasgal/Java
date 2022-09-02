package TDE4;

public class THash {
    int tam;
    ListaSE tabela[];

    public THash(int tam) {
        this.tam = tam;
        this.tabela = new ListaSE[tam];
     
        for (int i = 0; i < tam; i++) {
            tabela[i] = new ListaSE();
        }
    }
        
    private int hash(int chave){
        return chave%tam;
    }
        
    public boolean busca_hashing(int chave){
        int i = hash(chave);
        return tabela[i].existe(chave);   
    }
        
    public void insere_hashing(int chave){
        int i = hash(chave);
        tabela[i].InsereOrdenado(chave);
        
    }
    
}