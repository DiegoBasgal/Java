public class Noivo extends Conjuges{

    public Noivo(String nome, String cpf, char sexo, boolean necessidadeEspecial) {
        super(nome, cpf, sexo, necessidadeEspecial);
    }
    
    @Override
    public String andarAltar (){
        return "O noivo está andando até o altar";
    }
    
    @Override
    public String fazerDiscurso (){
        return "O noivo fez seu discurso";
    }
    
    public String beijarNoiva (){
        return "Já pode beijar a noiva";
    }
    
}
