import java.util.ArrayList;

public class Casamento {
    private String local;
    private String data;
    private String hora;
    private ArrayList <Convidados> listaConvidados;
    private ArrayList <Padrinhos> listaPadrinhos;
    private ArrayList <Madrinhas> listaMadrinhas;
    private Padre infoPadre;
    private Noivo infoNoivo;
    private Noiva infoNoiva;
    private Pagem infoPagem;
    private DamadeHonra infodamadehonra;

    public Casamento(String local, String data, String hora, Padre infoPadre, Noivo infoNoivo, Noiva infoNoiva, Pagem infoPagem, DamadeHonra infodamadehonra) {
        this.local = local;
        this.data = data;
        this.hora = hora;
        this.infoPadre = infoPadre;
        this.infoNoivo = infoNoivo;
        this.infoNoiva = infoNoiva;
        this.infoPagem = infoPagem;
        this.infodamadehonra = infodamadehonra;
        this.listaConvidados = new ArrayList <Convidados> ();
        this.listaPadrinhos = new ArrayList <Padrinhos> ();
        this.listaMadrinhas = new ArrayList <Madrinhas> ();
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public ArrayList<Convidados> getListaConvidados() {
        return listaConvidados;
    }

    public void setListaConvidados(ArrayList<Convidados> listaConvidados) {
        this.listaConvidados = listaConvidados;
    }

    public ArrayList<Padrinhos> getListaPadrinhos() {
        return listaPadrinhos;
    }

    public void setListaPadrinhos(ArrayList<Padrinhos> listaPadrinhos) {
        this.listaPadrinhos = listaPadrinhos;
    }

    public ArrayList<Madrinhas> getListaMadrinhas() {
        return listaMadrinhas;
    }

    public void setListaMadrinhas(ArrayList<Madrinhas> listaMadrinhas) {
        this.listaMadrinhas = listaMadrinhas;
    }

    public Padre getInfoPadre() {
        return infoPadre;
    }

    public void setInfoPadre(Padre infoPadre) {
        this.infoPadre = infoPadre;
    }

    public Noivo getInfoNoivo() {
        return infoNoivo;
    }

    public void setInfoNoivo(Noivo infoNoivo) {
        this.infoNoivo = infoNoivo;
    }

    public Noiva getInfoNoiva() {
        return infoNoiva;
    }

    public void setInfoNoiva(Noiva infoNoiva) {
        this.infoNoiva = infoNoiva;
    }

    public Pagem getInfoPagem() {
        return infoPagem;
    }

    public void setInfoPagem(Pagem infoPagem) {
        this.infoPagem = infoPagem;
    }

    public DamadeHonra getInfodamadehonra() {
        return infodamadehonra;
    }

    public void setInfodamadehonra(DamadeHonra infodamadehonra) {
        this.infodamadehonra = infodamadehonra;
    }
    
    public void addConvidados (Convidados convidados){
        this.listaConvidados.add(convidados);
    }
    
    public void addPadrinhos (Padrinhos padrinhos){
        this.listaConvidados.add(padrinhos);
    }
    
    public void addMadrinhas (Madrinhas madrinhas){
        this.listaConvidados.add(madrinhas);
    }
}


