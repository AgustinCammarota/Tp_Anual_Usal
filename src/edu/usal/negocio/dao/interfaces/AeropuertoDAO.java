package edu.usal.negocio.dao.interfaces;

import java.util.List;

import edu.usal.negocio.dominio.Aeropuertos;


public interface AeropuertoDAO {
	public boolean addAeropuertoL(Aeropuertos aeropuertoL);
	public boolean updateAeropuertoL(long Id, Aeropuertos aeropuertoL);
	public boolean deleteAeropuertoL(long Id);
	public Aeropuertos queryAeropuertoL(long Id);
	public List<Aeropuertos> getAllAeropuertoL();
}
