package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import edu.usal.negocio.dao.interfaces.PasaporteDAO;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Pasaportes;
import edu.usal.util.DAOException;
import edu.usal.util.LocalDateConverter;

public class PasaporteDAOImpSQL implements PasaporteDAO {

	LocalDateConverter convertir = new LocalDateConverter();
	final String INSERT = "INSERT INTO pasaportes (numero_pasaporte, autoridad_emision, fecha_emision, fecha_vencimiento, id_pais, id_cliente) VALUES(?,?,?,?,?,?)";
	final String UPDATE = "UPDATE pasaportes SET numero_pasaporte=?, autoridad_emision=?, fecha_emision=?, fecha_vencimiento=?, id_pais=? WHERE id_cliente=?";
	final String DELETE = "DELETE FROM pasaportes WHERE id_cliente=?";

	@Override
	public boolean addPasaporte(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		cn.setAutoCommit(false);
		Pasaportes pasaporte = new Pasaportes();

		ps = cn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, cliente.getPasaporte().getNumeroPasaporte());
		ps.setString(2, cliente.getPasaporte().getAutoridadEmision());
		ps.setDate(3, convertir.convertToDatabaseColumn((cliente.getPasaporte().getFechaEmision())));
		ps.setDate(4, convertir.convertToDatabaseColumn(cliente.getPasaporte().getFechaVencimiento()));
		ps.setLong(5, cliente.getPasaporte().getPais().getIdPais());
		ps.setLong(6, cliente.getIdCliente());
		rs = ps.getGeneratedKeys();
	
		while (rs.next())
			pasaporte.setIdPasaporte((long) rs.getInt(1));
		cliente.setPasaporte(pasaporte);

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
	public boolean updatePasaporte(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;

		ps = cn.prepareStatement(UPDATE, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, cliente.getPasaporte().getNumeroPasaporte());
		ps.setString(2, cliente.getPasaporte().getAutoridadEmision());
		ps.setDate(3, convertir.convertToDatabaseColumn((cliente.getPasaporte().getFechaEmision())));
		ps.setDate(4, convertir.convertToDatabaseColumn(cliente.getPasaporte().getFechaVencimiento()));
		ps.setLong(5, cliente.getPasaporte().getPais().getIdPais());

		if (ps.executeUpdate() > 0) {
			return true;
		}
		if (ps != null) {
			ps.close();
		}
		return false;
	}

	@Override
	public boolean deletePasaporte(Clientes cliente, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		cn.setAutoCommit(false);

		ps = cn.prepareStatement(DELETE);
		ps.setLong(1, cliente.getPasaporte().getIdPasaporte());

		if (ps.executeUpdate() > 0) {
			return true;
		}
		if (ps != null) {
			ps.close();
		}
		return false;
	}
}
