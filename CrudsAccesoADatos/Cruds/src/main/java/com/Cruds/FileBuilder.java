package com.Cruds;

import java.io.File;
import java.io.IOException;


public class FileBuilder {

	public static File build() {
		// PIDO PATH POR TECLADO
		String path = JOptionpaneUtility.readString("INTRODUCE UN PATH: ","");
		File file = new File(path);
		try {
			while (!FileUtils.pathValidator(file)) {
				
				path = JOptionpaneUtility.readString("INTRODUCE UN NUEVO PATH: ","");
				file = new File(path);
			}
		} catch (IOException e) {
			LogsUtility.WriteLog(e);;
		}
		return file;
	}

}
