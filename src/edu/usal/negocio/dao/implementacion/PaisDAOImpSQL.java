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
import edu.usal.negocio.dao.interfaces.PaisDAO;
import edu.usal.negocio.dominio.Paises;
import edu.usal.util.DAOException;

public class PaisDAOImpSQL implements PaisDAO {

	private static final String GETALL = "SELECT id_pais, nombre_pais FROM paises";
	private static final String GETONE = "SELECT id_pais, nombre_pais FROM paises WHERE id_pais=?";

	@Override
	public Hashtable<Integer, String> leerPaises() throws FileNotFoundException, IOException {
		return null;
	}

	private Paises Convertir(ResultSet rs) throws SQLException {
		String nombrePais = rs.getString("nombre_pais");
		Paises pais = new Paises(null, nombrePais);
		pais.setIdPais(Long.valueOf(rs.getInt("id_pais")));
		return pais;
	}

	@Override
	public Paises queryPais(int Id, Connection con) throws DAOException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Paises pais = new Paises();

		ps = con.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if (rs.next()) {
			pais = Convertir(rs);
		} else {
			throw new DAOException("NO SE ENCONTRO NINGUN REGISTRO");
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		return pais;
	}

	@Override
	public List<Paises> getAllPaises(Connection con) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Paises> pais = new ArrayList<>();

		ps = con.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while (rs.next()) {
			pais.add(Convertir(rs));
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		return pais;
	}

}
