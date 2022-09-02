package exercício.array.pkg2;
import java.util.ArrayList;

public class ExercícioArray2 {

    public static void main(String[] args) {
        
        Album album = new Album("Battle of Los Angeles", "Punk Rock", 1999, "Rage Against The Machine");
        
        Musica m1 = new Musica("Testify", 3.31);
        Musica m2 = new Musica("Gerrilla Radio", 3.26);
        Musica m3 = new Musica("Calm Like A Bomb", 4.59);
        Musica m4 = new Musica("Mic Chick", 3.34);
        Musica m5 = new Musica("Sleep Now In The Fire", 3.26);
        Musica m6 = new Musica("Born A Broken Man", 4.41);
        Musica m7 = new Musica("Born As Ghosts", 3.22);
        Musica m8 = new Musica("Maria", 3.48);
        Musica m9 = new Musica("Voice Of The Voiceless", 2.32);
        Musica m10 = new Musica("New Millenium Homes", 3.45);
        Musica m11 = new Musica("Ashes In The Fall", 4.37);
        Musica m12 = new Musica("War Within A Breath", 3.37);
        
        album.addMusica(m1);
        album.addMusica(m2);
        album.addMusica(m3);
        album.addMusica(m4);
        album.addMusica(m5);
        album.addMusica(m6);
        album.addMusica(m7);
        album.addMusica(m8);
        album.addMusica(m9);
        album.addMusica(m10);
        album.addMusica(m11);
        album.addMusica(m12);
        
        System.out.println("Album: " + album.getNomeAlbum());
        System.out.println("Gênero: " + album.getGenero());
        System.out.println("Ano: " + album.getAno());
        System.out.println("Artista: " + album.getArtista() + "\n");
        
        for (int i = 0; i < album.musica.size(); i++){
            System.out.println("Musica: " + album.musica.get(i).getTitulo());
            System.out.println("Duração: " + album.musica.get(i).getDuracao() + "\n");
        }
        
    }
    
}
