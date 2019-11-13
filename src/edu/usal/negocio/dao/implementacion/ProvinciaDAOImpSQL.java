package edu.usal.negocio.dao.implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import edu.usal.negocio.dao.interfaces.ProvinciaDAO;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.util.DAOException;

public class ProvinciaDAOImpSQL implements ProvinciaDAO {

	private static final String GETALL = "SELECT id_provincia, nombre_provincia FROM provincias";
	private static final String GETONE = "SELECT id_provincia, nombre_provincia FROM provincias WHERE id_provincia=?";

	@Override
	public Hashtable<Integer, String> leerProvincias() throws FileNotFoundException, IOException {
		return null;
	}

	private Provincias Convertir(ResultSet rs) throws SQLException {
		String nombreProvincia = rs.getString("nombre_provincia");
		Provincias provincia = new Provincias(null, nombreProvincia);
		provincia.setIdProvincia(Long.valueOf(rs.getInt("id_provincia")));
		return provincia;
	}

	@Override
	public Provincias queryProvincia(int Id, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Provincias provincia = new Provincias();

		ps = cn.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if (rs.next()) {
			provincia = Convertir(rs);
		} else {
			throw new DAOException("NO SE ENCONTRO NINGUN REGISTRO");
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		return provincia;
	}

	@Override
	public List<Provincias> getAllProvincias(Connection cn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Provincias> provincia = new ArrayList<>();

		ps = cn.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while (rs.next()) {
			provincia.add(Convertir(rs));
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		return provincia;
	}
}
