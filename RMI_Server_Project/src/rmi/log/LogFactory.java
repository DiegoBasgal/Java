package rmi.log;

import java.util.Date;

public class LogFactory {

	public Log newInstanceFromLinha(String log) {
		String[] array = log.split(";");
		return new Log(Integer.valueOf(array[0]), new Date(Long.valueOf(array[1])), array[2]);
	}
	
}
