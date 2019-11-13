package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Vuelos implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numeroVuelo, tiempoVuelo, cantidadAsientos;
	private Long idVuelo=null;
	private Aeropuertos aeropuertoSalida;
	private Aeropuertos aeropuertoLlegada;
	private LineasAereas aerolinea;
	private LocalDate fechaSalida, fechaLlegada;
	private LocalTime horaSalida, horaLLegada;
	
public Vuelos() {}

public Vuelos(String numeroVuelo, String tiempoVuelo, String cantidadAsientos, Long idVuelo,
		Aeropuertos aeropuertoSalida, Aeropuertos aeropuertoLlegada, LineasAereas aerolinea, LocalDate fechaSalida,
		LocalDate fechaLlegada, LocalTime horaSalida, LocalTime horaLLegada) {
	super();
	this.numeroVuelo = numeroVuelo;
	this.tiempoVuelo = tiempoVuelo;
	this.cantidadAsientos = cantidadAsientos;
	this.idVuelo = idVuelo;
	this.aeropuertoSalida = aeropuertoSalida;
	this.aeropuertoLlegada = aeropuertoLlegada;
	this.aerolinea = aerolinea;
	this.fechaSalida = fechaSalida;
	this.fechaLlegada = fechaLlegada;
	this.horaSalida = horaSalida;
	this.horaLLegada = horaLLegada;
}

public String getNumeroVuelo() {
	return numeroVuelo;
}

public void setNumeroVuelo(String numeroVuelo) {
	this.numeroVuelo = numeroVuelo;
}

public String getTiempoVuelo() {
	return tiempoVuelo;
}

public void setTiempoVuelo(String tiempoVuelo) {
	this.tiempoVuelo = tiempoVuelo;
}

public String getCantidadAsientos() {
	return cantidadAsientos;
}

public void setCantidadAsientos(String cantidadAsientos) {
	this.cantidadAsientos = cantidadAsientos;
}

public Long getIdVuelo() {
	return idVuelo;
}

public void setIdVuelo(Long idVuelo) {
	this.idVuelo = idVuelo;
}

public Aeropuertos getAeropuertoSalida() {
	return aeropuertoSalida;
}

public void setAeropuertoSalida(Aeropuertos aeropuertoSalida) {
	this.aeropuertoSalida = aeropuertoSalida;
}

public Aeropuertos getAeropuertoLlegada() {
	return aeropuertoLlegada;
}

public void setAeropuertoLlegada(Aeropuertos aeropuertoLlegada) {
	this.aeropuertoLlegada = aeropuertoLlegada;
}

public LineasAereas getAerolinea() {
	return aerolinea;
}

public void setAerolinea(LineasAereas aerolinea) {
	this.aerolinea = aerolinea;
}

public LocalDate getFechaSalida() {
	return fechaSalida;
}

public void setFechaSalida(LocalDate fechaSalida) {
	this.fechaSalida = fechaSalida;
}

public LocalDate getFechaLlegada() {
	return fechaLlegada;
}

public void setFechaLlegada(LocalDate fechaLlegada) {
	this.fechaLlegada = fechaLlegada;
}

public LocalTime getHoraSalida() {
	return horaSalida;
}

public void setHoraSalida(LocalTime horaSalida) {
	this.horaSalida = horaSalida;
}

public LocalTime getHoraLLegada() {
	return horaLLegada;
}

public void setHoraLLegada(LocalTime horaLLegada) {
	this.horaLLegada = horaLLegada;
}

@Override
public String toString() {
	return "Vuelos [numeroVuelo=" + numeroVuelo + ", tiempoVuelo=" + tiempoVuelo + ", cantidadAsientos="
			+ cantidadAsientos + ", idVuelo=" + idVuelo + ", aeropuertoSalida=" + aeropuertoSalida.toString()
			+ ", aeropuertoLlegada=" + aeropuertoLlegada.toString() + ", aerolinea=" + aerolinea.toString() + ", fechaSalida=" + fechaSalida
			+ ", fechaLlegada=" + fechaLlegada + ", horaSalida=" + horaSalida + ", horaLLegada=" + horaLLegada + "]";
}



}
