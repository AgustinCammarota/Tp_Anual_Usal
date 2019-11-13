package edu.usal.negocio.dominio;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Ventas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Clientes cliente;
	private Vuelos vuelo;
	private LineasAereas aerolinea;
	private LocalDateTime fecha_hora_de_venta;
	private String forma_de_pago, total_a_pagar;
	private int idVentas, idAerolinea, idVuelo, idCliente; 
	
public Ventas() {}

public Ventas(Clientes cliente, Vuelos vuelo, LineasAereas aerolinea, LocalDateTime fecha_hora_de_venta,
		String forma_de_pago, String total_a_pagar, int idVentas, int idAerolinea, int idVuelo, int idCliente) {
	super();
	this.cliente = cliente;
	this.vuelo = vuelo;
	this.aerolinea = aerolinea;
	this.fecha_hora_de_venta = fecha_hora_de_venta;
	this.forma_de_pago = forma_de_pago;
	this.total_a_pagar = total_a_pagar;
	this.idVentas = idVentas;
	this.idAerolinea = idAerolinea;
	this.idVuelo = idVuelo;
	this.idCliente = idCliente;
}

public Clientes getCliente() {
	return cliente;
}

public void setCliente(Clientes cliente) {
	this.cliente = cliente;
}

public Vuelos getVuelo() {
	return vuelo;
}

public void setVuelo(Vuelos vuelo) {
	this.vuelo = vuelo;
}

public LineasAereas getAerolinea() {
	return aerolinea;
}

public void setAerolinea(LineasAereas aerolinea) {
	this.aerolinea = aerolinea;
}

public LocalDateTime getFecha_hora_de_venta() {
	return fecha_hora_de_venta;
}

public void setFecha_hora_de_venta(LocalDateTime fecha_hora_de_venta) {
	this.fecha_hora_de_venta = fecha_hora_de_venta;
}

public String getForma_de_pago() {
	return forma_de_pago;
}

public void setForma_de_pago(String forma_de_pago) {
	this.forma_de_pago = forma_de_pago;
}

public String getTotal_a_pagar() {
	return total_a_pagar;
}

public void setTotal_a_pagar(String total_a_pagar) {
	this.total_a_pagar = total_a_pagar;
}

public int getIdVentas() {
	return idVentas;
}

public void setIdVentas(int idVentas) {
	this.idVentas = idVentas;
}

public int getIdAerolinea() {
	return idAerolinea;
}

public void setIdAerolinea(int idAerolinea) {
	this.idAerolinea = idAerolinea;
}

public int getIdVuelo() {
	return idVuelo;
}

public void setIdVuelo(int idVuelo) {
	this.idVuelo = idVuelo;
}

public int getIdCliente() {
	return idCliente;
}

public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}

@Override
public String toString() {
	return "Ventas [cliente=" + cliente.toString() + ", vuelo=" + vuelo.toString() + ", aerolinea=" + aerolinea.toString() + ", fecha_hora_de_venta="
			+ fecha_hora_de_venta + ", forma_de_pago=" + forma_de_pago + ", total_a_pagar=" + total_a_pagar
			+ ", idVentas=" + idVentas + ", idAerolinea=" + idAerolinea + ", idVuelo=" + idVuelo + ", idCliente="
			+ idCliente + "]";
}
	
}