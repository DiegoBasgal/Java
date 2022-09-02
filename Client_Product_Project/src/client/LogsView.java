package client;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class LogsView extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private DesktopView desktop;
	
	private JButton btnVisualizarLogs;
	private JButton btnVisualizarTime;
	private JButton btnEditarTime;
	
	public LogsView(DesktopView desktop) {
		super("Logs", Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE);
		this.desktop = desktop;
		setSize(new Dimension(500, 300));
		setLayout(new GridLayout(3, 1));
		configButtons();
	}

	private void configButtons() {
		this.btnVisualizarLogs = new JButton("Visualizar Logs");
		this.btnVisualizarLogs.addActionListener(e -> {
			LogView view = new LogView();
			LogsView.this.desktop.add(view);
			view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			view.setVisible(Boolean.TRUE);
		});
		
		add(this.btnVisualizarLogs);
		
		this.btnVisualizarTime = new JButton("Visualizar Time");
		this.btnVisualizarTime.addActionListener(e -> {
			VisualizaTimeView view = new VisualizaTimeView();
			LogsView.this.desktop.add(view);
			view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			view.setVisible(Boolean.TRUE);
		});
		add(this.btnVisualizarTime);
		
		
		this.btnEditarTime = new JButton("Editar Time");
		this.btnEditarTime.addActionListener(e -> {
			EditaTimeView view = new EditaTimeView();
			LogsView.this.desktop.add(view);
			view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			view.setVisible(Boolean.TRUE);
		});
		add(this.btnEditarTime);
	}
	
	
	
	
}
