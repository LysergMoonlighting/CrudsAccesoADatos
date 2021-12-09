package com.jdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppReadAll {

	public static void main(String[] args) {
		try {
			// 1.-CARGAR EL DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver"); // "org.mariadb.jdbc.Driver"
			// 2.-ESTABLECER CONEXIÓN CON LA BASE DE DATOS
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:33060/empresa_simple","root",""); //"jdbc:mariadb://localhost:33060/NOMBRE_BASE_DATOS", "root", ""
			// 3.-PREPARAR LA CONSULTA A LA BASE DE DATOS
			Statement stm = conexion.createStatement();
			String query = "SELECT * FROM empleados";
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
//				System.out.printf("%d, %s, %s \n", rs.getInt(1), rs.getString(2), rs.getString(3));
				System.out.println("id: " + rs.getInt(1) + "\tnombre: "+ rs.getString(2) + "\t\tapellidos: "+ rs.getString(3) 
				+ "\t\tfecha de alta: "+ rs.getDate(7) + "\t\tsalario: "+ rs.getDouble("salario"));
			}
			
			// 4.-CERRAMOS LA CONEXION
			rs.close();
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
