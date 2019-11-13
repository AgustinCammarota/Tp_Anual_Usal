package edu.usal.negocio.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.DAOException;


public interface PasajeroFrecuenteDAO {
	public boolean addPasajeroFrecuente(Clientes cliente, Connection cn) throws SQLException, DAOException;
	public boolean updatePasajeroFrecuente(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public boolean deletePasajeroFrecuente(Clientes cliente, Connection cn) throws DAOException, SQLException;
}
