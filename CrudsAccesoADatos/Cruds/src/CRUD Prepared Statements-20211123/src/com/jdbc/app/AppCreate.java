package com.jdbc.app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AppCreate {

	public static void main(String[] args) {
		try {
			// 1.-CARGAR EL DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver"); // "org.mariadb.jdbc.Driver"
			// 2.-ESTABLECER CONEXIÓN CON LA BASE DE DATOS
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:33060/empresa_simple","root",""); //"jdbc:mariadb://localhost:33060/NOMBRE_BASE_DATOS", "root", ""
			// 3.-PREPARAR LA CONSULTA A LA BASE DE DATOS
			String query = "INSERT INTO empleados VALUES (null,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conexion.prepareStatement(query);
			// 4.-DEFINIR PARAMETROS ?
			preparedStatement.setString(1, "Victor");
			preparedStatement.setString(2, "Vuestro Profe");
			preparedStatement.setString(3, "soyVictor@gmail.com");
			preparedStatement.setString(4, "2369");
			preparedStatement.setString(5, "profesor");
			preparedStatement.setDate(6, Date.valueOf(LocalDate.of(1986, 05, 11)));
			preparedStatement.setDouble(7, 2500.50);
			preparedStatement.setInt(8, 30);
			// 5.-EJECUTAR SENTENCIA (DML) SQL
			int filas = preparedStatement.executeUpdate();
			// 6.-COMPROBACIÓN DE CORRECTA EJECUCIÓN
			if(filas>0) {
				System.out.println("USUARIO REGISTRADO CORRECTAMENTE");
			}
			// 7.-CERRAMOS LAS CONEXIONES
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
