package com.Cruds.database.services;

import org.json.JSONObject;

import com.Cruds.database.entities.Empleado;

public interface IEmpleadoService {
	JSONObject getAll();
	JSONObject getById(int id);
	int save(Empleado emp);
	int modify(Empleado emp);
	int delete(int id);
}
