package com.Cruds.jaxb;

import java.util.ArrayList;
import java.util.Random;


public class DatosPrueba {

	/**
	 * ATRIBUTOS
	 */
	private static int id = 0;
	private static String nombres[] = { "Antonio", "Luis Miguel", "Alicia", "Pedro", "Manuel", "Andres", "Julio",
			"Jeronimo", "Maria Jesus", "Victor", "Fermin", "Alvaro", "Benedicto" };
	private static String apellidos[] = { "Garcia", "Exposito", "Lebron", "Morales", "Pedrosa", "Ibanez", "Romero",
			"Benameji", "Fernandez", "Borbon", "Sanchez", "Iglesias" };
	private static Random aleatorio = new Random();

	/**
	 * FUNCIONALIDAD PARA GENERAR EMPLEADOS COMO CHURROS
	 * 
	 * @return
	 */
	public static Empleado creaEmpleado() {

		Empleado emple = new Empleado();
		emple.setId(id++);
		emple.setNombre(nombres[aleatorio.nextInt(nombres.length)]);
		emple.setApellidos(
				apellidos[aleatorio.nextInt(apellidos.length)] + " " + apellidos[aleatorio.nextInt(apellidos.length)]);
		emple.setEdad(18 + aleatorio.nextInt(66 - 18));
		emple.setSalario(900.00 + (1000 * aleatorio.nextDouble()));
		return emple;

	}

	public static ArrayList<Empleado> crearListaEmpleados(int numEmpleados) {

		ArrayList<Empleado> listaEmpleados = new ArrayList<>();
		Empleado emple = null;

		for (int i = 0; i < numEmpleados; i++) {
			emple = creaEmpleado();
			listaEmpleados.add(emple);
		}

		return listaEmpleados;

	}

}
