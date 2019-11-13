package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.ProvinciaDAOImpSQL;
import edu.usal.negocio.dao.implementacion.ProvinciaDAOImplFileString;
import edu.usal.negocio.dao.interfaces.ProvinciaDAO;

public class ProvinciaFactory {
	public static ProvinciaDAO getProvinciaDAO(String source){
		if(source.equals("ArchivoTxt")) {
		return new ProvinciaDAOImplFileString();
		}else if(source.equals("Sql")){ 
			return new ProvinciaDAOImpSQL();
		}
		return null;
		}
}
