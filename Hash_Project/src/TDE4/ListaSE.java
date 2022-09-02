package TDE4;


public class ListaSE {
    private No primeiro = null;
    private No ultimo = null;

    public ListaSE() {}
    
        public class No {
            public int dado;
            public No proximo;

            public No(int dado) {
                this.dado = dado;
            }

            public void SetProximo(No novo){
                this.proximo = novo;
            }
        }
    
    public boolean existe(int x){
        No p = this.primeiro;
        
        while(p != null && p.dado<x){
            p=p.proximo;
        }
        if(p==null){
            return false;
        }
        if(p.dado==x){
            return true;
        }
        return false;
    }   
    
    
    public boolean Vazia(){
        if(primeiro == null){
            return true;
        }
        return false;
    }
    
    public void InserePrimeiro(int x){
        No novo = new No(x);
        
        if(this.Vazia()){ // 
            this.primeiro = novo; 
            this.ultimo = novo;
        }
        else{
           novo.proximo= this.primeiro;
           this.primeiro = novo;
        }
    }
    
    public No InsereDepois(No p,int x){
        try{ 
            No novo = new No(x);
            novo.SetProximo(p.proximo);
            p.proximo = novo;
            return novo;
        }
        catch(Exception ex){
            System.out.println("erro!!!");
            return null;
        }
    }
    
    public void InsereUltimo(int x){ 
        if(this.Vazia()){
            this.InserePrimeiro(x);
        }
        else{
            this.ultimo = InsereDepois(this.ultimo,x);
        }      
    }
   
    public void InsereOrdenado(int x){  
        if(this.Vazia()){
            this.InserePrimeiro(x);
        }
        else{
            if(x<= this.primeiro.dado){
                this.InserePrimeiro(x);
                
            }
            else if(x>= this.ultimo.dado){
                this.InsereUltimo(x);
                
            }
            else{
                No p = primeiro;
                while(p != null){
                    if(p.dado<x && x<p.proximo.dado){
                        this.InsereDepois(p, x);      
                        break;
                    }
                    else if (x == p.dado){
                        this.InsereDepois(p, x);      
                        break;
                    }
                    p = p.proximo;
                }
            }
        }
    }

}