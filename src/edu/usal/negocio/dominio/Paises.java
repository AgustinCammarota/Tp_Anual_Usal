package edu.usal.negocio.dominio;

public class Paises {
	
	private Long idPais = null;
	private String nombrePais;

public Paises() {}

public Paises(Long idPais, String nombrePais) {
	super();
	this.idPais = idPais;
	this.nombrePais = nombrePais;
}

public Long getIdPais() {
	return idPais;
}

public void setIdPais(Long idPais) {
	this.idPais = idPais;
}

public String getNombrePais() {
	return nombrePais;
}

public void setNombrePais(String nombrePais) {
	this.nombrePais = nombrePais;
}

@Override
public String toString() {
	return "Paises [idPais=" + idPais + ", nombrePais=" + nombrePais + "]";
}

}
