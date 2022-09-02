import java.util.Arrays;
import java.util.Objects;

public class KDC {
    private Pessoa[] usuarios;

    public KDC(Pessoa[] usuarios){
        this.usuarios = usuarios;
    }

    public static String getChaveSessao(){
        int tamanho = 16;
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "0123456789" +
                "abcdefghijklmnopqrstuvxyz";
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < tamanho; ++i) {
            int indice = (int)(caracteres.length() * Math.random());
            key.append(caracteres.charAt(indice));
        }
        return key.toString();
    }

    public String decifraDestinatario(byte[] cifra){
        String destinatario = new String();
        try{
            for(int i = 0; i < usuarios.length; i++){
                byte [] comparar = AES.cifra(usuarios[i].getID(), usuarios[i].getK_mestre());

                if (Arrays.equals(cifra, comparar)){
                    destinatario = AES.decifra(cifra, usuarios[i].getK_mestre());
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return destinatario;
    }

    public boolean GerarChaveSessao(String id, byte[] idCifrado, byte[] destinatarioCifrado) {
        try {
            for (Pessoa pessoa : usuarios) {
                if (id.equals(pessoa.getID())) {
                    String novoID = AES.decifra(idCifrado, pessoa.getK_mestre());

                    if (id.equals(novoID)) {
                        String destinatario = decifraDestinatario(destinatarioCifrado);

                        for (Pessoa usuario : usuarios) {
                            if (destinatario.equals(usuario.getID())) {
                                System.out.println("Destinatário encontrado... \n");

                                String chaveSessao = getChaveSessao();
                                byte[] k_s_remetente = AES.cifra(chaveSessao, pessoa.getK_mestre());
                                byte[] k_s_destinatario = AES.cifra(chaveSessao, usuario.getK_mestre());
                                byte[][] chave_r_d = {k_s_remetente, k_s_destinatario};

                                int nonceDes = usuario.gerarNonce();
                                //System.out.println("Nonce gerado de " + usuario.getID() + ": " + nonceDes);

                                byte[] nonceDesCif = AES.cifra(String.valueOf(nonceDes), chaveSessao);
                                //System.out.println("Nonce cifrado que " + usuario.getID() + " enviou para " + pessoa.getID() + ": " + String.valueOf(nonceDes));

                                int novoNonce = FuncaoAutenticacao.funcaoDesRem(Integer.parseInt(String.valueOf(nonceDes)));

                                //System.out.println("Novo nonce gerado de " + usuario.getID() + ": " + novoNonce);

                                int aux = FuncaoAutenticacao.funcaoDesRem(Integer.parseInt(AES.decifra(nonceDesCif, chaveSessao)));

                                if (!Objects.equals(novoNonce, aux)) {
                                    System.out.println("O processo de validação do nonce falhou!");
                                } else {
                                    System.out.println("Nonce validado com sucesso!");
                                }
                            }
                        }
                        break;
                    } else {
                        System.out.println("A autenticação falhou!");
                    }
                }
            }
        }catch (Exception e) {
            System.out.println("Algo deu errado");
        }
        return true;
    }
}

