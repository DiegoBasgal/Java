public class Conjuges extends Pessoa{

    public Conjuges(String nome, String cpf, char sexo, boolean necessidadeEspecial) {
        super(nome, cpf, sexo, necessidadeEspecial);
    }
    
    public String andarAltar (){
        return "Os cônjuges andaram até o altar";
    }
    
    public String fazerDiscurso (){
        return "Os cônjuges fizeram seu discurso";
    }
    
    public String trocarAliança (){
        return "Os cônjuges trocaram as alianças";
    }
    
    public String aceitar (){
        return "Os cônjuges estão casados";
    }
    
}
