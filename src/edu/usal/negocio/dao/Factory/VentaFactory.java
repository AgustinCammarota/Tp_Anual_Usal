package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.VentaDAOImpSerializable;
import edu.usal.negocio.dao.interfaces.VentaDAO;

public class VentaFactory {
	public static VentaDAO getVentasDAO (String source) {
		if(source.equals("Serializable")) {
			return new VentaDAOImpSerializable();
		}
		return null;
	}
}