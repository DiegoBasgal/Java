public class Pagem extends Convidados{

    public Pagem(String nome, String cpf, char sexo, boolean necessidadeEspecial) {
        super(nome, cpf, sexo, necessidadeEspecial);
    }
    
    public String levaAliança (){
        return "O pagem está levando as alianças";
    }
    
}
