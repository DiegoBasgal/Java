package client;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import rmi.log.Log;

public class LogTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Log> listLogs;
	
	public LogTableModel(List<Log> listLogs) {
		this.listLogs = listLogs;
	}

	@Override
	public int getRowCount() {
		return this.listLogs.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Log log = this.listLogs.get(rowIndex);
		if(columnIndex == 0)return log.getId();
		if(columnIndex == 1)return log.getData();
		if(columnIndex == 2)return log.getPesquisa();
		return null;
	}

	@Override
	public String getColumnName(int column) {
		if(column == 0)return "ID";
		if(column == 1)return "Data";
		if(column == 2)return "Pesquisa";
		return null;
	}
	
}
