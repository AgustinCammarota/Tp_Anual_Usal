package edu.usal.negocio.dao.implementacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.LineasAereas;
import edu.usal.util.DAOException;
import edu.usal.util.PropertiesUtil;

public class LineaAereaDAOImplFileSerializable implements LineaAereaDAO {
	private FileOutputStream fileOut;
	private FileInputStream fileInput;
	private ObjectOutputStream objectOut;
	private ObjectInputStream objectInput;
	private File file;
	

	@Override
	public boolean addLineaAerea(LineasAereas lineaAerea) throws DAOException, SQLException, IOException {
		List<LineasAereas> listado = this.getAllLineasAereas();
		listado.add(lineaAerea);
		this.saveAllLineasAereas(listado);
		return true;
	}

	private void saveAllLineasAereas(List<LineasAereas> listado) throws IOException {
		this.file = new File(PropertiesUtil.getPathLineasAereas(), PropertiesUtil.getFileLineasAereas());
    	this.fileOut = new FileOutputStream(file);
    	this.objectOut = new ObjectOutputStream(fileOut);
    	this.objectOut.writeObject(listado);
    	this.objectOut.close();
	}

	@Override
	public void updateLineaAerea(LineasAereas lineaAerea) throws DAOException, IOException {
		List<LineasAereas> listado = this.getAllLineasAereas();
		for(LineasAereas lineasAereas : listado) {
			if(lineasAereas.getIdLineaAerea() == lineaAerea.getIdLineaAerea()) {
				listado.remove(lineasAereas);
				listado.add(lineaAerea);
				this.saveAllLineasAereas(listado);
			}
		}
	}

	@Override
	public boolean deleteLineaAerea(LineasAereas lineaAerea) throws DAOException, IOException {
		List<LineasAereas> listado = this.getAllLineasAereas();
		for(LineasAereas lineasAereas : listado) {
			if(lineasAereas.getIdLineaAerea() == lineaAerea.getIdLineaAerea()) {
				listado.remove(lineasAereas);
				this.saveAllLineasAereas(listado);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<LineasAereas> getAllLineasAereas() throws DAOException, IOException {
		this.file= new File(PropertiesUtil.getPathLineasAereas(),PropertiesUtil.getFileLineasAereas());
		if(!file.exists()){
			file = new File(PropertiesUtil.getPathLineasAereas());
			file.mkdirs();
			file= new File(PropertiesUtil.getPathLineasAereas(),PropertiesUtil.getFileLineasAereas());
			file.createNewFile();
			file= new File(PropertiesUtil.getPathLineasAereas(),PropertiesUtil.getFileLineasAereas());
			List<LineasAereas> lineaAerea = new ArrayList<LineasAereas>();
			return lineaAerea;
		}
		this.fileInput = new FileInputStream(file);
    	this.objectInput = new ObjectInputStream(fileInput);
	    
		try {
			@SuppressWarnings("unchecked")
			List<LineasAereas> lista = (ArrayList<LineasAereas>) objectInput.readObject();
			this.fileInput.close();
	    	this.objectInput.close();
			return lista;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Override
	public LineasAereas queryLineaAerea(int Id) throws DAOException, IOException {
		List<LineasAereas> listado = this.getAllLineasAereas();
		for(LineasAereas lineasAereas : listado) {
			if(lineasAereas.getIdLineaAerea() == Id) {
			return lineasAereas;
			}
		}return null;
	}

}
