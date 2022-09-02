public class Turma {
    
    private int matricula;
    private char nome;
    private String dataInicio;
    private String dataFim;
    private int limiteTurma;
    private Aluno aluno;
    private Professor professor;
    
    public Turma (int matricula, char nome, String dataInicio, String dataFim, int limiteTurma, Aluno aluno, Professor professor){
        this.matricula = matricula;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.limiteTurma = limiteTurma;
        this.aluno = aluno;
        this.professor = professor;
    }
    
    public void setMatricula (int novaMatricula){
        this.matricula = novaMatricula;
    }
    
    public void setNome (char novoNome){
        this.nome = novoNome;
    }
    
    public void setDataInicio (String novaDataInicio){
        this.dataInicio = novaDataInicio;
    }
    
    public void setDataFim (String novaDataFim){
        this.dataFim = novaDataFim;
    }
    
    public void setLimiteTurma (int novoLimiteTurma){
        this.limiteTurma = novoLimiteTurma;
    }
    
    public void setAluno (Aluno novoAluno){
        this.aluno = novoAluno;
    }
    
    public void setProfessor (Professor novoProfessor){
        this.professor = novoProfessor;
    }
    
    public int getMatricula (){
        return this.matricula;
    }
    
    public char getNome (){
        return this.nome;
    }
        
    public String getDataInicio (){
        return this.dataInicio;
    }
            
    public String getDataFim (){
        return this.dataFim;
    }
                
    public int getLimiteTurma (){
        return this.limiteTurma;
    }
    
    public Aluno getAluno (){
        return this.aluno;
    } 
    
    public Professor getProfessor (){
        return this.professor;
    }
}
