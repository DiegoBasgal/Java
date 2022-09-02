import java.util.Scanner;

public class Exercício1 {
    
    public static void main(String[] args) {
    
        int i;
        for (i = 2; i <= 200; i = i + 2){
               System.out.println(i);
        }
        
        /*Professor p = new Professor (000000000, "Marcos", "Rua das Flores 90", "33333333");
        Aluno a = new Aluno (111111111, "Pedro", "999999999");
        Turma t = new Turma (222222222, 'a', "01/01/2018", "01/12/2018", 30, a, p);*/
    
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("Digite a matrícula do professor:");
        int matriculaProf = entrada.nextInt();
        
        System.out.print("Digite o nome do professor:");
        String nomeProf = entrada.nextLine();

        System.out.print("Digite o endereço do professor:");
        String enderecoProf = entrada.nextLine();
        
        System.out.print("Digite o telefone do professor:");
        String telefoneProf = entrada.nextLine();
        
        Professor p = new Professor (matriculaProf, nomeProf, enderecoProf, telefoneProf);
        
        System.out.print("Digite a matrícula do aluno:");
        int matriculaAluno = entrada.nextLine();
        
        System.out.print("Digite o nome do aluno:");
        String nomeAluno = entrada.nextLine();
        
        System.out.print("Digite o celular do aluno:");
        String celularAluno = entrada.nextLine();
        
        Aluno a = new Aluno (matriculaAluno, nomeAluno, celularAluno);
        
        System.out.print("Digite a matrícula da tumra:");
        int matriculaTurma = entrada.nextInt();
        
        System.out.print("Digite o nome da turma:");
        char nomeTurma = entrada.next().charAt(0);
       
        System.out.print("Digite a data inicail das aulas:");
        String dataInicio = entrada.nextLine();
        
        System.out.print("Digite a data final das aulas:");
        String dataFim = entrada.nextLine();
        
        System.out.print("Digite o limite da turma:");
        int limiteTurma = entrada.nextInt();
        
        Turma t = new Turma (matriculaTurma, nomeTurma, dataInicio, dataFim, limiteTurma, a, p);
        
    }
    
}