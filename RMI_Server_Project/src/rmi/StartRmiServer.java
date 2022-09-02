package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartRmiServer {

	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		
		System.out.println("Publicando Objeto Remoto de Pesquisa de Produtos");
		Registry register = LocateRegistry.createRegistry(1099);
		register.bind("PesquisaProduto", new PesquisaProdutoImpl());
		
	}
	
}
