package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.AerolineaDAOImpFileString;
import edu.usal.negocio.dao.implementacion.AerolineaDAOImpSQL;
import edu.usal.negocio.dao.interfaces.AerolineaDAO;

public class AerolineaFactory {
	public static AerolineaDAO getAerolineaDAO (String source){
		if(source.equals("ArchivoTxt")) {
			return new AerolineaDAOImpFileString();
				}else if(source.equals("Sql")){ 
					return new AerolineaDAOImpSQL();
				}
				return null;
		}
}
