package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import edu.usal.negocio.dao.interfaces.PasajeroFrecuenteDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.PasajerosFrecuentes;
import edu.usal.util.DAOException;

public class PasajeroFrecuenteDAOImpSQL implements PasajeroFrecuenteDAO {

	final String INSERT = "INSERT INTO pasajeros_frecuentes (alianza, categoria, id_cliente, id_aerolinea) VALUES(?,?,?,?)";
	final String UPDATE = "UPDATE pasajeros_frecuentes SET alianza=?, categoria=?, id_aeroliea=? WHERE id_cliente=?";
	final String DELETE = "DELETE FROM pasajeros_frecuentes WHERE id_cliente=?";

	@Override
	public boolean addPasajeroFrecuente(Clientes cliente, Connection cn) throws SQLException, DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		cn.setAutoCommit(false);
		PasajerosFrecuentes pasajero = new PasajerosFrecuentes();

		ps = cn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, cliente.getPasajerofrecuente().getAlianza());
		ps.setString(2, cliente.getPasajerofrecuente().getCategoria());
		ps.setLong(3, cliente.getIdCliente());
		ps.setLong(4, cliente.getPasajerofrecuente().getAerolinea().getIdAerolinea());
		rs = ps.getGeneratedKeys();

		while (rs.next())
			pasajero.setIdPasajeroFrecuente((long) rs.getInt(1));
		cliente.setPasajerofrecuente(pasajero);

		if (ps.executeUpdate() > 0) {
			return true;
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

		return false;
	}

	@Override
	public boolean updatePasajeroFrecuente(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;

		ps = cn.prepareStatement(UPDATE);
		ps.setString(1, cliente.getPasajerofrecuente().getAlianza());
		ps.setString(2, cliente.getPasajerofrecuente().getCategoria());
		ps.setLong(4, cliente.getPasajerofrecuente().getAerolinea().getIdAerolinea());

		if (ps.executeUpdate() > 0) {
			return true;
		}
		if (ps != null) {
			ps.close();
		}
		return false;
	}

	@Override
	public boolean deletePasajeroFrecuente(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		cn.setAutoCommit(false);

		ps = cn.prepareStatement(DELETE);
		ps.setLong(1, cliente.getPasajerofrecuente().getIdPasajeroFrecuente());

		if (ps.executeUpdate() > 0) {
			return true;
		}
		if (ps != null) {
			ps.close();
		}
		return false;
	}

}
