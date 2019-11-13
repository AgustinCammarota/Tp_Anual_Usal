package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.time.LocalDate;


public class Pasaportes implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String numeroPasaporte, autoridadEmision;
private LocalDate fechaEmision, fechaVencimiento;
private Paises pais;
private Long idPasaporte = null;

public Pasaportes() {}

public Pasaportes(String numeroPasaporte, String autoridadEmision, LocalDate fechaEmision, LocalDate fechaVencimiento,
		Paises pais, Long idPasaporte) {
	super();
	this.numeroPasaporte = numeroPasaporte;
	this.autoridadEmision = autoridadEmision;
	this.fechaEmision = fechaEmision;
	this.fechaVencimiento = fechaVencimiento;
	this.pais = pais;
	this.idPasaporte = idPasaporte;
}

public String getNumeroPasaporte() {
	return numeroPasaporte;
}

public void setNumeroPasaporte(String numeroPasaporte) {
	this.numeroPasaporte = numeroPasaporte;
}

public String getAutoridadEmision() {
	return autoridadEmision;
}

public void setAutoridadEmision(String autoridadEmision) {
	this.autoridadEmision = autoridadEmision;
}

public LocalDate getFechaEmision() {
	return fechaEmision;
}

public void setFechaEmision(LocalDate fechaEmision) {
	this.fechaEmision = fechaEmision;
}

public LocalDate getFechaVencimiento() {
	return fechaVencimiento;
}

public void setFechaVencimiento(LocalDate fechaVencimiento) {
	this.fechaVencimiento = fechaVencimiento;
}

public Paises getPais() {
	return pais;
}

public void setPais(Paises pais) {
	this.pais = pais;
}

public Long getIdPasaporte() {
	return idPasaporte;
}

public void setIdPasaporte(Long idPasaporte) {
	this.idPasaporte = idPasaporte;
}

@Override
public String toString() {
	return "Pasaportes [numeroPasaporte=" + numeroPasaporte + ", autoridadEmision=" + autoridadEmision
			+ ", fechaEmision=" + fechaEmision + ", fechaVencimiento=" + fechaVencimiento + ", pais=" + pais.toString()
			+ ", idPasaporte=" + idPasaporte + "]";
}

}
