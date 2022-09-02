package Projeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Arvore{
    No raiz = null;
    int altura = -1;

    public class No {
        public String dado;
        public No esquerda = null;
        public No direita = null;
        public ListaSE lista= new ListaSE();

        public No(String dado, File arquivo) {
            this.dado = dado;
            this.lista.insere_ultimo(arquivo);
        }
    }

    public void insere_elemento(String s, File f){
        No novo = new No(s,f);

        if(raiz == null){
            raiz = novo;
            novo.lista.insere_primeiro(f);
            altura++;
        }

        else{
            No p = raiz;
            boolean bool = true;

            while(bool){
                if(novo.dado.equals(p.dado)){
                    p.lista.insere_existe(f);
                    bool = false;
                }

                else if(novo.dado.compareTo(p.dado) < 0 && p.esquerda != null){ //confere se novo é menor que p e esquerda é diferente de nulo
                    p = p.esquerda;
                }

                else if(novo.dado.compareTo(p.dado) > 0 && p.direita != null){ //confere se novo é maior que p e direita é diferente de nulo
                    p = p.direita;
                }

                else if(novo.dado.compareTo(p.dado) < 0 && p.esquerda == null){ //confere se novo é maior que p e esquerda é nula
                    p.esquerda = novo;
                    rebalancear(this.raiz);
                    this.altura = altura(raiz);
                    bool = false;
                }

                else if(novo.dado.compareTo(p.dado) > 0 && p.direita == null){ //confere se novo é maior que p e direita é nula
                    p.direita = novo;
                    rebalancear(this.raiz);
                    this.altura = altura(raiz);
                    bool = false;
                }
            }
        }
    }

    public void remove_elemento(String s){
        if(altura == -1){
            System.out.println("A árvore já está vazia!");
        }

        if(altura == 0){
            if(raiz.dado.equals(s)){
                raiz = null;
            }
        }

        else{
            boolean bool = true;
            No pai = null;
            No p = raiz;
            String last = "";

            if(s.equals(raiz.dado)){
                No n = raiz.direita;
                while(n.esquerda != null){
                    n = n.esquerda;
                }
                p = raiz.esquerda;
                n.esquerda = p;
                raiz = n;
            }

            else{
                while(bool){

                    if(s.compareTo(p.dado)<0 && p.esquerda!= null){
                        pai = p;
                        p = p.esquerda;
                        last = "esquerda";
                    }

                    else if(s.compareTo(p.dado)>0 && p.direita!= null){
                        pai = p;
                        p = p.direita;
                        last = "direita";
                    }

                    else if(s.compareTo(p.dado)==0){
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

    public void existe_elemento(String s){
        No p = raiz;
        while(true){
            if (p.dado.equals(s)){
                p.lista.imprimir();
                break;
            }

            else if(s.compareTo(p.dado) < 0 && p.esquerda != null){
                p = p.esquerda;
            }

            else if(s.compareTo(p.dado) > 0 && p.direita != null){
                p = p.direita;
            }

            else if(s.compareTo(p.dado) < 0 && p.esquerda == null){
                System.out.println("Esta palavra não se encontra em nenhum arquivo.");
                break;
            }

            else if(s.compareTo(p.dado) > 0 && p.direita == null){
                System.out.println("Esta palavra não se encontra em nenhum arquivo.");
                break;
            }
        }
    }

    public void imprimir_pre(No p){
        No n = p;
        if(n != null){
            System.out.println(p.dado);
            imprimir_pre(p.esquerda);
            imprimir_pre(p.direita);
        }
    }

    public void imprimir_in(No p){
        No n = p;
        if(n != null){
            imprimir_in(p.esquerda);
            System.out.println(n.dado);
            imprimir_in(p.direita);
        }
    }

    public void imprimir_pos(No p){
        No n = p;
        if(n != null){
            imprimir_pos(p.esquerda);
            imprimir_pos(p.direita);
            System.out.println(n.dado);
        }
    }

    public int altura(No p){
        No n = p;
        if(n == null){
            return -1;
        }
        return Math.max(altura(n.esquerda),altura(n.direita))+1;
    }

//-------------------------------------------------------------------------------------------------------------------//

    public int fator(No p){
        return altura(p.esquerda)-altura(p.direita);
    }

    public No rebalancear(No p){
        if(this.altura == 0){
            return null;
        }// se cair aqui, a da esquerda vai ser maior
        if(fator(p)>= 2){
            switch (fator(p.esquerda)) {
                case 1:     // positivo com positivo, simples
                    raiz = rotacao_direita(p);
                    return raiz;
                case -1:    // positivo com negativo, dupla
                    p.esquerda = rotacao_esquerda(p.esquerda);
                    raiz = rotacao_direita(p);
                    return raiz;
                default:
                    p.esquerda = rebalancear(p.esquerda); // caso a sua esquerda esteja desbalanceada
                    raiz = p;
                    return p;
            }
        }// se cair aqui, a da direita vai ser maior
        else if(fator(p)<= -2){
            switch (fator(p.direita)) {
                case -1: // positivo com positivo, simples
                    raiz = rotacao_esquerda(p);
                    return raiz;
                case 1: // positivo com negativo, dupla
                    p.direita = rotacao_direita(p.direita);
                    raiz = rotacao_esquerda(p);
                    return raiz;
                default:
                    p.direita = rebalancear(p.direita);  // caso a sua direita esteja desbalanceada
                    raiz = p;
                    return p;
            }
        }
        else{
            return null;
        }
    }

    public No rotacao_direita(No p){
        No n = p.esquerda;
        No aux = n.direita;
        n.direita = p;
        p.esquerda = aux;
        return n;
    }

    public No rotacao_esquerda(No p){
        No n = p.direita;
        No aux = n.esquerda;
        n.esquerda = p;
        p.direita = aux;
        return n;
    }


    public File[] ler_pasta(){ // identifica quantos arquivos tem no diretório
        File arquivos[];
        File diretorio = new File("C:\\Users\\Diego\\Documents\\College\\7th Period\\Resolução de Problemas Estruturados\\ArquivosProjeto1");

        arquivos = diretorio.listFiles();
        return arquivos;
    }


    public void ler_arquivo() throws FileNotFoundException, IOException{ //leio arquivo por arquivo
        File[] arquivos = ler_pasta();

        for (File arquivo : arquivos) {

            FileReader lerfile = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(lerfile);

            String linha = br.readLine();

            while(linha!=null){
                for(String s :  linha.split(" ")){
                    insere_elemento(s,arquivo);
                }
                linha = br.readLine();
            }
        }
    }
}