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
import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.util.DAOException;

public class AerolineaDAOImpSQL implements AerolineaDAO {
	
	private static final String GETALL = "SELECT id_aerolinea, nombre_aerolinea FROM aerolineas";
	private static final String GETONE = "SELECT id_aerolinea, nombre_aerolinea FROM aerolineas WHERE id_aerolinea=?";
	
	
	@Override
	public Hashtable<Integer, String> leerAerolinea() throws FileNotFoundException, IOException {
		return null;
	}
	
	private Aerolineas Convertir(ResultSet rs) throws SQLException {
    	String nombreAerolinea  = rs.getString("nombre_aerolinea");
    	Aerolineas aerolinea = new Aerolineas (null, nombreAerolinea);
    	aerolinea.setIdAerolinea(Long.valueOf(rs.getInt("id_aerolinea")));
    	return aerolinea;
    }

	@Override
	public Aerolineas queryAerolinea(int Id, Connection cn) throws DAOException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Aerolineas aerolinea = new Aerolineas();
		
		ps= cn.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if(rs.next()) {
			aerolinea = Convertir(rs);
		}else {
			throw new DAOException("NO SE ENCONTRO NINGUN REGISTRO");
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		return aerolinea;
	}

	@Override
	public List<Aerolineas> getAllAerolineas(Connection cn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Aerolineas> aerolinea = new ArrayList<>();
		
		ps= cn.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while(rs.next()) {
			aerolinea.add(Convertir(rs));
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		return aerolinea;
	}

}
