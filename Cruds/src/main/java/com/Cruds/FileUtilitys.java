
package com.Cruds;

import java.io.File;
import java.io.IOException;


public class FileUtilitys {

	public static void CreateDir(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	public static void CreateFile(String path) {
		String filename=fileWithExtension();
		File file = new File(path+File.separator+filename);
		if (!file.exists()) {
			try {
				
				if(file.createNewFile()) {
					JOptionpaneUtility.mensage("El archivo "+filename+" ha sido creado con exito", "Archivo creado");
				}else {
					JOptionpaneUtility.error("El archivo no ha podido ser creado", "Fallo al crear");
				}
				
			} catch (IOException e) {
				
				LogsUtility.WriteLog(e);
			}
			
		}else {
			JOptionpaneUtility.error("El archivo que esta intentado crear ya existe", "Archivo ya existente");
		}
	}

	public static String path() {
		String path = JOptionpaneUtility.readString("Introduzca la ruta","Ruta");
		String[] answers = { "Si", "No" };
		String answer;
		File file = new File(path);
		if (!file.exists()) {
			answer = JOptionpaneUtility.bottonsString("La ruta actual no existe /n" + "Desea crearla?", "No existe",
					answers);
			if(answer=="Si") {
				CreateDir(path);
			}

		}

		return path;
	}

	public static String extension() {
		String[] format = { ".txt", ".log", ".pdf",".xml",".data" };
		String extension = JOptionpaneUtility.bottonsString("¿Que formato va a tener tu archivo?", "Formato", format);
		return extension;
	}

	public static String fileWithExtension() {
		String filename = JOptionpaneUtility.readString("Introduzca el nombre del archivo","nombre") + extension();
		return filename;
	}
	/*
	public static String archivos() {
		String[] bottons= {"Guardar","Abrir"};
		String[] format = { "txt", "log", "pdf","xml","data" };
		int caso =JOptionpaneUtility.bottons("Que desea hacer?", "Que desea hacer", bottons);
		
		Display display = new Display();
		Shell shell = new Shell(display);
		FileDialog dialog=new FileDialog(shell);

		shell.open();
		switch (caso) {
		case 1:
			dialog= new FileDialog(shell, SWT.SAVE);
			break;
		case 2:
			dialog = new FileDialog(shell, SWT.OPEN);
			break;
			
			
		}
		
		
		String[] filterExtensions = new String[] { "*."+format};
		String filterPath = "/";
		String platform = SWT.getPlatform();
		if (platform.equals("win32")) {
			//filterNames = new String[] { "All Files (*)" };
			//filterExtensions = new String[] { "*" };
			filterPath = "c:\\";
		}
		dialog.setFilterNames(format);
		dialog.setFilterExtensions(filterExtensions);
		dialog.setFilterPath(filterPath);
		dialog.setFileName("myfile");

		String salida = dialog.open();

		display.dispose();

		return salida;
	}
	
	
	*/
	
}
