package client;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import server.produto.Produto;

public class ProdutoTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Produto> produtos;
	
	public ProdutoTableModel(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int getRowCount() {
		return this.produtos.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Produto produto = this.produtos.get(rowIndex);
		if(columnIndex == 0)return produto.getLoja();
		if(columnIndex == 1)return produto.getNome();
		if(columnIndex == 2)return produto.getValor();
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if(column == 0)return "Loja";
		if(column == 1)return "Nome";
		if(column == 2)return "Valor";
		return null;
	}

}
