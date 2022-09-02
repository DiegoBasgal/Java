package TDE4;

public class Arvore {
    
        No raiz = null;
        int altura = -1;
   

    public class No {
            public int dado;
            public No esquerda = null;
            public No direita = null;
            public No(int dado) {
                this.dado = dado;
            }
        }
    
    public void insere_elemento(int x){
        No novo = new No(x);

        if(raiz == null){
            raiz = novo;
            altura++;
        }
        else{
            No p = raiz;
            boolean bool = true;
            while(bool){
                if(novo.dado == p.dado){
                    bool = false;
                }
                else if((novo.dado < p.dado) && p.esquerda!= null){//confere se novo é menor que p
                    p = p.esquerda;
                }
                else if((novo.dado> p.dado )  && p.direita!= null){//confere se novo é maior que p
                    p = p.direita;
                }
                else if((novo.dado < p.dado) && p.esquerda== null){
                    p.esquerda = novo;
                    bool = false;
                }
                else if((novo.dado > p.dado)  && p.direita== null){
                    p.direita = novo;
                    bool = false;
                }
            }            
        }
    }   

    public boolean existe_elemento(int X){
        No p = raiz;
        boolean bool = true;
            while(bool){
                if (p.dado==X){
                    return true;
                }
                else if((X < p.dado)  && p.esquerda!= null){
                    p = p.esquerda;
                }
                else if((X > p.dado)  && p.direita!= null){
                    p = p.direita;                  
                }
                else if((X< p.dado) && p.esquerda== null){
                    bool = false;
                }
                else if((X > p.dado)&& p.direita== null){
                    bool = false;
                }
            } 
        return false;
    }
    
    public int altura(No x){
        No p = x;
        if(p == null){
            return -1;
        }
        return Math.max(altura(p.esquerda),altura(p.direita))+1;
    }
    public int fator(No n){
        return altura(n.esquerda)-altura(n.direita);
    }
    
    public No rebalancear(No n){
        if(this.altura == 0){
            return null;
        }

            // se cair aqui, a da esquerda vai ser maior0
                if(fator(n)>= 2){
                    switch (fator(n.esquerda)) {
                        case 1:     // positivo com positivo, simples
                            raiz = rotacao_direita(n);
                            return raiz;
                        case -1:    // positivo com negativo, dupla
                            n.esquerda = rotacao_esquerda(n.esquerda);
                            raiz = rotacao_direita(n);
                            return raiz;
                        default:
                            n.esquerda = rebalancear(n.esquerda);     // caso a sua esquerda esteja desbalanceada
                            raiz = n;
                            return n;
                    }
                }
                    else if(fator(n)<= -2){
                        switch (fator(n.direita)) {
                            case -1:     // positivo com positivo, simples
                                raiz = rotacao_esquerda(n);
                                return raiz;
                            case 1:    // positivo com negativo, dupla
                                n.direita = rotacao_direita(n.direita);
                                raiz = rotacao_esquerda(n);
                                return raiz;
                            default:
                                n.direita = rebalancear(n.direita);  // caso a sua direita esteja desbalanceada
                                raiz = n;
                                return n;
                        }
                            }
             else{
                return null;
                }
            }
      
    public No rotacao_direita(No p){
        No q = p.esquerda;
        No aux = q.direita;
        q.direita = p;
        p.esquerda = aux;
        return q;              
    }
    
    public No rotacao_esquerda(No p){
        No q = p.direita;
        No aux = q.esquerda;
        q.esquerda = p;
        p.direita = aux;
        return q;              
    }
   
    public void remove(int x){
        if(altura == -1){
            System.out.println("Impossível remover, árvore vazia");
        }
        if(altura == 0){
            if(raiz.dado == x){
                raiz = null;
            }
        }
        
        else{
            boolean bool = true; 
            No pai = null;
            No p = raiz;
            String last = "";
            
            if(x==raiz.dado){
                
                No q = raiz.direita;
                
                while(q.esquerda != null){
                    q = q.esquerda;
                    pai = q;
                }
                 
                p = raiz.esquerda;
                q.esquerda = p;
                raiz = q;                                   
                
            }
            else{
                while(bool){

                     if((x <p.dado)&& p.esquerda!= null){
                        pai = p;
                        p = p.esquerda;
                        last = "esquerda";
                    }
                    else if((x< p.dado) && p.direita!= null){
                        pai = p;
                        p = p.direita;       
                        last = "direita";
                    }

                    else if(x==p.dado){
                        bool = false;
                    }
                }

                if(last.equals("esquerda")){
                    No aux = p.esquerda;
                    No pai2 = null ;
                    p = p.direita;
                    while(p.esquerda!=null){
                        pai2 = p;
                        p = p.esquerda;

                    }
                    pai.esquerda = p;
                    p.esquerda = aux;
                    if(pai2!= null){
                        p.direita = pai2;
                        pai2.esquerda = null;
                    }


                }
                else if(last.equals("direita")){
                     No aux = p.esquerda;
                    No pai2 = null ;
                    p = p.direita;
                    while(p.esquerda!=null){
                        pai2 = p;
                        p = p.esquerda;
                    }
                    pai.direita = p;
                    p.esquerda = aux;
                    if(pai2!= null){
                        p.direita = pai2;
                        pai2.esquerda = null;
                    }
                }


            }
        }
        
        
    }
    
  

    
    
}
    
    
    

