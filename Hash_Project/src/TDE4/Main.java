package TDE4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.print("Insira o tamanho do array: ");
        int tamanho = sc.nextInt();
        Arvore arvore = new Arvore();
        BuscaBinaria buscaB = new BuscaBinaria(tamanho);
        THash hash = new THash(tamanho);
        int[] aleatorio = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
             aleatorio[i] = rand.nextInt(100000000);
        }

       //-------------------------------------------------------------- Indexação da árvore
        long start = System.currentTimeMillis();
        System.out.println("\nConstruindo árvore...");
        for (int i = 0; i < tamanho; i++) {
             arvore.insere_elemento(aleatorio[i]);
             
        }
        long end = System.currentTimeMillis();
        double TIarvore = (end-start);
        
        //------------------------------------------------------------- Indexação lista
        for (int i = 0; i < tamanho; i++) {
              buscaB.Inserir(aleatorio[i]);
        }
        System.out.println("Ordenando array...");
        start = System.currentTimeMillis();
        Arrays.sort(buscaB.vetorBusca);
        end = System.currentTimeMillis();
        double TIarray = (end-start);
      
        //------------------------------------------------------------- Indexação tabela hash
        start = System.currentTimeMillis();
        for (int i = 0; i < tamanho; i++) {
              hash.insere_hashing(aleatorio[i]);
        }
        System.out.println("Ordenando tabela hash...");
        end = System.currentTimeMillis();
        double TIhash = (end-start);
        System.out.print("\nInsira o número de chaves a pesquisar: ");
        tamanho = sc.nextInt();
        int[] aleatorio2 = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            aleatorio2[i] = rand.nextInt(100000000);
        }

        //------------------------------------------------------------- Busca da árvore
        System.out.println("\nBuscando na árvore...");
        start = System.currentTimeMillis();
        for (int i = 0; i < tamanho; i++) {
            arvore.existe_elemento(aleatorio2[i]);
        }
        end = System.currentTimeMillis();
        double TBarvore = (end-start);

        //------------------------------------------------------------- Busca da lista
        System.out.println("Buscando com busca binária...");
        start = System.currentTimeMillis();
        for (int i = 0; i < tamanho; i++) {
            buscaB.Busca(aleatorio2[i]);
        }
        end = System.currentTimeMillis();
        double TBarray = (end-start);

        //------------------------------------------------------------- Busca da tabela hash
        start = System.currentTimeMillis();
        for (int i = 0; i < tamanho; i++) {
            hash.busca_hashing(aleatorio2[i]);
        }
        System.out.println("Buscando na tabela hash...");
        end = System.currentTimeMillis();
        double TBhash = (end-start);

        //------------------------------------------------------------- Resultados
        System.out.println("\nÁrvore:");
        System.out.println("Tempo de indexacao da árvore: "+TIarvore);
        System.out.println("Tempo de busca da árvore: "+ TBarvore);
        System.out.println("Tempo total da árvore: "+ (TBarvore+TIarvore));
        System.out.println("\nBusca Binária:");
        System.out.println("Tempo de indexacao do array: "+TIarray);
        System.out.println("Tempo de busca do array: "+ TBarray);
        System.out.println("Tempo total do array: "+ (TBarray+TIarray));
        System.out.println("\nTabela Hash:");
        System.out.println("Tempo de indexacao da tabela hash: "+TIhash);
        System.out.println("Tempo de busca da tabela hash: "+ TBhash);
        System.out.println("Tempo total da tabela hash: "+ (TIhash+TBhash));
    }
}
