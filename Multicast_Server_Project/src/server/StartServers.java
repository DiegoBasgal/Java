package server;

public class StartServers {

    public static void main(String[] args) {

        System.out.println("Start Server Produtos Loja A");
        new Thread(() -> {
            ProdutoServer server = new ProdutoServer(5555, "224.0.0.1", "Loja A");
            server.iniciar();
        }).start();

        System.out.println("Start Server Produtos Loja B");
        new Thread(() -> {
            ProdutoServer server = new ProdutoServer(5555, "224.0.0.1", "Loja B");
            server.iniciar();
        }).start();

        System.out.println("Start Server Produtos Loja C");
        new Thread(() -> {
            ProdutoServer server = new ProdutoServer(5555, "224.0.0.1", "Loja C");
            server.iniciar();
        }).start();

    }

}
