package edu.usal.negocio.dao.Factory;

import edu.usal.negocio.dao.implementacion.ClienteDAOImpSQL;
import edu.usal.negocio.dao.implementacion.ClienteDAOImpSerializable;
import edu.usal.negocio.dao.interfaces.ClienteDAO;

public class ClienteFactory {
public static ClienteDAO getClienteDAO (String source) {
	if(source.equals("Serializable")) {
		return new ClienteDAOImpSerializable();
	} else if(source.equals("Sql")){ 
		return new ClienteDAOImpSQL();
	}
	return null;
}
}
