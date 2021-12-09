package com.jdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AppUpdate {

	public static void main(String[] args) {
		try {
			// 1.-CARGAR EL DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver"); // "org.mariadb.jdbc.Driver"
			// 2.-ESTABLECER CONEXIÓN CON LA BASE DE DATOS
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:33060/empresa_simple","root",""); //"jdbc:mariadb://localhost:33060/NOMBRE_BASE_DATOS", "root", ""
			// 3.-PREPARAR LA CONSULTA A LA BASE DE DATOS
			String query = "UPDATE empleados "
							+ "SET nombre = ? "
							+ "WHERE empleados.id_emple = ?";
			PreparedStatement preparedStatement = conexion.prepareStatement(query);
			// 4.-DEFINIR PARAMETROS ?
			preparedStatement.setString(1, "Victor");
			preparedStatement.setInt(2, 1);
			// 5.-EJECUTAR SENTENCIA (DML) SQL
			int filas = preparedStatement.executeUpdate();
			// 6.-COMPROBACIÓN DE CORRECTA EJECUCIÓN
			if(filas>0) {
				System.out.println("USUARIO ACTUALIZADO CORRECTAMENTE");
			}else {
				System.out.println("EL USUARIO QUE DESEA BORRAR NO EXISTE");
			}
			// 7.-CERRAMOS LA CONEXION
			preparedStatement.close();
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
