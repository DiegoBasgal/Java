public class Padre extends Pessoa{
    
    public Padre (String nome, String cpf, char sexo, boolean necessidadeEspecial){
        super(nome, cpf, sexo, necessidadeEspecial);
    }
    
    public String rezaMissa(){
        return "O padre está rezando a missa";
    }
}
