package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class LineasAereas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idLineaAerea = null;
	private Aerolineas aerolinea;
	private String alianza;
	private ArrayList<Vuelos> vuelo;

public LineasAereas() {}

public LineasAereas(Long idLineaAerea, Aerolineas aerolinea, String alianza, ArrayList<Vuelos> vuelo) {
	super();
	this.idLineaAerea = idLineaAerea;
	this.aerolinea = aerolinea;
	this.alianza = alianza;
	this.vuelo = vuelo;
}

public Long getIdLineaAerea() {
	return idLineaAerea;
}

public void setIdLineaAerea(Long idLineaAerea) {
	this.idLineaAerea = idLineaAerea;
}

public Aerolineas getAerolinea() {
	return aerolinea;
}

public void setAerolinea(Aerolineas aerolinea) {
	this.aerolinea = aerolinea;
}

public String getAlianza() {
	return alianza;
}

public void setAlianza(String alianza) {
	this.alianza = alianza;
}

public ArrayList<Vuelos> getVuelo() {
	return vuelo;
}

public void setVuelo(ArrayList<Vuelos> vuelo) {
	this.vuelo = vuelo;
}

@Override
public String toString() {
	return "LineasAereas [idLineaAerea=" + idLineaAerea + ", aerolinea=" + aerolinea.toString() + ", alianza=" + alianza
			+ ", vuelo=" + vuelo + "]";
}

}
