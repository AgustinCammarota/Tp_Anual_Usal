package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.time.LocalDate;

public  class Clientes implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String nombre, apellido, dni, cuit, email;
private LocalDate fechaNacimiento;
private Long idCliente = null;
private Pasaportes pasaporte;
private Telefonos telefono;
private PasajerosFrecuentes pasajerofrecuente;
private Direcciones direccion;

public Clientes () {}

public Clientes(String nombre, String apellido, String dni, String cuit, String email, LocalDate fechaNacimiento,
		Long idCliente, Pasaportes pasaporte, Telefonos telefono, PasajerosFrecuentes pasajerofrecuente,
		Direcciones direccion) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.dni = dni;
	this.cuit = cuit;
	this.email = email;
	this.fechaNacimiento = fechaNacimiento;
	this.idCliente = idCliente;
	this.pasaporte = pasaporte;
	this.telefono = telefono;
	this.pasajerofrecuente = pasajerofrecuente;
	this.direccion = direccion;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getDni() {
	return dni;
}

public void setDni(String dni) {
	this.dni = dni;
}

public String getCuit() {
	return cuit;
}

public void setCuit(String cuit) {
	this.cuit = cuit;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public LocalDate getFechaNacimiento() {
	return fechaNacimiento;
}

public void setFechaNacimiento(LocalDate fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}

public Long getIdCliente() {
	return idCliente;
}

public void setIdCliente(Long idCliente) {
	this.idCliente = idCliente;
}

public Pasaportes getPasaporte() {
	return pasaporte;
}

public void setPasaporte(Pasaportes pasaporte) {
	this.pasaporte = pasaporte;
}

public Telefonos getTelefono() {
	return telefono;
}

public void setTelefono(Telefonos telefono) {
	this.telefono = telefono;
}

public PasajerosFrecuentes getPasajerofrecuente() {
	return pasajerofrecuente;
}

public void setPasajerofrecuente(PasajerosFrecuentes pasajerofrecuente) {
	this.pasajerofrecuente = pasajerofrecuente;
}

public Direcciones getDireccion() {
	return direccion;
}

public void setDireccion(Direcciones direccion) {
	this.direccion = direccion;
}

@Override
public String toString() {
	return "Clientes [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", cuit=" + cuit + ", email="
			+ email + ", fechaNacimiento=" + fechaNacimiento + ", idCliente=" + idCliente + ", pasaporte=" + pasaporte.toString()
			+ ", telefono=" + telefono.toString() + ", pasajerofrecuente=" + pasajerofrecuente.toString() + ", direccion=" + direccion.toString() + "]";
}

}
