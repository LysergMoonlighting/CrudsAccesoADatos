package com.jdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppSearchByParams {

	public static void main(String[] args) {
		try {
			// 1.-CARGAR EL DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver"); // "org.mariadb.jdbc.Driver"
			// 2.-ESTABLECER CONEXIÓN CON LA BASE DE DATOS
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:33060/empresa_simple","root",""); //"jdbc:mariadb://localhost:33060/NOMBRE_BASE_DATOS", "root", ""
			// 3.-PREPARAR LA CONSULTA A LA BASE DE DATOS
			Statement stm = conexion.createStatement();
			String usuario = "rufi@atsistemas.com";
			String password = "soyelfuckinboss";
			//SIMULACION ATAQUE SQL INJECTION
//			String usuario = "' OR '1'='1";
//			String password = "' OR '2'='2";
			String query = "SELECT * FROM empleados WHERE empleados.email='"+usuario+"' AND empleados.pass='"+password+"'";
			ResultSet rs = stm.executeQuery(query);
			
			boolean acceso = false;

			while(rs.next()) {
				acceso = true;
				System.out.println("CONTRASEÑA CORRECTA, ACCESO CONCEDIDO");
				System.out.println("-------------------------------------");
				System.out.println("id: " + rs.getInt(1) + "\tnombre: "+ rs.getString(2) + "\tapellidos: "+ rs.getString(3) 
				+ "\tusuario: "+ rs.getString(4) + "\tpassword: "+ rs.getString(5) + "\tsalario: "+ rs.getDouble("salario") + "\n\n");
			}
			
			if(!acceso) {
				System.out.println("CONTRASEÑA INCORRECTA");
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
