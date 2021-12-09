
package com.Cruds;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

public class LogsUtility {

	public static void WriteLog(Exception error) {
		String path = "."+File.separator+"logs"+File.separator;
		FileUtilitys.CreateDir(path);

		Logger logger = Logger.getLogger(LogsUtility.class.getName());// solo es para identificar.
		FileHandler fh = null;
		try {

			fh = new FileHandler(path + "logs.log", true);// el true del final es para que no sobrescriba lo que ya
															// estaba
			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
			logger.setUseParentHandlers(false);// esto es para que no salga por consola el error.
			logger.log(Level.INFO, String.valueOf(error.getClass()), error);

		} catch (SecurityException e) {
			WriteLog(e);
		} catch (IOException e) {
			WriteLog(e);
		}
		fh.close(); // hace falta cerrarlo porque si no va creando mas y mas archivos

	}

}
