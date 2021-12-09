package com.Cruds.database.entities;

import java.time.LocalDate;


public class Empleado {
	private int id;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private String puesto;
	private LocalDate fechaAlta;
	private long salario;
	private String departamento;

	public Empleado() {

	}

	public Empleado(int id, String nombre, String apellidos, String email, String password, String puesto,
			LocalDate fechaAlta, long salario, String departamento) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.puesto = puesto;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.departamento = departamento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public long getSalario() {
		return salario;
	}

	public void setSalario(long salario) {
		this.salario = salario;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", puesto=" + puesto + ", fechaAlta=" + fechaAlta + ", salario=" + salario
				+ ", departamento=" + departamento + "]";
	}

}
