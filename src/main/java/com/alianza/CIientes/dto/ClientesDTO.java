package com.alianza.CIientes.dto;

import java.sql.Date;

public class ClientesDTO {
	
   private String nombre;
	
	private String sharedkey;
	
	private String telefono;
	
	private String email;
	
	private java.sql.Date fecha_inicio;
	
	private java.sql.Date fecha_fin;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSharedkey() {
		return sharedkey;
	}

	public void setSharedkey(String sharedkey) {
		this.sharedkey = sharedkey;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.sql.Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(java.sql.Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public java.sql.Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(java.sql.Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public ClientesDTO(String nombre, String sharedkey, String telefono, String email, Date fecha_inicio,
			Date fecha_fin) {
		super();
		this.nombre = nombre;
		this.sharedkey = sharedkey;
		this.telefono = telefono;
		this.email = email;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}
	
	
	
	
	
}
