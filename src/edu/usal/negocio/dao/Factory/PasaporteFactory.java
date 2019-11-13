package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.PasaporteDAOImpSQL;
import edu.usal.negocio.dao.interfaces.PasaporteDAO;

public class PasaporteFactory {
	public static PasaporteDAO getPasaporteDAO (String source) {
		 if(source.equals("Sql")){ 
			return new PasaporteDAOImpSQL();
		}
		return null;
	}
}
