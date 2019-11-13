package edu.usal.negocio.dominio;

import java.io.Serializable;

public class Aeropuertos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPais, idProvincia, idAeropuerto;
	private Paises pais;
	private Provincias provincia;
	private String codigoAeropuerto, ciudad;
	
public Aeropuertos() {}

public Aeropuertos(int idPais, int idProvincia, int idAeropuerto, Paises pais, Provincias provincia,
		String codigoAeropuerto, String ciudad) {
	super();
	this.idPais = idPais;
	this.idProvincia = idProvincia;
	this.idAeropuerto = idAeropuerto;
	this.pais = pais;
	this.provincia = provincia;
	this.codigoAeropuerto = codigoAeropuerto;
	this.ciudad = ciudad;
}

public int getIdPais() {
	return idPais;
}

public void setIdPais(int idPais) {
	this.idPais = idPais;
}

public int getIdProvincia() {
	return idProvincia;
}

public void setIdProvincia(int idProvincia) {
	this.idProvincia = idProvincia;
}

public int getIdAeropuerto() {
	return idAeropuerto;
}

public void setIdAeropuerto(int idAeropuerto) {
	this.idAeropuerto = idAeropuerto;
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

public String getCodigoAeropuerto() {
	return codigoAeropuerto;
}

public void setCodigoAeropuerto(String codigoAeropuerto) {
	this.codigoAeropuerto = codigoAeropuerto;
}

public String getCiudad() {
	return ciudad;
}

public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}

@Override
public String toString() {
	return "Aeropuertos [idPais=" + idPais + ", idProvincia=" + idProvincia + ", idAeropuerto=" + idAeropuerto
			+ ", pais=" + pais.toString() + ", provincia=" + provincia.toString() + ", codigoAeropuerto=" + codigoAeropuerto + ", ciudad="
			+ ciudad + "]";
}

}
