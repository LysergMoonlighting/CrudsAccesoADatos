package com.Cruds.database.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.Cruds.LogsUtility;
import com.Cruds.database.controller.DataBaseController;
import com.Cruds.database.entities.Empleado;



public class EmpleadoDAOImpl implements IEmpleadoDAO, Serializable {

	DataBaseController dbController;

	@Override
	public List<Empleado> selectAll() {
		List<Empleado> empleadoList = null;

		dbController = DataBaseController.getInstance();
		dbController.open();
		try {
			String query = "SELECT * FROM empleado";
			ResultSet rs = dbController.select(query);

			while (rs.next()) {
				empleadoList.add(new Empleado(rs.getInt("id_emple"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("email"), rs.getString("pass"), rs.getString("puesto"),
						rs.getDate("fecha_alta").toLocalDate(), rs.getLong("salario"), rs.getString("depto")));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogsUtility.WriteLog(e);
		}
		dbController.close();
		return empleadoList;
	}

	@Override
	public Empleado selectById(int id) {
		Empleado empleado = null;

		dbController = DataBaseController.getInstance();
		dbController.open();
		try {
			String query = "SELECT * FROM empleado WHERE id_emple= ?";
			ResultSet rs = dbController.select(query, id);

			if (rs.next()) {
				empleado = (new Empleado(rs.getInt("id_emple"), rs.getString("nombre"), rs.getString("apellidos"),
						rs.getString("email"), rs.getString("pass"), rs.getString("puesto"),
						rs.getDate("fecha_alta").toLocalDate(), rs.getLong("salario"), rs.getString("depto")));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			LogsUtility.WriteLog(e);
		}
		dbController.close();
		return empleado;
	}

	@Override
	public int insert(Empleado emp) {
		int filas = 0;

		dbController = DataBaseController.getInstance();
		dbController.open();
		String query = "INSERT INTO empleados VALUES (null,?,?,?,?,?,?,?,?)";
		filas = dbController.update(query, emp.getNombre(), emp.getApellidos(), emp.getEmail(), emp.getPassword(),
				emp.getPuesto(), LocalDate.now(), emp.getSalario(), emp.getDepartamento());
		dbController.close();
		return filas;
	}

	@Override
	public int update(Empleado emp) {
		int filas = 0;

		dbController = DataBaseController.getInstance();
		dbController.open();
		String query = "UPDATE empleados SET nombre=?, apellidos=?, email=?, "
				+ "pass=?, puesto=?, fecha_alta=?, "
				+ "salario=?, depto=? WHERE id_emple=?";
		filas = dbController.update(query, emp.getNombre(), emp.getApellidos(), emp.getEmail(), emp.getPassword(),
				emp.getPuesto(), emp.getFechaAlta(), emp.getSalario(), emp.getDepartamento(), emp.getId());
		dbController.close();
		return filas;
	}

	@Override
	public int delete(Empleado emp) {
		int filas = 0;

		dbController = DataBaseController.getInstance();
		dbController.open();
		String query = "DELETE FROM empleados WHERE id_emple";
		filas = dbController.update(query, emp.getId());
		dbController.close();
		return filas;
	}

}
