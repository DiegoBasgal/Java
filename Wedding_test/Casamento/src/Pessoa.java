public class Pessoa {
    private String nome;
    private String cpf;
    private char sexo;
    private boolean necessidadeEspecial;
    
    public Pessoa (String nome, String cpf, char sexo, boolean necessidadeEspecial){
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.necessidadeEspecial = necessidadeEspecial;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public boolean isNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    public void setNecessidadeEspecial(boolean necessidadeEspecial) {
        this.necessidadeEspecial = necessidadeEspecial;
    }
}
