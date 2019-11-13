package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.TelefonoDAOImpSQL;
import edu.usal.negocio.dao.interfaces.TelefonoDAO;

public class TelefonoFactory {
	public static TelefonoDAO getTelefonoDAO (String source) {
		 if(source.equals("Sql")){ 
			return new TelefonoDAOImpSQL();
		}
		return null;
	}
}
