package com.jdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppReadBuscar {

	public static void main(String[] args) {
		try {
			// 1.-CARGAR EL DRIVER
			Class.forName("com.mysql.cj.jdbc.Driver"); // "org.mariadb.jdbc.Driver"
			// 2.-ESTABLECER CONEXIÓN CON LA BASE DE DATOS
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:33060/empresa_simple","root",""); //"jdbc:mariadb://localhost:33060/NOMBRE_BASE_DATOS", "root", ""
			// 3.-PREPARAR LA CONSULTA A LA BASE DE DATOS
			String query = "SELECT * FROM empleados WHERE email=? AND pass=?";
			PreparedStatement ps = conexion.prepareStatement(query);
			// 4.-DEFINIR PARAMETROS ?
			String usuario = "rufi@atsistemas.com";
			String password = "soyelfuckinboss";
			ps.setString(1, usuario);
			ps.setString(2, password);
			// 5.-EJECUTAR SENTENCIA (DML) SQL
			ResultSet rs = ps.executeQuery(); //SOLO TENDREMOS RESULTSET CUANDO SEAN CONSULTAS QUE TRAEN COMO RESULTADOS FILAS
			// 6.-ITERAMOS LOS RESULTADOS DEL RESULTSET HASTA QUE NO TENGA MÁS FILAS QUE LEER (hasNext() == false (no tiene siguiente))
			while(rs.next()) {
				System.out.println("id: " + rs.getInt(1) + "\tnombre: "+ rs.getString(2) + "\t\tapellidos: "+ rs.getString(3) 
				+ "\t\tfecha de alta: "+ rs.getDate(7) + "\t\tsalario: "+ rs.getDouble("salario"));
			}
			// 7.-CERRAMOS LA CONEXION
			rs.close();
			ps.close();
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
