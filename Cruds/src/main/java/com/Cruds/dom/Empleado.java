package com.Cruds.dom;

import java.io.Serializable;

public class Empleado implements Serializable {

	private static final long serialVersionUID = 2193149158675802186L;
	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	private double salario;

	public Empleado() {
		super();
	}

	public Empleado(int id, String nombre, String apellidos, int edad, double salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad
				+ ", salario=" + salario + "]";
	}

}
