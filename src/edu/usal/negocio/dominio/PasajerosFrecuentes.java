package edu.usal.negocio.dominio;

import java.io.Serializable;

public class PasajerosFrecuentes implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String categoria, alianza;
private Aerolineas aerolinea;
private Long  idPasajeroFrecuente = null;

public PasajerosFrecuentes() {}

public PasajerosFrecuentes(String categoria, String alianza, Aerolineas aerolinea, Long idPasajeroFrecuente) {
	super();
	this.categoria = categoria;
	this.alianza = alianza;
	this.aerolinea = aerolinea;
	this.idPasajeroFrecuente = idPasajeroFrecuente;
}

public String getCategoria() {
	return categoria;
}

public void setCategoria(String categoria) {
	this.categoria = categoria;
}

public String getAlianza() {
	return alianza;
}

public void setAlianza(String alianza) {
	this.alianza = alianza;
}

public Aerolineas getAerolinea() {
	return aerolinea;
}

public void setAerolinea(Aerolineas aerolinea) {
	this.aerolinea = aerolinea;
}

public Long getIdPasajeroFrecuente() {
	return idPasajeroFrecuente;
}

public void setIdPasajeroFrecuente(Long idPasajeroFrecuente) {
	this.idPasajeroFrecuente = idPasajeroFrecuente;
}

@Override
public String toString() {
	return "PasajerosFrecuentes [categoria=" + categoria + ", alianza=" + alianza + ", aerolinea=" + aerolinea.toString()
			+ ", idPasajeroFrecuente=" + idPasajeroFrecuente + "]";
}


}