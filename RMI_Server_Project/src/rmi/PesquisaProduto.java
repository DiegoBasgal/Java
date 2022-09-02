package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import rmi.log.Log;
import server.produto.Produto;

public interface PesquisaProduto extends Remote {

	List<Produto> pesquisarProdutoContemNome(String nome) throws RemoteException;
	
	List<Log> consultarLogs() throws RemoteException;
	
	int consultarTime() throws RemoteException;
	
	void configTime(int time) throws RemoteException;
}
