package edu.usal.negocio.dao.implementacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import edu.usal.negocio.dao.interfaces.PaisDAO;
import edu.usal.negocio.dominio.Paises;
import edu.usal.util.DAOException;
import edu.usal.util.PropertiesUtil;

public class PaisDAOImplFileString implements PaisDAO {
	private File file;
	private Scanner scanner;

	@Override
	public Hashtable<Integer, String> leerPaises() throws FileNotFoundException, IOException {

		file = new File(PropertiesUtil.getPathTxt(), PropertiesUtil.getAllPaises());
		scanner = new Scanner(file);
		Hashtable<Integer, String> list = new Hashtable<Integer, String>();
		while (scanner.hasNextLine()) {
			String[] straux = scanner.nextLine().split(",");
			list.put(Integer.valueOf(straux[0]), straux[1]);
		}
		return list;
	}

	@Override
	public Paises queryPais(int Id, Connection cn) throws DAOException, SQLException {
		return null;
	}

	@Override
	public List<Paises> getAllPaises(Connection cn) throws SQLException {
		return null;
	}

}
