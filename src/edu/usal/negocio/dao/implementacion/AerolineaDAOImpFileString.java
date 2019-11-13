package edu.usal.negocio.dao.implementacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.util.DAOException;
import edu.usal.util.PropertiesUtil;

public class AerolineaDAOImpFileString implements AerolineaDAO {
	private File file;
	private Scanner scanner;

	@Override
	public Hashtable<Integer, String> leerAerolinea() throws FileNotFoundException, IOException {
		file = new File(PropertiesUtil.getPathTxt(), PropertiesUtil.getAllAerolineas());
		scanner = new Scanner(file);
		Hashtable<Integer, String> list = new Hashtable<Integer, String>();
		while (scanner.hasNextLine()) {
			String[] straux = scanner.nextLine().split(",");
			list.put(Integer.valueOf(straux[0]), straux[1]);
		}
		return list;
	}

	@Override
	public Aerolineas queryAerolinea(int Id, Connection cn) throws DAOException, SQLException {
		return null;
	}

	@Override
	public List<Aerolineas> getAllAerolineas(Connection cn) throws SQLException {
		return null;
	}

}
