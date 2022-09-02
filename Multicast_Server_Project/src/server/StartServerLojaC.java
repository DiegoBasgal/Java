package server;

public class StartServerLojaC {

	public static void main(String[] args) {
		ProdutoServer server = new ProdutoServer(5555, "224.0.0.1", "Loja C");
		server.iniciar();	
	}
	
}
