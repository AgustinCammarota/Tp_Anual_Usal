package edu.usal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
	public static Connection con = null;
	private String url = null;

	private Connections() {
		try {
			Class.forName(PropertiesUtil.getDriver());
			url = PropertiesUtil.getUrl();
			con = DriverManager.getConnection(url, PropertiesUtil.getUser(), PropertiesUtil.getPassword());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
	public static Connection getConnection() {
		if (con == null) {
			new Connections();
		}
		return  con;
	}

	public static void closeConnection(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void Commit(Connection con) throws DAOException {
		try {
			if (con != null) {
				con.commit();
			} else {
				throw new DAOException("NO SE PUDO REALIZAR EL COMMIT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void RollBack(Connection con) throws DAOException {
		try {
			if (con != null) {
				con.rollback();
			} else {
				throw new DAOException("NO SE PUDO REALIZAR EL ROLLBack");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
