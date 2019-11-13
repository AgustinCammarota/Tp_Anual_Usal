package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.DireccionDAOImpSQL;
import edu.usal.negocio.dao.interfaces.DireccionDAO;

public class DireccionFactory {
	public static DireccionDAO getDireccionDAO (String source) {
		 if(source.equals("Sql")){ 
			return new DireccionDAOImpSQL();
		}
		return null;
	}
}
