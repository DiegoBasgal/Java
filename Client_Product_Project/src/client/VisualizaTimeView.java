package client;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import rmi.PesquisaProduto;

public class VisualizaTimeView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblTime;
	private JLabel lblValue;
	
	public VisualizaTimeView() {
		super("Time", Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE);
		setSize(new Dimension(200, 75));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		configTime();
	}

	private void configTime() {
		this.lblTime = new JLabel("Time: ");
		add(this.lblTime);
		
		PesquisaProduto pesquisa;
		try {
			pesquisa = (PesquisaProduto) Naming.lookup("rmi://127.0.0.1:1099/PesquisaProduto");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RuntimeException(e);
		}
		int time;
		try {
			time = pesquisa.consultarTime();
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
		this.lblValue = new JLabel(String.valueOf(time));
		add(this.lblValue);
	}

}
