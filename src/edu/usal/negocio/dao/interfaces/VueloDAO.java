package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Vuelos;

public interface VueloDAO {

	public boolean addVuelo(Vuelos vuelo) throws IOException;
	public boolean updateVuelo(long Id, Vuelos vuelo) throws FileNotFoundException, IOException;
	public boolean deleteVuelo(long Id) throws FileNotFoundException, IOException;
	public Vuelos queryVuelo(long Id) throws FileNotFoundException, IOException;
	public List<Vuelos> getAllVuelos() throws FileNotFoundException, IOException;

	
}
