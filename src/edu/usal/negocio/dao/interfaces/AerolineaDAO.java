package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.util.DAOException;

public interface AerolineaDAO {
	public Hashtable<Integer,String> leerAerolinea()throws FileNotFoundException, IOException;
	public Aerolineas queryAerolinea(int Id, Connection cn) throws DAOException, SQLException;
	public List<Aerolineas> getAllAerolineas(Connection cn) throws SQLException;
}
