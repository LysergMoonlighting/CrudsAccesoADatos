package com.jdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppCreate {

	public static void main(String[] args) {
		try {
			// 1.-CARGAR EL DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver"); // "org.mariadb.jdbc.Driver"
			// 2.-ESTABLECER CONEXIÓN CON LA BASE DE DATOS
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:33060/empresa_simple","root",""); //"jdbc:mariadb://localhost:33060/NOMBRE_BASE_DATOS", "root", ""
			// 3.-PREPARAR LA CONSULTA A LA BASE DE DATOS
			Statement stm = conexion.createStatement();
			String query = "INSERT INTO empleados "
					+ "(nombre, apellidos, email, pass, puesto, fecha_alta, salario, depto) "
					+ "VALUES ('PEPE','PEPIN PONPAN','pepito@metocael.com','pinpanpum','Portero','2016-02-01','1111','Chico pa to')";
			int filas = stm.executeUpdate(query);
			
			if(filas>0) {
				System.out.println("USUARIO REGISTRADO CORRECTAMENTE");
			}
			
			// 4.-CERRAMOS LA CONEXION
			stm.close();
			conexion.close();
			
		} catch (ClassNotFoundException e) {
			System.err.println("NO SE ENCUENTRA LA CLASE PARA EL DRIVER INDICADO");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("NO SE PUEDE CONECTAR CON LA BASE DE DATOS");
			e.printStackTrace();
		} 

	}
}
