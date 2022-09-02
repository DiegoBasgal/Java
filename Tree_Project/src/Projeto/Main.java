package Projeto;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        Arvore arvore = new Arvore(); // instanciando um árvore

        System.out.println(Arrays.toString(arvore.ler_pasta())); // printar os diretórios de cada arquivo txt
        arvore.ler_arquivo();

        Scanner S = new Scanner(System.in);

        while(true){
            System.out.println("\n1 - Mostrar árvore "
                    + "\n2 - Consultar elemento"
                    + "\n3 - Apagar elemento");
            String R = S.nextLine();

            if(R.equals("1")){
                System.out.println("1 - Pré-ordem"
                        + "\n2 - Pós-ordem"
                        + "\n3 - In-ordem\n");
                R = S.nextLine();
                if(R.equals("1")){
                    arvore.imprimir_pre(arvore.raiz);
                }
                else if(R.equals("2")){
                    arvore.imprimir_pos(arvore.raiz);
                }
                else if(R.equals("3")){
                    arvore.imprimir_in(arvore.raiz);
                }
                System.out.println("\nraiz:");
                System.out.print(arvore.raiz.dado);
            }
            else if(R.equals("2")){
                System.out.println("Insira um elemento:");
                R = S.nextLine();
                arvore.existe_elemento(R);
            }
            else if(R.equals("3")){
                System.out.println("Insira um elemento arvore ser removido:");
                R = S.nextLine();
                arvore.remove_elemento(R);
            }
        }
    }
}
