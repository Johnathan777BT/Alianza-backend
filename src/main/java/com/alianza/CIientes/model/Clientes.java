package com.alianza.CIientes.model;


import java.sql.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "clientes")
public class Clientes {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "comer-uuid")
	@SequenceGenerator(name = "comer-uuid", allocationSize = 1, sequenceName = "SEQ_CLIENTES")
	private long id;
	
	
	private String telefono;
	
	@NotNull
	@NotEmpty
	private String nombre;
	
	
	private String sharedkey;
	
	
	@Email(message = "Invalid email address")
	@Column(nullable = false, length = 50, unique = true)
	@Email @Length(min = 5, max = 50)
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "es-CO", timezone = "America/Bogota")
	private Date fechainicio;
	
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", locale = "es-CO", timezone = "America/Bogota")
	private Date fechafin;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

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

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Clientes(long id, String telefono, @NotNull @NotEmpty String nombre, @NotNull @NotEmpty String sharedkey,
			@NotNull Date fechainicio, @NotNull Date fechafin,  String email) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.nombre = nombre;
		this.sharedkey = sharedkey;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.email = email;
	}
	
	
	public Clientes() {}
	
	
}
