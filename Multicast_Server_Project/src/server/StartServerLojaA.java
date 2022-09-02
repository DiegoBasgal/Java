package server;

public class StartServerLojaA {

	public static void main(String[] args) {
		ProdutoServer server = new ProdutoServer(5555, "224.0.0.1", "Loja A");
		server.iniciar();	
	}
	
}
