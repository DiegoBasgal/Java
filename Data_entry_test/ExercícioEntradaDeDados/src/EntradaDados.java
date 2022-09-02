import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDados {
    
    public int leInteiros() throws NullPointerException, InputMismatchException{
        Scanner si = new Scanner(System.in);
        int numInt = si.nextInt();
        return numInt;
    }
    
    public double leDouble() throws Exception{
        Scanner sd = new Scanner(System.in);
        double numDouble = sd.nextDouble();
        return numDouble;
    }
    
    public String leString() throws Exception{
        Scanner ss = new Scanner(System.in);
        String string = ss.toString();
        return string;
    }
    
    public char leChar() throws Exception{
        Scanner sc = new Scanner(System.in);
        char caractere = sc.next().charAt(0);
        return caractere;
    }
}
