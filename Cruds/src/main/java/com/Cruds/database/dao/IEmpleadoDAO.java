package com.Cruds.database.dao;


import java.util.List;

import com.Cruds.database.entities.Empleado;

public interface IEmpleadoDAO {
	List<Empleado> selectAll();
	Empleado selectById(int id);
	int insert(Empleado emp);
	int update(Empleado emp);
	int delete(Empleado emp);
}
