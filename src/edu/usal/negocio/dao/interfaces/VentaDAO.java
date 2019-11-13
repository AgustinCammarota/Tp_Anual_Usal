package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Ventas;

public interface VentaDAO {
	public boolean addVentas(Ventas venta) throws IOException;
	public boolean updateVentas(long Id, Ventas venta) throws FileNotFoundException, IOException;
	public boolean deleteVentas(long Id) throws FileNotFoundException, IOException;
	public Ventas queryVentas(long Id) throws FileNotFoundException, IOException;
	public List<Ventas> getAllVentas() throws FileNotFoundException, IOException;
	}

