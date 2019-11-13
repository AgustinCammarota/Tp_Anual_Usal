package edu.usal.negocio.dao.implementacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import edu.usal.negocio.dao.interfaces.ProvinciaDAO;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.util.DAOException;
import edu.usal.util.PropertiesUtil;

public class ProvinciaDAOImplFileString implements ProvinciaDAO {
	private File file;
	private Scanner scanner;

	@Override
	public Hashtable<Integer, String> leerProvincias() throws FileNotFoundException, IOException {

		file = new File(PropertiesUtil.getPathTxt(), PropertiesUtil.getAllProvincias());
		scanner = new Scanner(file);
		Hashtable<Integer, String> list = new Hashtable<Integer, String>();
		while (scanner.hasNextLine()) {
			String[] straux = scanner.nextLine().split(",");
			list.put(Integer.valueOf(straux[0]), straux[1]);
		}
		return list;
	}

	@Override
	public Provincias queryProvincia(int Id, Connection cn) throws DAOException, SQLException {
		return null;
	}

	@Override
	public List<Provincias> getAllProvincias(Connection cn) throws SQLException {
		return null;
	}

}
