public class Album {
    private String genero;
    private int ano;
    private String nome;
    private Pessoa artista;
    private Musica musica;
    
    public Album(String genero, int ano, String nome, Pessoa a, Musica m){
        this.genero = genero;
        this.ano = ano;
        this.nome = nome;
        this.artista = a;
        this.musica = m;
    }
}
