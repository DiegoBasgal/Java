package rmi.log;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Date data;
	private String pesquisa;

	public Log(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Log(Integer id, Date data, String msg) {
		this.id = id;
		this.data = data;
		this.pesquisa = msg;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String logAsStr() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.id.toString());
		builder.append(";");
		builder.append(this.data.getTime());
		builder.append(";");
		builder.append(this.pesquisa);
		return builder.toString();
	}

}
