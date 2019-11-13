package edu.usal.negocio.dao.interfaces;

import java.sql.Connection;
import java.sql.SQLException;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.DAOException;


public interface DireccionDAO {
	public boolean addDireccion(Clientes cliente, Connection cn) throws SQLException, DAOException;
	public boolean updateDireccion(Clientes cliente, Connection cn) throws DAOException, SQLException;
	public boolean deleteDireccion(Clientes cliente, Connection cn) throws DAOException, SQLException;
}
