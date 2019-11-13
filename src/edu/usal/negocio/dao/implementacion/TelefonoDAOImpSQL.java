package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import edu.usal.negocio.dao.interfaces.TelefonoDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Telefonos;
import edu.usal.util.DAOException;

public class TelefonoDAOImpSQL implements TelefonoDAO {

	final String INSERT = "INSERT INTO telefonos (personal, celular, laboral, id_cliente) VALUES(?,?,?,?)";
	final String UPDATE = "UPDATE telefonos SET personal=?, celular=?, laboral=? WHERE id_cliente=?";
	final String DELETE = "DELETE FROM telefonos WHERE id_cliente=?";

	@Override
	public boolean addTelefono(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		cn.setAutoCommit(false);
		Telefonos telefono = new Telefonos();

		ps = cn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, cliente.getTelefono().getNumeroPersonal());
		ps.setString(2, cliente.getTelefono().getNumeroCelular());
		ps.setString(3, cliente.getTelefono().getNumeroLaboral());
		ps.setLong(4, cliente.getIdCliente());
		rs = ps.getGeneratedKeys();

		while (rs.next())
			telefono.setIdTelefono((long) rs.getInt(1));
		cliente.setTelefono(telefono);

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
	public boolean updateTelefono(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;

		ps = cn.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, cliente.getTelefono().getNumeroPersonal());
		ps.setString(2, cliente.getTelefono().getNumeroCelular());
		ps.setString(3, cliente.getTelefono().getNumeroLaboral());

		if (ps.executeUpdate() > 0) {
			return true;
		}
		if (ps != null) {
			ps.close();
		}
		return false;
	}

	@Override
	public boolean deleteTelefono(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		cn.setAutoCommit(false);

		ps = cn.prepareStatement(DELETE);
		ps.setLong(1, cliente.getTelefono().getIdTelefono());
		ps.executeUpdate();

		if (ps.executeUpdate() > 0) {
			return true;
		}
		if (ps != null) {
			ps.close();
		}
		return false;
	}

}
