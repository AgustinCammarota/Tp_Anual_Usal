package edu.usal.negocio.dao.implementacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.negocio.dominio.Clientes;
import edu.usal.negocio.dominio.Direcciones;
import edu.usal.negocio.dominio.Paises;
import edu.usal.negocio.dominio.PasajerosFrecuentes;
import edu.usal.negocio.dominio.Pasaportes;
import edu.usal.negocio.dominio.Provincias;
import edu.usal.negocio.dominio.Telefonos;
import edu.usal.util.DAOException;
import edu.usal.util.LocalDateConverter;

public class ClienteDAOImpSQL implements ClienteDAO {

	private static final String INSERT = "INSERT INTO clientes (nombre, apellido, dni, cuit, fecha_nacimiento, email) VALUES(?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE clientes SET nombre=?, apellido=?, dni=?, cuit=?, fecha_nacimiento=?, email=? WHERE id_cliente=?";
	private static final String DELETE = "DELETE FROM clientes WHERE id_cliente=?";
	private static final String GETALL = "SELECT clientes.id_cliente, nombre, apellido, dni, cuit, fecha_nacimiento, email, id_direccion, calle, altura, ciudad, codigo_postal, paises.id_pais, paises.nombre_pais, provincias.id_provincia ,nombre_provincia, id_pasaporte ,numero_pasaporte, autoridad_emision, fecha_emision, fecha_vencimiento, p.id_pais, p.nombre_pais, id_telefono, personal, celular, laboral, id_pasajero_frecuente, alianza, categoria, aerolineas.id_aerolinea, nombre_aerolinea from clientes inner join direcciones on direcciones.id_cliente = clientes.id_cliente inner join paises on paises.id_pais = direcciones.id_pais inner join provincias on provincias.id_provincia = direcciones.id_provincia inner join pasaportes on pasaportes.id_cliente = clientes.id_cliente inner join paises p on p.id_pais = pasaportes.id_pais inner join telefonos on telefonos.id_cliente=clientes.id_cliente inner join pasajeros_frecuentes on pasajeros_frecuentes.id_cliente = clientes.id_cliente inner join aerolineas on aerolineas.id_aerolinea = pasajeros_frecuentes.id_aerolinea";
	private static final String GETONE = "SELECT clientes.id_cliente, nombre, apellido, dni, cuit, fecha_nacimiento, email, id_direccion, calle, altura, ciudad, codigo_postal, paises.id_pais, paises.nombre_pais, provincias.id_provincia ,nombre_provincia, id_pasaporte ,numero_pasaporte, autoridad_emision, fecha_emision, fecha_vencimiento, p.id_pais, p.nombre_pais, id_telefono, personal, celular, laboral, id_pasajero_frecuente, alianza, categoria, aerolineas.id_aerolinea, nombre_aerolinea from clientes inner join direcciones on direcciones.id_cliente = clientes.id_cliente inner join paises on paises.id_pais = direcciones.id_pais inner join provincias on provincias.id_provincia = direcciones.id_provincia inner join pasaportes on pasaportes.id_cliente = clientes.id_cliente inner join paises p on p.id_pais = pasaportes.id_pais inner join telefonos on telefonos.id_cliente=clientes.id_cliente inner join pasajeros_frecuentes on pasajeros_frecuentes.id_cliente = clientes.id_cliente inner join aerolineas on aerolineas.id_aerolinea = pasajeros_frecuentes.id_aerolinea WHERE clientes.id_cliente=?";
	private static final LocalDateConverter convertir = new LocalDateConverter();

	// @Override
	public boolean addCliente(Clientes cliente, Connection con) throws DAOException, SQLException {
		con.setAutoCommit(false);
		PreparedStatement ps = null;
		ResultSet rs = null;

		ps = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, cliente.getNombre());
		ps.setString(2, cliente.getApellido());
		ps.setString(3, cliente.getDni());
		ps.setString(4, cliente.getCuit());
		ps.setDate(5, convertir.convertToDatabaseColumn(cliente.getFechaNacimiento()));
		ps.setString(6, cliente.getEmail());
		ps.executeUpdate();
		rs = ps.getGeneratedKeys();

		while (rs.next())
			cliente.setIdCliente((long) rs.getInt(1));

		if (ps.executeUpdate() > 0) {
			return true;
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

		return false;
	}

	@Override
	public boolean updateCliente(Clientes cliente, Connection con) throws DAOException, SQLException {
		PreparedStatement ps = null;

		ps = con.prepareStatement(UPDATE);
		ps.setString(1, cliente.getNombre());
		ps.setString(2, cliente.getApellido());
		ps.setString(3, cliente.getDni());
		ps.setString(4, cliente.getCuit());
		ps.setDate(5, convertir.convertToDatabaseColumn(cliente.getFechaNacimiento()));
		ps.setString(6, cliente.getEmail());

		if (ps.executeUpdate() > 0) {
			return true;
		}
		if (ps != null) {
			ps.close();
		}
		return false;
	}

	@Override
	public boolean deleteCliente(Clientes cliente, Connection con) throws DAOException, SQLException {
		PreparedStatement ps = null;
		con.setAutoCommit(false);

		ps = con.prepareStatement(DELETE);
		ps.setLong(1, cliente.getIdCliente());

		if (ps.executeUpdate() > 0) {
			return true;
		}
		if (ps != null) {
			ps.close();
		}
		return false;
	}

	private Clientes Convertir(ResultSet rs) throws SQLException {

		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");
		String dni = rs.getString("dni");
		String cuit = rs.getString("cuit");
		LocalDate fecha_nacimiento = convertir.convertToEntityAttribute(rs.getDate("fecha_nacimiento"));
		String email = rs.getString("email");

		String calle = rs.getString("calle");
		String altura = rs.getString("altura");
		String ciudad = rs.getString("ciudad");
		String codigoPostal = rs.getString("codigo_postal");

		String nombrePais = rs.getString("nombre_pais");
		Paises pais = new Paises(null, nombrePais);
		pais.setIdPais(Long.valueOf(rs.getInt("id_pais")));

		String nombreProvincia = rs.getString("nombre_provincia");
		Provincias provincia = new Provincias(null, nombreProvincia);
		provincia.setIdProvincia(Long.valueOf(rs.getInt("id_provincia")));

		Direcciones direccion = new Direcciones(calle, altura, ciudad, codigoPostal, pais, provincia, null);
		direccion.setIdDireccion(rs.getLong("id_direccion"));

		String numeroPasaporte = rs.getString("numero_pasaporte");
		String autoridadEmision = rs.getString("autoridad_emision");
		LocalDate fechaEmision = rs.getDate("fecha_emision").toLocalDate();
		LocalDate fechaVencimiento = rs.getDate("fecha_vencimiento").toLocalDate();

		Pasaportes pasaporte = new Pasaportes(numeroPasaporte, autoridadEmision, fechaEmision, fechaVencimiento, pais,
				null);
		pasaporte.setIdPasaporte(rs.getLong("id_pasaporte"));

		String personal = rs.getString("personal");
		String celular = rs.getString("celular");
		String laboral = rs.getString("laboral");

		Telefonos telefono = new Telefonos(personal, celular, laboral, null);
		telefono.setIdTelefono(rs.getLong("id_telefono"));

		String categoria = rs.getString("categoria");
		String alianza = rs.getString("alianza");

		String nombreAerolinea = rs.getString("nombre_aerolinea");
		Aerolineas aerolinea = new Aerolineas(null, nombreAerolinea);
		aerolinea.setIdAerolinea(Long.valueOf(rs.getInt("id_aerolinea")));

		PasajerosFrecuentes pasajero = new PasajerosFrecuentes(categoria, alianza, aerolinea, null);
		pasajero.setIdPasajeroFrecuente(rs.getLong("id_pasajero_frecuente"));

		Clientes cliente = new Clientes(nombre, apellido, dni, cuit, email, fecha_nacimiento, null, pasaporte, telefono,
				pasajero, direccion);
		cliente.setIdCliente(Long.valueOf(rs.getInt("id_cliente")));

		return cliente;

	}

	@Override

	public Clientes queryCliente(int Id, Connection con) throws DAOException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Clientes cliente = new Clientes();

		ps = con.prepareStatement(GETONE);
		ps.setInt(1, Id);
		rs = ps.executeQuery();
		if (rs.next()) {
			cliente = Convertir(rs);
		} else {
			throw new DAOException("NO SE ENCONTRO NINGUN REGISTRO");
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

		return cliente;
	}

	@Override
	public List<Clientes> getAllClientes(Connection con) throws DAOException, SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Clientes> cliente = new ArrayList<>();

		ps = con.prepareStatement(GETALL);
		rs = ps.executeQuery();
		while (rs.next()) {
			cliente.add(Convertir(rs));
		}
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}

		return cliente;
	}

}
