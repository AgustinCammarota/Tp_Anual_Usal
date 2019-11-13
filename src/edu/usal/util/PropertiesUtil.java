package edu.usal.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

	private static Properties properties = CargarProperties();

	private static Properties CargarProperties() {
		properties = new Properties();
		try {
			properties.load(new FileReader("Archivo.properties"));
			// properties.load(ClassLoader.getSystemResourceAsStream("Archivo.properties"));
			return properties;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getPathClientes() {
		return properties.getProperty("PathCliente");
	}

	public static String getFileClientes() {
		return properties.getProperty("FileCliente");
	}

	public static String getPathVuelos() {
		return properties.getProperty("PathVuelos");
	}

	public static String getFileVuelos() {
		return properties.getProperty("FileVuelo");
	}

	public static String getPathVentas() {
		return properties.getProperty("PathVenta");
	}

	public static String getFileVentas() {
		return properties.getProperty("FileVenta");
	}

	public static String getPathLineasAereas() {
		return properties.getProperty("PathLineasAreas");
	}

	public static String getFileLineasAereas() {
		return properties.getProperty("FileLineasAereas");
	}

	public static String getPathTxt() {
		return properties.getProperty("PathTxt");
	}

	public static String getAllPaises() {
		return properties.getProperty("FilePaises");
	}

	public static String getAllProvincias() {
		return properties.getProperty("FileProvincias");
	}

	public static String getAllAerolineas() {
		return properties.getProperty("FileAerolineas");
	}

	public static String getDriver() {
		return properties.getProperty("driver");
	}

	public static String getUrl() {
		return properties.getProperty("url");
	}

	public static String getUser() {
		return properties.getProperty("user");
	}

	public static String getPassword() {
		return properties.getProperty("password");
	}

}
