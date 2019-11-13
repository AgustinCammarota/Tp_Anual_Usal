package edu.usal.negocio.dominio;

import java.io.Serializable;


public class Telefonos implements Serializable  {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String numeroPersonal, numeroCelular, numeroLaboral;
private Long idTelefono = null;

public Telefonos() {}

public Telefonos(String numeroPersonal, String numeroCelular, String numeroLaboral, Long idTelefono) {
	super();
	this.numeroPersonal = numeroPersonal;
	this.numeroCelular = numeroCelular;
	this.numeroLaboral = numeroLaboral;
	this.idTelefono = idTelefono;
}

public String getNumeroPersonal() {
	return numeroPersonal;
}

public void setNumeroPersonal(String numeroPersonal) {
	this.numeroPersonal = numeroPersonal;
}

public String getNumeroCelular() {
	return numeroCelular;
}

public void setNumeroCelular(String numeroCelular) {
	this.numeroCelular = numeroCelular;
}

public String getNumeroLaboral() {
	return numeroLaboral;
}

public void setNumeroLaboral(String numeroLaboral) {
	this.numeroLaboral = numeroLaboral;
}

public Long getIdTelefono() {
	return idTelefono;
}

public void setIdTelefono(Long idTelefono) {
	this.idTelefono = idTelefono;
}

@Override
public String toString() {
	return "Telefonos [numeroPersonal=" + numeroPersonal + ", numeroCelular=" + numeroCelular + ", numeroLaboral="
			+ numeroLaboral + ", idTelefono=" + idTelefono + "]";
}

}
