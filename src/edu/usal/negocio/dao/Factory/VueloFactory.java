package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.VueloDAOImpSerializable;
import edu.usal.negocio.dao.interfaces.VueloDAO;

public class VueloFactory {
	
	public static VueloDAO getVueloDAO (String source) {
		if(source.equals("Serializable")) {
			return new VueloDAOImpSerializable();	
		}
		
		return null;
	}
	
}
