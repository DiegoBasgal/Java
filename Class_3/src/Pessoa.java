public class Pessoa {
    private String nome;
    private String cpf;
    private String rg;
    
    public Pessoa(String nome, String cpf, String rg){
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }
    
    public void setNome(String novoNome){
        this.nome = novoNome;
    }
    
    public String getNome(){
        return this.nome;
    }
}
