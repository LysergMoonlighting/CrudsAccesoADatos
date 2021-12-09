package com.Cruds.database.services;

import java.util.List;

import org.json.JSONObject;

import com.Cruds.database.dao.EmpleadoDAOImpl;
import com.Cruds.database.entities.Empleado;

public class EmpleadoServiceImpl implements IEmpleadoService {

	// dependencia
	EmpleadoDAOImpl empleDAO = new EmpleadoDAOImpl();

	@Override
	public JSONObject getAll() {
		JSONObject jsonRequest = new JSONObject();
		List<Empleado> listEmpleGetJSON=null;
		
		listEmpleGetJSON= empleDAO.selectAll();
		
		return null;
	}

	@Override
	public JSONObject getById(int id) {
		JSONObject jsonRequest = new JSONObject();
		Empleado empleDTO = empleDAO.selectById(id);
		if (empleDTO != null) {
			jsonRequest.put("id", empleDTO.getId());
			jsonRequest.put("nombre", empleDTO.getNombre());
			jsonRequest.put("apellidos", empleDTO.getApellidos());
			jsonRequest.put("email", empleDTO.getEmail());
			jsonRequest.put("password", empleDTO.getPassword());
			jsonRequest.put("puesto", empleDTO.getPuesto());
			jsonRequest.put("fecha de alta", empleDTO.getFechaAlta());
			jsonRequest.put("salario", empleDTO.getSalario());
			jsonRequest.put("departamento", empleDTO.getDepartamento());
			return jsonRequest;
		}
		return null;
	}

	@Override
	public int save(Empleado empleDTO) {
		// peticion http tipo put
		return empleDAO.insert(empleDTO);
	}

	@Override
	public int modify(Empleado empleDTO) {
		// peticion http tipo patch o put
		Empleado emplModify = empleDAO.selectById(empleDTO.getId());
		if (emplModify != null) {
			return empleDAO.update(emplModify);
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		// peticion http tipo delete
		Empleado emplModify = empleDAO.selectById(id);
		if (emplModify != null) {
			return empleDAO.delete(emplModify);
		}
		return 0;
	}

}
