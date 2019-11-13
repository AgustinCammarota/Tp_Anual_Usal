package edu.usal.negocio.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.DAOException;

public interface TelefonoDAO {
	public boolean addTelefono(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public boolean updateTelefono(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public boolean deleteTelefono(Clientes cliente, Connection cn) throws DAOException, SQLException;
}
