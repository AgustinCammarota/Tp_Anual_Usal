package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.PaisDAOImpSQL;
import edu.usal.negocio.dao.implementacion.PaisDAOImplFileString;
import edu.usal.negocio.dao.interfaces.PaisDAO;

public class PaisFactory {
public static PaisDAO getPaiDAO (String source){
	if(source.equals("ArchivoTxt")) {
		return new PaisDAOImplFileString();
			}else if(source.equals("Sql")){ 
				return new PaisDAOImpSQL();
			}
			return null;
	}
}
