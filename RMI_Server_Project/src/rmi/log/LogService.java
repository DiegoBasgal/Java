package rmi.log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LogService {

	public void logar(Log log) {
		String fileName = fileName();
		try (FileOutputStream out = new FileOutputStream(fileName, Boolean.TRUE)) {
			out.write(log.logAsStr().getBytes());
			out.write("\n".getBytes());
			out.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String fileName() {
		String basePath = System.getProperty("user.dir");
		String s = File.separator;
		return basePath + s + "src" + s + "logs" + s + "logs.txt";
	}
	
	public List<Log> getLogs() {
		List<Log> logsResult = new ArrayList<Log>();
		try {
			List<String> listLogs = Files.readAllLines(Paths.get(fileName()));
			listLogs.forEach(s -> logsResult.add(new LogFactory().newInstanceFromLinha(s)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return logsResult;
	}
	
}
