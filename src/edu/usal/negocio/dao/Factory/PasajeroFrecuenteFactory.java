package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.PasajeroFrecuenteDAOImpSQL;
import edu.usal.negocio.dao.interfaces.PasajeroFrecuenteDAO;

public class PasajeroFrecuenteFactory {
	public static PasajeroFrecuenteDAO getPasajeroFrecuenteDAO (String source) {
		 if(source.equals("Sql")){ 
			return new PasajeroFrecuenteDAOImpSQL();
		}
		return null;
	}
}
