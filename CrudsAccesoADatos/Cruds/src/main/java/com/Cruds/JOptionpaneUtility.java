//@autor Jose Manuel Almagro Dominguez
package com.Cruds;

import javax.swing.JOptionPane;

public class JOptionpaneUtility {
	public static int readInt(String mensage,String title) {
		int numberRead = 0;
		boolean check = false;
		while (!check) {
			try {
				numberRead = Integer
						.parseInt(JOptionPane.showInputDialog(null, mensage, title, JOptionPane.INFORMATION_MESSAGE));
				check = true;

			} catch (NumberFormatException e) {
				error("El valor ingresado no es un número , o no ha introducido nada", "Error de datos");
				LogsUtility.WriteLog(e);
			}

		}
		return numberRead;
	}

	public static long readLong(String mensage,String title) {
		long numberRead = 0L;
		boolean check = false;
		while (!check) {

			try {
				numberRead = Long.parseLong(
						JOptionPane.showInputDialog(null, mensage, title, JOptionPane.INFORMATION_MESSAGE));
				check = true;

			} catch (NumberFormatException e) {
				error("El valor ingresado no es un número , o no ha introducido nada", "Error de datos");
				LogsUtility.WriteLog(e);
			}
		}
		return numberRead;
	}

	public static double readDouble(String mensage,String title) {
		double numberRead = 0;
		boolean check = false;
		while (!check) {
			try {
				numberRead = Double.parseDouble(
						JOptionPane.showInputDialog(null, mensage, title, JOptionPane.INFORMATION_MESSAGE));
				check = true;
			} catch (NumberFormatException e) {
				error("El valor ingresado no es un número , o no ha introducido nada", "Error de datos");

			}
		}
		return numberRead;
	}

	public static char readChar(String mensage ,String title) {
		char charRead;
		String stringRead = "";
		boolean check = false;
		while (!check) {
			stringRead = JOptionPane.showInputDialog(null, mensage, title, JOptionPane.INFORMATION_MESSAGE);
			if (stringRead.length() < 1) {
				error("Almenos introduzca un caracter", "Error de datos");
			} else {
				check = true;
			}
		}
		char parseaChar[] = stringRead.toCharArray();
		charRead = parseaChar[0];
		return charRead;
	}

	public static String readString(String mensage ,String title) {

		String stringRead = "";
		boolean check = false;
		while (!check) {
			stringRead = JOptionPane.showInputDialog(null, mensage, title, JOptionPane.INFORMATION_MESSAGE);
			if (stringRead.length() < 1) {
				error("Almenos introduzca un caracter", "Error de datos");

			} else {
				check = true;
			}
		}

		return stringRead;
	}

	public static int bottons(String mensage, String tittle, String[] options) {

		int election = JOptionPane.showOptionDialog(null, mensage, tittle, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		return election;

	}
	public static String bottonsString(String mensage, String tittle, String[] options) {

		int election = JOptionPane.showOptionDialog(null, mensage, tittle, JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		return options[election];

	}

	public static void mensage(String mensage, String tittle) {
		JOptionPane.showMessageDialog(null, mensage, tittle, JOptionPane.INFORMATION_MESSAGE);

	}

	public static void error(String mensage, String tittle) {
		JOptionPane.showMessageDialog(null, mensage, tittle, JOptionPane.ERROR_MESSAGE);
	}

	public static void exit() {
		JOptionPane.showMessageDialog(null, "Hasta laproxima", "Gracias por usar", 0, null);

	}
}
