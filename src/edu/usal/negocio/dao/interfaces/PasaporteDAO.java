package edu.usal.negocio.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.DAOException;

public interface PasaporteDAO {
	public boolean addPasaporte(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public boolean updatePasaporte(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public boolean deletePasaporte(Clientes cliente, Connection cn) throws DAOException, SQLException;
}
