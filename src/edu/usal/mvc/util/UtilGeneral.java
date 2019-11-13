package edu.usal.mvc.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import edu.usal.negocio.dao.Factory.AerolineaFactory;
import edu.usal.negocio.dao.Factory.PaisFactory;
import edu.usal.negocio.dao.Factory.ProvinciaFactory;
import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dao.interfaces.PaisDAO;
import edu.usal.negocio.dao.interfaces.ProvinciaDAO;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.negocio.dominio.Paises;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.util.Connections;

public class UtilGeneral {

	public static String getPais(Long Id) {
		PaisDAO paisImp = PaisFactory.getPaiDAO("Sql");
		Connection con = Connections.getConnection();
		List<Paises> paises = null;
		try {
			paises = paisImp.getAllPaises(con);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar datos"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		for(Paises p: paises) {
			if(p.getIdPais() == Id) {
				return p.getNombrePais();
			}
		}
		return "";
	}

	public static int getNumPais(Long Id) {
		PaisDAO paisImp = PaisFactory.getPaiDAO("Sql");
		Connection con = Connections.getConnection();
		List<Paises> paises = null;
		try {
			paises = paisImp.getAllPaises(con);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar datos"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		for(int i=0; i<paises.size(); i++) {
			if(paises.get(i).getIdPais() == Id) {
				return i;
			}
		}
		return 0;
	}
	
	public static String getProvincia(Long Id) {
		ProvinciaDAO provinciaImp = ProvinciaFactory.getProvinciaDAO("Sql");
		Connection con = Connections.getConnection();
		List<Provincias> provincias = null;
		try {
			provincias = provinciaImp.getAllProvincias(con);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar datos"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		for(Provincias p : provincias) {
			if(p.getIdProvincia() == Id) {
				return p.getNombreProvincia();
			}
		}
		return "";
	}

	public static int getNumProvincia(Long Id) {
		ProvinciaDAO provinciaImp = ProvinciaFactory.getProvinciaDAO("Sql");
		Connection con = Connections.getConnection();
		List<Provincias> provincias = null;
		try {
			provincias = provinciaImp.getAllProvincias(con);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar datos"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		for(int i=0; i<provincias.size(); i++) {
			if(provincias.get(i).getIdProvincia() == Id) {
				return i;
			}
		}
		return 0;
	}
	
	public static String getAerolinea(Long Id) {
		AerolineaDAO aerolineaImp = AerolineaFactory.getAerolineaDAO("Sql");
		Connection con = Connections.getConnection();
		List<Aerolineas> aerolineas = null;
		try {
			aerolineas = aerolineaImp.getAllAerolineas(con);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar datos"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		for(Aerolineas a : aerolineas) {
			if(a.getIdAerolinea() == Id) {
				return a.getNombreAerolinea();
			}
		}
		return "";
	}

	public static int getNumAerolinea(Long Id) {
		AerolineaDAO aerolineaImp = AerolineaFactory.getAerolineaDAO("Sql");
		Connection con = Connections.getConnection();
		List<Aerolineas> aerolineas = null;
		try {
			aerolineas = aerolineaImp.getAllAerolineas(con);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar datos"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		for(int i=0; i<aerolineas.size(); i++) {
			if(aerolineas.get(i).getIdAerolinea() == Id) {
				return i;
			}
		}
		return 0;
	}
}
