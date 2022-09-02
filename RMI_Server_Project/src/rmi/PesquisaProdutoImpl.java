package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.List;

import rmi.log.Log;
import rmi.log.LogService;
import rmi.time.Time;
import server.produto.Produto;

public class PesquisaProdutoImpl extends UnicastRemoteObject implements PesquisaProduto {

	private static final long serialVersionUID = 1L;

	protected PesquisaProdutoImpl() throws RemoteException {
		super();
	}

	@Override
	public List<Produto> pesquisarProdutoContemNome(String nome) {
		new LogService().logar(new Log(1, Calendar.getInstance().getTime(), nome == null || nome.trim().isEmpty() ? "Todos" : nome));
		MultiCastClient client = new MultiCastClient(5555, "224.0.0.1", Time.instance().getValue());
		List<Produto> produtos = client.pesquisar(nome);
		return produtos;
	}

	@Override
	public List<Log> consultarLogs() throws RemoteException {
		return new LogService().getLogs();
	}

	@Override
	public int consultarTime() throws RemoteException {
		return Time.instance().getValue();
	}

	@Override
	public void configTime(int time) throws RemoteException {
		Time.instance().setValue(time);
	}

}
