public class Aluno {
    
    private int matricula;
    private String nome;
    private String celular;
    
    public Aluno (int matricula, String nome, String celular){
        this.matricula = matricula;
        this.nome = nome;
        this.celular = celular;
    }
    
    public void setMatricula (int novaMatricula){
        this.matricula = novaMatricula;
    }
    
    public void setNome (String novoNome){
        this.nome = novoNome;
    }
    
    public void setCelular (String novoCelular){
        this.celular = novoCelular;
    }
    
    public int getMatricula (){
        return this.matricula;
    }
    
    public String getNome (){
        return this.nome;
    }
    
    public String getCelular (){
        return this.celular;
    }
}
