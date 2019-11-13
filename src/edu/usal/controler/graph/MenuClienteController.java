package edu.usal.controler.graph;

import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.usal.mvc.util.UtilGeneral;
import edu.usal.negocio.dao.Factory.AerolineaFactory;
import edu.usal.negocio.dao.Factory.ClienteFactory;
import edu.usal.negocio.dao.Factory.DireccionFactory;
import edu.usal.negocio.dao.Factory.PaisFactory;
import edu.usal.negocio.dao.Factory.PasajeroFrecuenteFactory;
import edu.usal.negocio.dao.Factory.PasaporteFactory;
import edu.usal.negocio.dao.Factory.ProvinciaFactory;
import edu.usal.negocio.dao.Factory.TelefonoFactory;
import edu.usal.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.DireccionDAO;
import edu.usal.negocio.dao.interfaces.PaisDAO;
import edu.usal.negocio.dao.interfaces.PasajeroFrecuenteDAO;
import edu.usal.negocio.dao.interfaces.PasaporteDAO;
import edu.usal.negocio.dao.interfaces.ProvinciaDAO;
import edu.usal.negocio.dao.interfaces.TelefonoDAO;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Direcciones;
import edu.usal.negocio.dominio.Paises;
import edu.usal.negocio.dominio.PasajerosFrecuentes;
import edu.usal.negocio.dominio.Pasaportes;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.negocio.dominio.Telefonos;
import edu.usal.util.Connections;
import edu.usal.util.DAOException;
import edu.usal.util.LocalDateConverter;
import edu.usal.view.graph.ClienteAlta;
import edu.usal.view.graph.ClienteMenu;
import edu.usal.view.graph.ClienteUpdate;


public class MenuClienteController {
	private List<Clientes> clienteL;
	private Clientes cliente;
	private static final LocalDateConverter convertir = new LocalDateConverter();
	MenuPrincipalController mpc;
	MenuClienteController mcc;
	ClienteMenu cm;
	ClienteAlta ca;
	ClienteUpdate cu;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public MenuClienteController(MenuPrincipalController mpc) {
		this.mpc=mpc;
		cm= new ClienteMenu(this);
	}
	
	public MenuClienteController(){
		
	}
	
	public JTable CargarTable(JTable table) {
		int numCols=table.getModel().getColumnCount();
		Object [] fila= new Object[numCols];
		ClienteDAO clienteDAO = ClienteFactory.getClienteDAO("Sql");
		Connection cn = Connections.getConnection();
			try {
				clienteL = clienteDAO.getAllClientes(cn);
			} catch (IOException | DAOException | SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al cargar los clientes"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			for(Clientes c: clienteL) {
				fila[0]=c.getIdCliente();
				fila[1]=c.getNombre();
				fila[2]=c.getApellido();
				fila[3]=c.getFechaNacimiento().format(formatter);
				fila[4]=c.getDni();
				fila[5]=c.getCuit();
				fila[6]=c.getEmail();
				fila[7]=c.getDireccion().getCalle();
				fila[8]=c.getDireccion().getAltura();
				fila[9]=c.getDireccion().getCodigoPostal();
				fila[10]=c.getDireccion().getCiudad();
				fila[11]=c.getDireccion().getPais().getNombrePais();
				fila[12]=c.getDireccion().getProvincia().getNombreProvincia();
				fila[13]=c.getPasaporte().getNumeroPasaporte();
				fila[14]=c.getPasaporte().getAutoridadEmision();
				fila[15]=c.getPasaporte().getFechaEmision().format(formatter);
				fila[16]=c.getPasaporte().getFechaVencimiento().format(formatter);
				fila[17]=c.getPasaporte().getPais().getNombrePais();
				fila[18]=c.getTelefono().getNumeroPersonal();
				fila[19]=c.getTelefono().getNumeroCelular();
				fila[20]=c.getTelefono().getNumeroLaboral();
				fila[21]=c.getPasajerofrecuente().getAlianza();
				fila[22]=c.getPasajerofrecuente().getCategoria();
				fila[23]=c.getPasajerofrecuente().getAerolinea().getNombreAerolinea();
				
				((DefaultTableModel) table.getModel()).addRow(fila);
			}
			return table;
			}
	
	  public void AltaCliente() {
	  cm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	  cm.getBtnEliminacionCliente().setEnabled(false);
	  cm.getBtnModificacionCliente().setEnabled(false); 
	  ca = new ClienteAlta(this);
	  }
	  
	  public void HabilitarBotonoes() {
	  cm.getBtnEliminacionCliente().setEnabled(true);
	  cm.getBtnModificacionCliente().setEnabled(true); 
	  }
	 
	  public void EliminarCliente() {
		  int row = cm.getTable().getSelectedRow();
		  cm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		  cm.getBtnEliminacionCliente().setEnabled(false);
		  cm.getBtnModificacionCliente().setEnabled(false);
		  Connection cn = Connections.getConnection();
		  
		  if(row>=0) {
			  Long Id = (Long) cm.getTable().getValueAt(row, 0);
			  cliente=this.BuscarCliente(Id);
			  int respuesta = JOptionPane.showConfirmDialog(null, "Desea eliminar al cliente "+cliente.getNombre()+" "+cliente.getApellido()+"?", "Waring", JOptionPane.YES_OPTION);
			  if(respuesta == 0) {
				  ClienteDAO clienteDAO = ClienteFactory.getClienteDAO("Sql");
				  PasaporteDAO pasaImple = PasaporteFactory.getPasaporteDAO("Sql");
				  TelefonoDAO teleImple = TelefonoFactory.getTelefonoDAO("Sql");
				  PasajeroFrecuenteDAO pasaFreImple = PasajeroFrecuenteFactory.getPasajeroFrecuenteDAO("Sql");
				  DireccionDAO direImple = DireccionFactory.getDireccionDAO("Sql");
				  	try {
						if(clienteDAO.deleteCliente(cliente, cn) && pasaImple.deletePasaporte(cliente, cn) && teleImple.deleteTelefono(cliente, cn) && pasaFreImple.deletePasajeroFrecuente(cliente, cn) && direImple.deleteDireccion(cliente, cn)) {
							Connections.Commit(cn);
							JOptionPane.showMessageDialog(null, "Se elimino con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
						}else {
							Connections.RollBack(cn);
							JOptionPane.showMessageDialog(null, "No se pudo Eliminar", "Fracaso", JOptionPane.INFORMATION_MESSAGE);
						}
					} catch (HeadlessException | IOException | DAOException | SQLException e) {
							JOptionPane.showMessageDialog(null, "Error al eliminar el cliente"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
					}
			  }
		  }
	  }
	  
	  public Clientes BuscarCliente(Long Id) {
		  ClienteDAO clienteDAO = ClienteFactory.getClienteDAO("Sql");
		  Connection cn = Connections.getConnection();
		  try {
			clienteL = clienteDAO.getAllClientes(cn);
		} catch (IOException | DAOException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al cargar datos del cliente"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		  for(Clientes cl:clienteL) {
			 if(cl.getIdCliente()==Id) {
				 return cl;
			 }
		  }
		return null;
	  }
	  
	  public void ModificarCliente() {
		  int row = cm.getTable().getSelectedRow();
		  cm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		  cm.getBtnEliminacionCliente().setEnabled(false);
		  cm.getBtnModificacionCliente().setEnabled(false);
		  if(row>=0) {
			  cu = new ClienteUpdate(this);
			  Long Id =  (Long) cm.getTable().getValueAt(row, 0);
			  cliente = this.BuscarCliente(Id);
			  this.setDatoUpdate(this.cu, cliente);
		  }else {
				JOptionPane.showMessageDialog(null, "No se selecciono ningun Cliente", "Error", JOptionPane.ERROR_MESSAGE);
			}
		  this.LimpiarTable(cm.getTable());
		  this.CargarTable(cm.getTable());
	  }
	  
	  private void setDatoUpdate(ClienteUpdate cu, Clientes c) {
		  cu.getTxtNombre().setText(c.getNombre());
		  cu.getTxtApellido().setText(c.getApellido());
		  cu.getTextCuit().setText(c.getCuit());
		  cu.getTxtDni().setText(c.getDni());
		  cu.getTextEmail().setText(c.getEmail());
		  cu.getDateChooserCliente().setDate(convertir.convertToDatabaseColumn(c.getFechaNacimiento()));
		  cu.getTextCalle().setText(c.getDireccion().getCalle());
		  cu.getTextAltura().setText(c.getDireccion().getAltura());
		  cu.getTextCiudad().setText(c.getDireccion().getCiudad());
		  cu.getTextCp().setText(c.getDireccion().getCodigoPostal());
		  cu.getComboBoxPais().setSelectedIndex(UtilGeneral.getNumPais(c.getDireccion().getPais().getIdPais()));
		  if(c.getDireccion().getPais().getIdPais() == 9) {
			this.CargarPronvincias(cu.getComboBoxProvincia());
			cu.getComboBoxProvincia().setSelectedIndex(UtilGeneral.getNumProvincia(c.getDireccion().getProvincia().getIdProvincia()));
		  }
		  cu.getTextFieldNumPasaporte().setText(c.getPasaporte().getNumeroPasaporte());
		  cu.getTextAutoridadEmision().setText(c.getPasaporte().getAutoridadEmision());
		  cu.getDateChooserEmisionP().setDate(convertir.convertToDatabaseColumn(c.getPasaporte().getFechaEmision()));
		  cu.getDateChooserVencimientoP().setDate(convertir.convertToDatabaseColumn(c.getPasaporte().getFechaVencimiento()));
		  cu.getComboBoxOrigenP().setSelectedIndex(UtilGeneral.getNumPais(c.getPasaporte().getPais().getIdPais()));
		  cu.getTextCelular().setText(c.getTelefono().getNumeroCelular());
		  cu.getTextLaboral().setText(c.getTelefono().getNumeroLaboral());
		  cu.getTextPersonal().setText(c.getTelefono().getNumeroPersonal());
		  cu.getTextAlianza().setText(c.getPasajerofrecuente().getAlianza());
		  cu.getTextCategoria().setText(c.getPasajerofrecuente().getCategoria());
		  cu.getComboBoxAerolinea().setSelectedIndex(UtilGeneral.getNumAerolinea(c.getPasajerofrecuente().getAerolinea().getIdAerolinea()));
		  
	  }
	 
	  public JComboBox<Paises> CargarPaises(JComboBox<Paises> Combopais){
		    PaisDAO paisImp = PaisFactory.getPaiDAO("Sql");
			Connection con = Connections.getConnection();
			List<Paises> paises = null;
			try {
				paises = paisImp.getAllPaises(con);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al cargar datos"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			for(Paises p: paises) {
				Combopais.addItem(p);
				}
			return Combopais;
	  }
	 
	  public JComboBox<Provincias> CargarPronvincias(JComboBox<Provincias> Comboprovincia){
		    ProvinciaDAO provinciaImp = ProvinciaFactory.getProvinciaDAO("Sql");
			Connection con = Connections.getConnection();
			List<Provincias> provincias = null;
			try {
				provincias = provinciaImp.getAllProvincias(con);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al cargar datos"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			for(Provincias p : provincias) {
				Comboprovincia.addItem(p);
				}
			return Comboprovincia;
	  }
	  
	  public JComboBox<Aerolineas> CargarAerolineas(JComboBox<Aerolineas> Comboaerolineas){
		    AerolineaDAO aerolineaImp = AerolineaFactory.getAerolineaDAO("Sql");
			Connection con = Connections.getConnection();
			List<Aerolineas> aerolineas = null;
			try {
				aerolineas = aerolineaImp.getAllAerolineas(con);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al cargar datos"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			for(Aerolineas a : aerolineas) {
				Comboaerolineas.addItem(a);
				}
			return Comboaerolineas;
	  }
	  
	  public JComboBox<Provincias> LimpiarProvincias(JComboBox<Provincias> Comboprovincia) {
			int cant=Comboprovincia.getItemCount();
			if(cant == 0) {
				return Comboprovincia;
			}
			Comboprovincia.removeAllItems();
			return Comboprovincia;
		}
	  
	  private void LimpiarTable(JTable table) {
		  DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		  int filas = table.getRowCount()-1;
		  for(int i=0; i<=filas; i++) {
			  modelo.removeRow(0);
		  }
		  cm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  cm.getBtnEliminacionCliente().setEnabled(true);
		  cm.getBtnModificacionCliente().setEnabled(true);
	  }
	  
	  public void QueryCliente() {
		  ClienteDAO clienteImple = ClienteFactory.getClienteDAO("Sql");
		  Connection con = Connections.getConnection();
		  String Id = JOptionPane.showInputDialog("Ingrese Id del Cliente");
		  try {
			cliente = clienteImple.queryCliente(Integer.valueOf(Id), con);
			JOptionPane.showMessageDialog(null, "Cliete: " +cliente.toString());
		} catch (NumberFormatException | IOException | DAOException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar el cliente"+ e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		  
	  }

	  public void CancelarAlta(ClienteAlta ca) {
		  ca.dispose();
		  cm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.LimpiarTable(cm.getTable());
		  this.CargarTable(cm.getTable());
	  }

	  private boolean GuardarCliente(ClienteAlta ac) {
		  Clientes c = new Clientes();
		
		  c.setNombre(ac.getTxtNombre().getText());
		  c.setApellido(ac.getTxtApellido().getText());
		  c.setCuit(ac.getTextCuit().getText());
		  c.setDni(ac.getTextCuit().getText());
		  c.setEmail(ac.getTextEmail().getText());
		  c.setFechaNacimiento(convertir.convertToEntityAttribute((Date)ac.getDateChooserCliente().getDate()));
		  
		  Direcciones d = new Direcciones();
		  
		  d.setCalle(ac.getTextCalle().getText());
		  d.setAltura(ac.getTextAltura().getText());
		  d.setCiudad(ac.getTextCiudad().getText());
		  d.setCodigoPostal(ac.getTextCp().getText());
		  d.setPais((Paises) ac.getComboBoxPais().getSelectedItem());
		  d.setProvincia((Provincias) ac.getComboBoxProvincia().getSelectedItem());
		  
		  Pasaportes p = new Pasaportes();
		  
		  p.setNumeroPasaporte(ac.getTextFieldNumPasaporte().getText());
		  p.setAutoridadEmision(ac.getTextAutoridadEmision().getText());
		  p.setFechaEmision(convertir.convertToEntityAttribute((Date) ac.getDateChooserEmisionP().getDate()));
		  p.setFechaVencimiento(convertir.convertToEntityAttribute((Date) ac.getDateChooserVencimientoP().getDate()));
		  p.setPais((Paises) ac.getComboBoxOrigenP().getSelectedItem());
		  
		  Telefonos t = new Telefonos();
		  t.setNumeroCelular(ac.getTextCelular().getText());
		  t.setNumeroLaboral(ac.getTextLaboral().getText());
		  t.setNumeroPersonal(ac.getTextPersonal().getText());
		  
		  PasajerosFrecuentes ps = new PasajerosFrecuentes();
		  ps.setAlianza(ac.getTextAlianza().getText());
		  ps.setCategoria(ac.getTextCategoria().getText());
		  ps.setAerolinea((Aerolineas) ac.getComboBoxAerolinea().getSelectedItem());
		  
		  c.setDireccion(d);
		  c.setPasaporte(p);
		  c.setPasajerofrecuente(ps);
		  c.setTelefono(t);
		  
		  if(!this.ClienteCompleto(c)) {
			  return false;
		  }
		  ClienteDAO clienteImple = ClienteFactory.getClienteDAO("Sql");
		  PasaporteDAO pasaImple = PasaporteFactory.getPasaporteDAO("Sql");
		  TelefonoDAO teleImple = TelefonoFactory.getTelefonoDAO("Sql");
		  PasajeroFrecuenteDAO pasaFreImple = PasajeroFrecuenteFactory.getPasajeroFrecuenteDAO("Sql");
		  DireccionDAO direImple = DireccionFactory.getDireccionDAO("Sql");
		  Connection con = Connections.getConnection();
		  
		  try {
			if(clienteImple.addCliente(c, con) && pasaImple.addPasaporte(c, con) && pasaFreImple.addPasajeroFrecuente(c, con) && teleImple.addTelefono(c, con) &&
						direImple.addDireccion(c, con)){ 
					Connections.Commit(con);
					return true;
				}
			else {
				Connections.RollBack(con);
				return false;
			}
		} catch (IOException | DAOException | SQLException e) {
			JOptionPane.showMessageDialog(null,"Error al guardar el Cliente: "+e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		 return false; 
	  }
	  
	  private boolean ClienteCompleto(Clientes c) {
		  if(c.getNombre()==null || c.getApellido()==null || c.getCuit()==null || c.getDireccion()==null || c.getDni()==null || c.getEmail()==null || c.getFechaNacimiento()==null || c.getIdCliente()==null || c.getPasajerofrecuente()==null || c.getPasaporte()==null || c.getTelefono()==null) {
			  return false;
		  }
		  return true;
	  }

	  public void AltaClienteFormulario(ClienteAlta ac) {
		  if(this.GuardarCliente(ac)) {
			  ca.setVisible(false);
			  JOptionPane.showMessageDialog(null,"Se agrego Cliente con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
			  cm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  this.LimpiarTable(cm.getTable());
			  this.CargarTable(cm.getTable());
			}else {
				JOptionPane.showMessageDialog(null,"No se pudo agregar", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
	  }

	  public void CancelarUpdate(ClienteUpdate uc) {
		  uc.dispose();
		  cm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  this.LimpiarTable(cm.getTable());
		  this.CargarTable(cm.getTable());
	  }
	  
	  public void UpdateCliente(ClienteUpdate uc) {
		  Clientes c = new Clientes();
			
		  c.setNombre(uc.getTxtNombre().getText());
		  c.setApellido(uc.getTxtApellido().getText());
		  c.setCuit(uc.getTextCuit().getText());
		  c.setDni(uc.getTextCuit().getText());
		  c.setEmail(uc.getTextEmail().getText());
		  c.setFechaNacimiento(convertir.convertToEntityAttribute((Date)uc.getDateChooserCliente().getDate()));
		  
		  Direcciones d = new Direcciones();
		  
		  d.setCalle(uc.getTextCalle().getText());
		  d.setAltura(uc.getTextAltura().getText());
		  d.setCiudad(uc.getTextCiudad().getText());
		  d.setCodigoPostal(uc.getTextCp().getText());
		  d.setPais((Paises) uc.getComboBoxPais().getSelectedItem());
		  d.setProvincia((Provincias) uc.getComboBoxProvincia().getSelectedItem());
		  
		  Pasaportes p = new Pasaportes();
		  
		  p.setNumeroPasaporte(uc.getTextFieldNumPasaporte().getText());
		  p.setAutoridadEmision(uc.getTextAutoridadEmision().getText());
		  p.setFechaEmision(convertir.convertToEntityAttribute((Date) uc.getDateChooserEmisionP().getDate()));
		  p.setFechaVencimiento(convertir.convertToEntityAttribute((Date) uc.getDateChooserVencimientoP().getDate()));
		  p.setPais((Paises) uc.getComboBoxOrigenP().getSelectedItem());
		  
		  Telefonos t = new Telefonos();
		  t.setNumeroCelular(uc.getTextCelular().getText());
		  t.setNumeroLaboral(uc.getTextLaboral().getText());
		  t.setNumeroPersonal(uc.getTextPersonal().getText());
		  
		  PasajerosFrecuentes ps = new PasajerosFrecuentes();
		  ps.setAlianza(uc.getTextAlianza().getText());
		  ps.setCategoria(uc.getTextCategoria().getText());
		  ps.setAerolinea((Aerolineas) uc.getComboBoxAerolinea().getSelectedItem());
		  
		  c.setDireccion(d);
		  c.setPasaporte(p);
		  c.setPasajerofrecuente(ps);
		  c.setTelefono(t);
		  
		  if(this.ClienteCompleto(c)) {
			  ClienteDAO clienteImple = ClienteFactory.getClienteDAO("Sql");
			  PasaporteDAO pasaImple = PasaporteFactory.getPasaporteDAO("Sql");
			  TelefonoDAO teleImple = TelefonoFactory.getTelefonoDAO("Sql");
			  PasajeroFrecuenteDAO pasaFreImple = PasajeroFrecuenteFactory.getPasajeroFrecuenteDAO("Sql");
			  DireccionDAO direImple = DireccionFactory.getDireccionDAO("Sql");
			  Connection con = Connections.getConnection();
			  
			  try {
				if(clienteImple.updateCliente(c, con) && pasaImple.updatePasaporte(c, con) && pasaFreImple.updatePasajeroFrecuente(c, con) && teleImple.updateTelefono(c, con) &&
							direImple.updateDireccion(c, con)){ 
						JOptionPane.showMessageDialog(null, "Se modifico con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
						uc.setVisible(true);
						cm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						this.LimpiarTable(cm.getTable());
						this.CargarTable(cm.getTable());
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo Modificar", "Fracaso", JOptionPane.INFORMATION_MESSAGE);
					}
			} catch (HeadlessException | IOException | DAOException | SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al modificar "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		  }
		  
	  }
}

