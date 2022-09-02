
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        
        EntradaDados in = new EntradaDados();
        System.out.print("Número: ");
        try{
            int numInt = in.leInteiros();
        }
        catch(NullPointerException npe){
            System.out.println("ERRO: Nenhum número encontrado");
        }
        catch(InputMismatchException ime){
            System.out.println("ERRO: O caractere não coincide com seu tipo(INT)");
        }
    }
}
