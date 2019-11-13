package edu.usal.negocio.dao.implementacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dominio.Ventas;
import edu.usal.util.PropertiesUtil;

public class VentaDAOImpSerializable implements VentaDAO {
	
	private FileOutputStream fileOut;
	private FileInputStream fileInput;
	private ObjectOutputStream objectOut;
	private ObjectInputStream objectInput;
	private File file;
	@Override
	public boolean addVentas(Ventas venta) throws IOException {
		
		List<Ventas> listado = this.getAllVentas();
		listado.add(venta);
		this.saveAllVentas(listado);
		return true;
	}
    @SuppressWarnings("unchecked")
    public List<Ventas> getAllVentas() throws FileNotFoundException, IOException {
    	this.file = new File(PropertiesUtil.getPathClientes(), PropertiesUtil.getFileVentas());
    	
    	if(!file.exists()) {
    	file = new File(PropertiesUtil.getPathClientes());
    	file.mkdirs();
    	file = new File(PropertiesUtil.getPathClientes(), PropertiesUtil.getFileVentas());
    	file.createNewFile();
    	file = new File(PropertiesUtil.getPathClientes(), PropertiesUtil.getFileVentas());
    	List<Ventas> venta = new ArrayList<Ventas>();
    	return venta;
    	
    }	
    	
    	this.fileInput = new FileInputStream(file);
    	this.objectInput = new ObjectInputStream(fileInput);
	    
	     try {
	    	 List<Ventas> venta = (List<Ventas>) objectInput.readObject();
	    	 this.fileInput.close();
	    	 this.objectInput.close();
			 return venta;
			 
	     }
	     catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	     }
	     return null;
    }
	@Override
	public boolean updateVentas(long Id, Ventas venta) throws FileNotFoundException, IOException {
		List<Ventas> listado = this.getAllVentas();
		for(Ventas ventas : listado) {
			if(ventas.getIdVentas() == Id) {
				listado.remove(ventas);
				listado.add(venta);
				this.saveAllVentas(listado);
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean deleteVentas(long Id) throws FileNotFoundException, IOException {
		List<Ventas> listado = this.getAllVentas();
		for(Ventas ventas : listado) {
			if(ventas.getIdVentas() == Id) {
				listado.remove(ventas);
				this.saveAllVentas(listado);
				return true;
			}
		}
	   return false;
	}
	@Override
	public Ventas queryVentas(long Id) throws FileNotFoundException, IOException {
		List<Ventas> listado = getAllVentas();
		for(Ventas ventas : listado) {
			if(ventas.getIdVentas() == Id) {
					 return ventas;
				 }
			 }
		    return null; 
	}
	public void saveAllVentas(List<Ventas> listado) throws FileNotFoundException, IOException {
		this.file = new File(PropertiesUtil.getPathClientes(), PropertiesUtil.getFileVentas());
    	this.fileOut = new FileOutputStream(file);
    	this.objectOut = new ObjectOutputStream(fileOut);
    	this.objectOut.writeObject(listado);
    	this.objectOut.close();
	}



}
