package com.Cruds.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "empleados")
public class Empleados {

	private List<Empleado> listaEmpleados;

	public Empleados() {
		super();
	}

	public Empleados(List<com.Cruds.jaxb.Empleado> list) {
		super();
		this.listaEmpleados = list;
	}

	@XmlElement(name="elemento")
	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	

}
