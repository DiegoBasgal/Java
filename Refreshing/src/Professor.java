public class Professor {
    
    private int matricula;
    private String nome;
    private String endereco;
    private String telefone;
    
    public Professor (int matricula, String nome, String enderco, String telefone){
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public void setMatricula (int novaMatricula){
        this.matricula = novaMatricula;
        // Pode colocar sem o THIS quando mudar o nome da variavel.
    }
    
    public void setNome (String novoNome){
        this.nome = novoNome;
    }
    
    public void setEndereco (String novoEndereco){
        this.endereco = novoEndereco;
    }
    
    public void setTelefone (String novoTelefone){
        this.telefone = novoTelefone;
    }
    
    public int getMatricula (){
        return this.matricula;
    }
    
    public String getNome (){
        return this.nome;
    }
    
    public String getEnderco (){
        return this.endereco;
    }
    
    public String getTelefone (){
        return this.telefone;
    }
    
}
