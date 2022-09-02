public class DamadeHonra extends Convidados{

    public DamadeHonra(String nome, String cpf, char sexo, boolean necessidadeEspecial) {
        super(nome, cpf, sexo, necessidadeEspecial);
    }
    
    public String levaAliança (){
        return "A Dama de Honra está levando as alianças";
    }
    
    public String jogaFlores (){
        return "A Dama de Honra está jogando pétalas de rosa";
    }
    
}
