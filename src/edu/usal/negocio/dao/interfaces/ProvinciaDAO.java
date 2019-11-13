package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.util.DAOException;

public interface ProvinciaDAO {
	public Hashtable<Integer,String> leerProvincias()throws FileNotFoundException, IOException;
	public Provincias queryProvincia(int Id, Connection cn) throws  DAOException, SQLException;
	public List<Provincias> getAllProvincias(Connection cn) throws SQLException;
}
