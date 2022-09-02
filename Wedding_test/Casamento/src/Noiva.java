public class Noiva extends Conjuges{

    public Noiva(String nome, String cpf, char sexo, boolean necessidadeEspecial) {
        super(nome, cpf, sexo, necessidadeEspecial);
    }

    @Override
    public String andarAltar (){
        return "A noiva está andando até o altar";
    }
    
    @Override
    public String fazerDiscurso (){
        return "A noiva fez seu discurso";
    }
    
    public String jogarBuque (){
        return "A noiva jogou seu buquê";
    }
    
}
