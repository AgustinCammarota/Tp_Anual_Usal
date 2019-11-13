package edu.usal.negocio.dominio;

import java.io.Serializable;

public class Direcciones implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String calle, altura, ciudad, codigoPostal;
private Paises pais;
private Provincias provincia;
private Long idDireccion = null;

public Direcciones () {}

public Direcciones(String calle, String altura, String ciudad, String codigoPostal, Paises pais, Provincias provincia,
		Long idDireccion) {
	super();
	this.calle = calle;
	this.altura = altura;
	this.ciudad = ciudad;
	this.codigoPostal = codigoPostal;
	this.pais = pais;
	this.provincia = provincia;
	this.idDireccion = idDireccion;
}

public String getCalle() {
	return calle;
}

public void setCalle(String calle) {
	this.calle = calle;
}

public String getAltura() {
	return altura;
}

public void setAltura(String altura) {
	this.altura = altura;
}

public String getCiudad() {
	return ciudad;
}

public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}

public String getCodigoPostal() {
	return codigoPostal;
}

public void setCodigoPostal(String codigoPostal) {
	this.codigoPostal = codigoPostal;
}

public Paises getPais() {
	return pais;
}

public void setPais(Paises pais) {
	this.pais = pais;
}

public Provincias getProvincia() {
	return provincia;
}

public void setProvincia(Provincias provincia) {
	this.provincia = provincia;
}

public Long getIdDireccion() {
	return idDireccion;
}

public void setIdDireccion(Long idDireccion) {
	this.idDireccion = idDireccion;
}

@Override
public String toString() {
	return "Direcciones [calle=" + calle + ", altura=" + altura + ", ciudad=" + ciudad + ", codigoPostal="
			+ codigoPostal + ", pais=" + pais.toString() + ", provincia=" + provincia.toString() + ", idDireccion=" + idDireccion + "]";
}

}
