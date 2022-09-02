package projeto_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Random rand =  new Random();

        for (int j = 0; j < 3; j++) { // testa 3 arrays de tamanhos diferentes

            System.out.print("Insira o tamanho do array de pesquisas: ");
            int resposta = sc.nextInt();

            // ----------------------------------------------------- Criando arrays desordenado
            System.out.println("\nCriando array desordenado...");

            int[] Desordenado = new int[resposta];  // criando os arrays
            int[] QuaseOrdenado = new int[resposta];
            Integer[] DecrescenteAux = new Integer[resposta];

            for (int i = 0; i < resposta; i++) { // inserindo os elementos dentro dos arrays
                int x = rand.nextInt(100); // irá pegar números aleatórios até 100
                Desordenado[i] = x;
                QuaseOrdenado[i] = x;
                DecrescenteAux[i] = x;
            }

            //---------------------------------------------------- Criando array quase ordenado
            System.out.println("Criando array quase ordenado...");
            Arrays.sort(QuaseOrdenado); // faz a operação de sort no array

            int quantdesord = Math.round((resposta * 10)/100);

            for (int i = 0; i < quantdesord; i++) { // faz o loop de acordo com o cálculo feito da variável quantdesord
                int a = rand.nextInt(resposta - 1);
                int b = rand.nextInt(resposta - 1);

                int aux = QuaseOrdenado[a];
                QuaseOrdenado[a] = QuaseOrdenado[b]; // operação para randomizar números dentro do array (um randômico, um ordenado e assim por diante)
                QuaseOrdenado[b] = aux;
            }

            //----------------------------------------------------- Criando array decrescente
            System.out.println("Criando array decrescente...\n");
            Arrays.sort(DecrescenteAux, Collections.reverseOrder()); // pega o array desordenado, faz a opeação de sort e inverte a ordem

            int[] Decrescente = new int[resposta];

            for (int i = 0; i < resposta; i++) { // operação para inserir os elementos já tratados no novo array
                Decrescente[i] = DecrescenteAux[i];
            }

            //----------------------------------------------------- Criando os sorts
            QuickSort QS = new QuickSort();
            HeapSort HS = new HeapSort();
            ShellSort SS = new ShellSort();
            RadixSort RS = new RadixSort();
            MergeSort MS = new MergeSort();
            SmoothSort SMS = new SmoothSort();

            //----------------------------------------------------- QUICKSORT

            System.out.print("QuickSorting desordenado...");
            int[] clonar = Desordenado.clone(); // Clona o array gerado desordenado

            long inicio = System.currentTimeMillis(); // Começa o contador
            QS.sort(clonar); // Clona o array para a operação de sort (nesse caso o QuickSort)
            long fim = System.currentTimeMillis(); // Finaliza o contador
            long QSDes = fim - inicio; // Retorna tempo levado para a operação

            System.out.print("\nquase ordenado...");
            clonar = QuaseOrdenado.clone(); // Clona o array gerado quase ordenado

            inicio = System.currentTimeMillis();
            QS.sort(clonar);
            fim = System.currentTimeMillis();
            long QSQuase = fim - inicio;

            System.out.println("\ndecrescente...\n");
            clonar = Decrescente.clone(); // Clona o array gerado quase ordenado

            inicio = System.currentTimeMillis();
            QS.sort(clonar);
            fim = System.currentTimeMillis();
            long QSDecres = fim - inicio;

            // ----------------------------------------- HEAPSORT
            System.out.print("\nHeapsorting desordenado...");
            clonar = Desordenado.clone();
            inicio = System.currentTimeMillis();
            HS.sort(clonar);
            fim = System.currentTimeMillis();
            long HSDes = fim - inicio;
            System.out.print("\nquase ordenado...");
            clonar = QuaseOrdenado.clone();
            inicio = System.currentTimeMillis();
            HS.sort(clonar);
            fim = System.currentTimeMillis();
            long HSQuase = fim - inicio;
            System.out.println("\ndecrescente...\n");
            clonar = Decrescente.clone();
            inicio = System.currentTimeMillis();
            HS.sort(clonar);
            fim = System.currentTimeMillis();
            long HSDecres = fim - inicio;

            // ------------------------------------------ SHELLSORT
            System.out.print("\nShellSorting desordenado...");
            clonar = Desordenado.clone();
            inicio = System.currentTimeMillis();
            SS.sort(clonar);
            fim = System.currentTimeMillis();
            long SSDes = fim - inicio;
            System.out.print("\nquase ordenado...");
            clonar = QuaseOrdenado.clone();
            inicio = System.currentTimeMillis();
            SS.sort(clonar);
            fim = System.currentTimeMillis();
            long SSQuase = fim - inicio;
            System.out.println("\ndecrescente...\n");
            clonar = Decrescente.clone();
            inicio = System.currentTimeMillis();
            SS.sort(clonar);
            fim = System.currentTimeMillis();
            long SSDecres = fim - inicio;

            //-------------------------------------------------- RADIXSORT
            System.out.print("\nRadixSorting desordenado...");
            clonar = Desordenado.clone();
            inicio = System.currentTimeMillis();
            RS.sort(clonar);
            fim = System.currentTimeMillis();
            long RSDes = fim - inicio;
            System.out.print("\nquase ordenado...");
            clonar = QuaseOrdenado.clone();
            inicio = System.currentTimeMillis();
            RS.sort(clonar);
            fim = System.currentTimeMillis();
            long RSQuase = fim - inicio;
            System.out.println("\ndecrescente...\n");
            inicio = System.currentTimeMillis();
            clonar = Decrescente.clone();
            RS.sort(clonar);
            fim = System.currentTimeMillis();
            long RSDecres = fim - inicio;

            //-------------------------------------------------- MERGESORT
            System.out.print("\nMergeSorting desordenado...");
            clonar = Desordenado.clone();
            inicio = System.currentTimeMillis();
            MS.sort(clonar);
            fim = System.currentTimeMillis();
            long MSDes = fim - inicio;
            System.out.print("\nquase ordenado...");
            clonar = QuaseOrdenado.clone();
            inicio = System.currentTimeMillis();
            MS.sort(clonar);
            fim = System.currentTimeMillis();
            long MSQuase = fim - inicio;
            System.out.println("\ndecrescente...\n");
            clonar = Decrescente.clone();
            inicio = System.currentTimeMillis();
            MS.sort(clonar);
            fim = System.currentTimeMillis();
            long MSDecres = fim - inicio;

            //------------------------------------------------ SMOOTHSORT
            System.out.print("\nSmoothSorting desordenado...");
            clonar = Desordenado.clone();
            inicio = System.currentTimeMillis();
            SMS.sort(clonar);
            fim = System.currentTimeMillis();
            long SMSDes = fim - inicio;
            System.out.print("\nquase ordenado...");
            clonar = QuaseOrdenado.clone();
            inicio = System.currentTimeMillis();
            SMS.sort(clonar);
            fim = System.currentTimeMillis();
            long SMSQuase = fim - inicio;
            System.out.println("\ndesordenado...\n");
            clonar = Decrescente.clone();
            inicio = System.currentTimeMillis();
            SMS.sort(clonar);
            fim = System.currentTimeMillis();
            long SMSDecres = fim - inicio;

            //------------------------------------------------ Relatório de pesquisas
            System.out.println("\nPesquisas: " + resposta);
            System.out.println("\n   Tipo    | Quase ordenado | Desordenado | Ordem decrescente |");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Quicksort  |      "+ tempo(QSQuase)+"     |    "+ tempo(QSDes)+"    |       "+ tempo(QSDecres)+"       | ");
            System.out.println("Heapsort   |      "+ tempo(HSQuase)+"     |    "+ tempo(HSDes)+"    |       "+ tempo(HSDecres)+"       | ");
            System.out.println("Shellsort  |      "+ tempo(SSQuase)+"     |    "+ tempo(SSDes)+"    |       "+ tempo(SSDecres)+"       | ");
            System.out.println("RadixSort  |      "+ tempo(RSQuase)+"     |    "+ tempo(RSDes)+"    |       "+ tempo(RSDecres)+"       | ");
            System.out.println("Mergesort  |      "+ tempo(MSQuase)+"     |    "+ tempo(MSDes)+"    |       "+ tempo(MSDecres)+"       | ");
            System.out.println("Smoothsort |      "+ tempo(SMSQuase)+"     |    "+ tempo(SMSDes)+"    |       "+ tempo(SMSDecres)+"       | \n");
        }
    }

    public static double tempo(long x){
        double seg = x/1000.0;
        return seg;
    }
}
