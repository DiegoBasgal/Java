package client;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DesktopView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenuBar barraMenus;
	
	public DesktopView() {
		setTitle("Logs");
		setSize(new Dimension(800, 600));
		setContentPane(new JDesktopPane());
		configBarraMenus();
	}

	private void configBarraMenus() {
		this.barraMenus = new JMenuBar();
		setJMenuBar(this.barraMenus);
		
		JMenu menuSistema = new JMenu("Sistema");
		this.barraMenus.add(menuSistema);
		
		JMenuItem itemPesquisa = new JMenuItem("Pesquisa");
		itemPesquisa.addActionListener(e -> {
			ProdutosView view = new ProdutosView();
			DesktopView.this.add(view);
			view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			view.setVisible(Boolean.TRUE);
		});
		menuSistema.add(itemPesquisa);
		
		JMenuItem itemLogs = new JMenuItem("Logs");
		itemLogs.addActionListener(e ->{
			LogsView view = new LogsView(DesktopView.this);
			DesktopView.this.add(view);
			view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			view.setVisible(Boolean.TRUE);
		});
		
		menuSistema.add(itemLogs);
		
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			DesktopView view = new DesktopView();
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setVisible(Boolean.TRUE);
		});
	}
	
}
