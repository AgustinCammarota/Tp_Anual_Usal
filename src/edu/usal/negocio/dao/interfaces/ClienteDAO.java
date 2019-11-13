package edu.usal.negocio.dao.interfaces;
import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.util.DAOException;

public interface ClienteDAO {
public boolean addCliente(Clientes cliente, Connection cn) throws IOException, DAOException, SQLException;
public boolean updateCliente(Clientes cliente, Connection con) throws FileNotFoundException, IOException, DAOException, SQLException;
public boolean deleteCliente(Clientes cliente, Connection cn) throws FileNotFoundException, IOException, DAOException, SQLException;
public Clientes queryCliente(int Id, Connection con) throws FileNotFoundException, IOException, DAOException, SQLException;
public List<Clientes> getAllClientes(Connection con) throws FileNotFoundException, IOException, DAOException, SQLException;

}
