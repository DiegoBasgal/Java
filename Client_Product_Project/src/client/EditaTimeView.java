package client;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import rmi.PesquisaProduto;

public class EditaTimeView extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblTime;
	private JTextField txtValue;
	private JButton btnConfirmar;
	
	public EditaTimeView() {
		super("Time", Boolean.TRUE,Boolean.TRUE,Boolean.TRUE,Boolean.TRUE);
		setSize(new Dimension(350, 75));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		configTime();
	}

	private void configTime() {
		
		this.lblTime = new JLabel("Time: ");
		add(this.lblTime);
		
		this.txtValue = new JTextField(15);
		add(this.txtValue);
		
		this.btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.addActionListener(ev -> {
			if(!validarForm())return;
			PesquisaProduto pesquisa;
			try {
				pesquisa = (PesquisaProduto) Naming.lookup("rmi://127.0.0.1:1099/PesquisaProduto");
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				throw new RuntimeException(e);
			}	
			try {
				pesquisa.configTime(Integer.valueOf(EditaTimeView.this.txtValue.getText().trim()));
			} catch (NumberFormatException | RemoteException e) {
				throw new RuntimeException(e);
			}
			JOptionPane.showMessageDialog(EditaTimeView.this, "Timer atualizado com sucesso!!!");
		});
		add(this.btnConfirmar);
		
	}

	private boolean validarForm() {
		if(this.txtValue.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(EditaTimeView.this, "Informe um novo time");
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
