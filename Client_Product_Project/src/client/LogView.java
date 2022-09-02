package client;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import rmi.PesquisaProduto;
import rmi.log.Log;

public class LogView extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JTable tblLogs;
	
	public LogView() {
		super("Logs", Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
		setSize(new Dimension(600, 400));
		configJTableLogs();
	}

	private void configJTableLogs() {
		PesquisaProduto pesquisa;
		try {
			pesquisa = (PesquisaProduto) Naming.lookup("rmi://127.0.0.1:1099/PesquisaProduto");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RuntimeException(e);
		}
		List<Log> logs;
		try {
			logs = pesquisa.consultarLogs();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
		this.tblLogs = new JTable(new LogTableModel(logs));
		add(new JScrollPane(this.tblLogs));
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() ->{
			LogView view = new LogView();
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setVisible(Boolean.TRUE);
		});
	}
}
