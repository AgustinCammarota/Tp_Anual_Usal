package edu.usal.negocio.dominio;

public class Aerolineas {
private Long idAerolinea = null;
private String nombreAerolinea;


public Aerolineas() {}


public Aerolineas(Long idAerolinea, String nombreAerolinea) {
	super();
	this.idAerolinea = idAerolinea;
	this.nombreAerolinea = nombreAerolinea;
}


public Long getIdAerolinea() {
	return idAerolinea;
}


public void setIdAerolinea(Long idAerolinea) {
	this.idAerolinea = idAerolinea;
}


public String getNombreAerolinea() {
	return nombreAerolinea;
}


public void setNombreAerolinea(String nombreAerolinea) {
	this.nombreAerolinea = nombreAerolinea;
}


@Override
public String toString() {
	return "Aerolineas [idAerolinea=" + idAerolinea + ", nombreAerolinea=" + nombreAerolinea + "]";
}

}
