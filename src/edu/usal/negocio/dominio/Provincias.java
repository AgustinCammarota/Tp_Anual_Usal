package edu.usal.negocio.dominio;

public class Provincias {

	private Long idProvincia = null;
	private String nombreProvincia;
	
public Provincias() {}

public Provincias(Long idProvincia, String nombreProvincia) {
	super();
	this.idProvincia = idProvincia;
	this.nombreProvincia = nombreProvincia;
}

public Long getIdProvincia() {
	return idProvincia;
}

public void setIdProvincia(Long idProvincia) {
	this.idProvincia = idProvincia;
}

public String getNombreProvincia() {
	return nombreProvincia;
}

public void setNombreProvincia(String nombreProvincia) {
	this.nombreProvincia = nombreProvincia;
}

@Override
public String toString() {
	return "Provincias [idProvincia=" + idProvincia + ", nombreProvincia=" + nombreProvincia + "]";
}

}
