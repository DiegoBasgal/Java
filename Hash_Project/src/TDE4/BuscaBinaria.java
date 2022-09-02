package TDE4;

public class BuscaBinaria {
    public int vetorBusca[];
    public int superior;
    public int inferior;
    public int meio;
    public int cont = 0;
    
    public BuscaBinaria(int tamanho) {
        this.vetorBusca = new int[tamanho];
        this.superior = tamanho-1;
        this.inferior = 0;
        this.meio = (this.inferior+this.superior)/2;

    }
    
    public void Inserir(int x){
        
       vetorBusca[cont] = x;
        cont++;
        
    }
    
    public int Busca(int x){
        int inf = inferior;
        int sup = superior;
        int m = meio;
        while(inf <= sup){
            if(vetorBusca[m]==x){
                return m;
            }
            if(x<vetorBusca[m]){
                sup = m-1;
                m= (inf+sup) /2;
            }
            if(x>vetorBusca[m]){
                inf = m+1;
                m= (inf+sup) /2;
            }
            
            
        }  
        
        return -1;
    }
}

