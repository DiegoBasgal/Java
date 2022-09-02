package Projeto;

import java.io.File;

public class ListaSE {
    private No primeiro = null;
    private No ultimo = null;

    public ListaSE() {}

    public class No {
        private int quantidade;
        private File arquivo;
        private No proximo;

        public No(File arquivo) {
            this.quantidade = 1;
            this.arquivo = arquivo;
        }

        public void setProximo(No novo){
            this.proximo = novo;
        }
    }

    public boolean vazia(){
        if(primeiro == null){
            return true;
        }
        return false;
    }

    public void insere_primeiro(File f){ // define o primeiro nó, caso a lista ja tenha um, este vira o próximo do novo primeiro
        No novo = new No(f);
        if(this.vazia()){ //
            this.primeiro = novo;
            this.ultimo = novo;
        }
        else{
            novo.proximo = this.primeiro;
            this.primeiro = novo;
        }
    }

    public No insere_depois(No p, File f){ // insere um nó após P, tornando o novo nó o próximo de P, o próximo do novo o antigo próximo de P
        try{
            No novo = new No(f);
            novo.setProximo(p.proximo);
            p.proximo = novo;
            return novo;
        }
        catch(Exception ex){
            System.out.println("erro!!!");
            return null;
        }
    }

    public void insere_ultimo(File f){
        if(this.vazia()){
            this.insere_primeiro(f);
        }
        else{
            this.ultimo = insere_depois(this.ultimo,f);
        }
    }

    public void insere_existe(File f){
        No p = this.primeiro;
        while(p!=null){
            if(p.arquivo.equals(f)){
                p.quantidade++;
                break;
            }
            else if(p.proximo != null){
                p=p.proximo;
            }
            else if (p.proximo == null){
                p.proximo = new No(f);
                break;
            }

        }

    }

    public void imprimir(){  // mostra o primeiro nó e incrementa até que o próximo seja nulo
        No p  = this.primeiro;
        while(p!=null){
            System.out.println(p.arquivo);
            System.out.println(p.quantidade);
            System.out.println("------------------------------------------------------------");
            p = p.proximo;
        }
    }
}