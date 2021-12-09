package com.Cruds;

import java.io.File;
import java.io.IOException;

public class FileUtils {

	// ATRIBUTOS
	public static int contador = 0;

	// NO NECESITO CONSTRUCTORES PORQUE NO VOY A INSTANCIAR OBJETOS
	// SE TRATA DE UNA CLASE ESTATICA QUE SOLO OFRECE FUNCIONALIDAD

	/************************** METODOS ***************************/

	public static boolean pathValidator(File f) throws IOException {

		boolean result = false;
		String path = f.getAbsolutePath();
		String archivo = path.substring(path.lastIndexOf(File.separator));

		if (f.exists()) {

			result = true;
			System.out.print("EL FICHERO EXISTE");

			if (f.canRead()) {
				System.out.println(" Y SE PUEDE LEER");
			} else {
				System.out.println(" PERO NO SE PUEDE LEER");
			}
			System.out.println("SU RUTA ES: " + path);

		} else if (f.getParentFile() != null && f.getParentFile().exists() && f.getParentFile().isDirectory()) {

			System.out.println("EL ARCHIVO NO EXISTE, PERO LA RUTA ES CORRECTA");
			System.out.println("SE VA A CREAR UN ARCHIVO CON EL NOMBRE QUE HA INDICADO: " + archivo);
			if (f.createNewFile()) {
				System.out.println("ARCHIVO " + archivo + " CREADO CON EXITO");
				result = true;
			} else {
				System.out.println("EL ARCHIVO YA EXISTE");
			}

		} else {
			System.out.println("EL FICHERO NO EXISTE, PRUEBE INDICANDO OTRA RUTA");
		}

		return result;
	}

	// CREAR DIRECTORIO
	public static void crearDir(File directorio, String nombreDir) {
		File resultado = new File(directorio, nombreDir);
		if (!resultado.exists()) {
			resultado.mkdir();
		} else {
			System.out.println("EL DIRECTORIO YA EXISTE");
		}
	}

	// CREAR ARCHIVO/FICHERO
	public static void crearFichero(File directorio, String nombreDir) throws IOException {
		File resultado = new File(directorio, nombreDir);
		if (!resultado.exists()) {
			resultado.createNewFile();
		} else {
			System.out.println("EL NOMBRE DEL ARCHIVO YA EXISTE DENTRO DE ESTE DIRECTORIO");
		}
	}

	public static boolean compruebaFicheroSimpleImpl(File file) {
		return (file.exists() && file.canRead()) ? true : false;
	}
	
	public static boolean compruebaFichero(File file) {
		boolean result = false;
		if (file.exists() && file.canRead()) {
			return result = true;
		}
		return result;
	}

	// RENOMBRAR
	public static void renombrar(File directorio, String nombreDir, String nuevoNombre) {
		File resultado = new File(directorio, nombreDir);
		if (resultado.exists()) {
			if (resultado.canWrite()) {
				resultado.renameTo(new File(directorio, nuevoNombre));
				System.out.println("RENOMBRADO CON EXITO");
			} else {
				System.out.println("NO TIENE PERMISOS DE ESCRITURA");
			}
		} else {
			System.out.println("NO SE PUEDE RENOMBRAR LO QUE NO EXISTE");
		}
	}

	// ELIMINAR
	public static void eliminar(File directorio, String nombreDir) {
		File resultado = new File(directorio, nombreDir);
		if (resultado.exists()) {
			if (resultado.canWrite()) {
				resultado.delete();
				System.out.println("BORRADO CON EXITO");
			} else {
				System.out.println("NO TIENE PERMISOS DE ESCRITURA");
			}
		} else {
			System.out.println("NO SE PUEDE BORRAR LO QUE NO EXISTE");
		}
	}

	// MOSTRAR POR PANTALLA ELEMENTOS DE LA LISTA
	public static void printLista(File[] lista) {
		System.out.println("\nFICHEROS ENCONTRADOS: \n");

		// CON UN FOR EACH
		for (File elemento : lista) {
			System.out.println(elemento.getName());
			contador++;
		}
		System.out.println("\n" + FileUtils.contador + " ELEMENTOS\n");

		// CON UN FOR CONVENCIONAL
//		for (int i = 0; i < lista.length; i++) {
//			System.out.println(lista[i].getName());
//			contador++;
//		}
//		System.out.println("\n" + FileUtils.contador + " ELEMENTOS\n");

		// CON UN WHILE
//		int j = 0;
//		while (j < lista.length) {
//			System.out.println(lista[j].getName());
//			j++;
//			contador++;
//		}
//		System.out.println("\n" + FileUtils.contador + " ELEMENTOS\n");

	}

}
