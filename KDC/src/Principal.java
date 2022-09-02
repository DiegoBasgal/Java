import java.util.Arrays;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            Pessoa bob = new Pessoa("bob", "bolabolabolabola");
            Pessoa alice = new Pessoa("alice", "gatogatogatogato");
            Pessoa[] usuarios = new Pessoa[2];
            usuarios[0] = bob;
            usuarios[1] = alice;

            KDC kdc = new KDC(usuarios);

            System.out.print("Login: ");
            String login = sc.nextLine();
            System.out.print("Senha: ");
            String senha = sc.nextLine();

            for (Pessoa pessoa : usuarios) {
                if (login.equals(pessoa.getID()) && senha.equals(pessoa.getK_mestre())) {

                    String parametro1 = pessoa.getID();
                    byte[] parametro2 = AES.cifra(pessoa.getID(), pessoa.getK_mestre());
                    System.out.println("\n" + "Bem vindo " + parametro1);
                    System.out.println("Seu ID de sessão é:" + Arrays.toString(parametro2) + "\n");

                    System.out.print("Iniciar conversa com: ");
                    String chat = sc.nextLine();

                    for (Pessoa usuario : usuarios) {
                        if (chat.equals(usuario.getID())) {
                            byte[] parametro3 = AES.cifra(usuario.getID(), usuario.getK_mestre());
                            if(kdc.GerarChaveSessao(parametro1, parametro2, parametro3)) {
                                System.out.print("\nDigite sua mensagem: ");
                                String msg = sc.nextLine();

                                byte[] textoRemCif = AES.cifra(msg, pessoa.getK_mestre());
                                System.out.print("\nTexto cifrado enviado para " + usuario.getID() + ": ");
                                AES.Imprimir(textoRemCif);

                                byte[] textoDesCif = AES.cifra(Arrays.toString(textoRemCif), usuario.getK_mestre());
                                System.out.print("\nTexto cifrado recebido de: " + pessoa.getID());
                                AES.Imprimir(textoDesCif);

                                String aux = AES.decifra(textoDesCif, usuario.getK_mestre());

                                if(aux.equals(Arrays.toString(textoRemCif))) {
                                    String textoFinal = AES.decifra(textoRemCif, pessoa.getK_mestre());
                                    System.out.println("\nTexto decifrado recebido por " + usuario.getID() + " de " + pessoa.getID() +": ");
                                    AES.Imprimir(textoFinal);
                                }
                            }
                        }
                    }
                } else {
                    System.out.println();
                }
            }
        }catch (Exception e){
            System.out.println("Alguma coisa deu errado na main");
        }
    }
}
