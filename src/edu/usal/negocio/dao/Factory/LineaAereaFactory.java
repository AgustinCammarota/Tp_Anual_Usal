package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.LineaAereaDAOImpSQL;
import edu.usal.negocio.dao.implementacion.LineaAereaDAOImplFileSerializable;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;

public class LineaAereaFactory {
	public static LineaAereaDAO getLineaAereaDAO(String source){
		if(source.equals("Serializable")) {
		return new LineaAereaDAOImplFileSerializable();
		} else if(source.equals("Sql")) {
			return new LineaAereaDAOImpSQL();
		}
		return null;
}
}
