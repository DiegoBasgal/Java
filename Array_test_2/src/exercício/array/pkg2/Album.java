package exercício.array.pkg2;
import java.util.ArrayList;

public class Album {
    
    private String nomeAlbum;
    private String genero;
    private int ano;
    private String artista;
    public ArrayList<Musica> musica;
    
    
    public Album(String nomeAlbum, String genero, int ano, String artista){
        
        this.nomeAlbum = nomeAlbum;
        this.genero = genero;
        this.ano = ano;
        this.artista = artista;
        this.musica = new ArrayList<Musica>();
    }
    
    public void setNomeAlbum (String nomeAlbum){
        this.nomeAlbum = nomeAlbum;
    }
    
    public void setGenero (String genero){
        this.genero = genero;
    }
    
    public void setAno (int ano){
        this.ano = ano;
    }
    
    public void setArtista (String artista){
        this.artista = artista;
    }
    
    public void addMusica(Musica musica){
        this.musica.add(musica);
    }
    
    public String getNomeAlbum (){
        return this.nomeAlbum;
    }
    
    public String getGenero (){
        return this.genero;
    }
    
    public int getAno (){
        return this.ano;
    }
    
    public String getArtista (){
        return this.artista;
    }
}
