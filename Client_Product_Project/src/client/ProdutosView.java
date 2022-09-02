package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import rmi.PesquisaProduto;
import server.produto.Produto;

public class ProdutosView extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lblNomeProdutoPequisa;
	private JTextField txtNomeProdutoPesquisa;
	private JButton btnPesquisar;
	private JTable tblProdutos;
	
	public ProdutosView() {
		super("Pesquisa de produtos", Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
		setSize(new Dimension(800, 600));
		configCampos();
		configTableModel();
	}

	private void configTableModel() {
		this.tblProdutos = new JTable(new ProdutoTableModel(new ArrayList<Produto>()));
		add(new JScrollPane(this.tblProdutos));
	}

	private void configCampos() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		this.lblNomeProdutoPequisa = new JLabel("Produto");
		panel.add(this.lblNomeProdutoPequisa);
		
		this.txtNomeProdutoPesquisa = new JTextField(30);
		panel.add(this.txtNomeProdutoPesquisa);
		
		this.btnPesquisar = new JButton("Pesquisar");
		this.btnPesquisar.addActionListener(e -> {
			executarPesquisa();
		});
		panel.add(this.btnPesquisar);
		
		add(panel, BorderLayout.NORTH);
		
	}
	
	private void executarPesquisa() {
		PesquisaProduto pesquisa;
		try {
			pesquisa = (PesquisaProduto) Naming.lookup("rmi://127.0.0.1:1099/PesquisaProduto");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new RuntimeException(e);
		}
		List<Produto> listProdutos;
		try {
			listProdutos = pesquisa.pesquisarProdutoContemNome(this.txtNomeProdutoPesquisa.getText().trim());
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		}
		this.tblProdutos.setModel(new ProdutoTableModel(listProdutos));		
	}

	public static void main(String[] args) {
		 EventQueue.invokeLater(() -> {
			 ProdutosView view = new ProdutosView();
			 view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 view.setVisible(Boolean.TRUE);
		 });
	}
	
}
