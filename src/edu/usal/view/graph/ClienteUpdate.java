package edu.usal.view.graph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import edu.usal.controler.graph.MenuClienteController;
import edu.usal.eventos.graph.MenuAltaClientesEventos;
import edu.usal.eventos.graph.MenuUpdateClientesEventos;
import edu.usal.negocio.dominio.Aerolineas;
import edu.usal.negocio.dominio.Paises;
import edu.usal.negocio.dominio.Provincias;

public class ClienteUpdate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField textCuit;
	private JTextField textEmail;
	private JTextField textCalle;
	private JTextField textAltura;
	private JTextField textCiudad;
	private JTextField textFieldNumPasaporte;
	private JTextField textAutoridadEmision;
	private JTextField textPersonal;
	private JTextField textLaboral;
	private JTextField textCelular;
	private JTextField textAlianza;
	private JTextField textCategoria;
	private JTextField textCp;
	private JComboBox<Paises> comboBoxPais;
	private JComboBox<Provincias> comboBoxProvincia;
	private JComboBox<Paises> comboBoxOrigenP;
	private JComboBox<Aerolineas> comboBoxAerolinea; 
	private JButton btnGuardarCliente;
	private JButton btnCancelar;
	private JDateChooser dateChooserCliente;
	private JDateChooser dateChooserEmisionP;
	private JDateChooser dateChooserVencimientoP;
	MenuClienteController mcc;


	public ClienteUpdate(MenuClienteController mcc) {
		this.mcc = mcc;
		
		setType(Type.UTILITY);
		getContentPane().setForeground(Color.GRAY);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(null);
		setFont(new Font("Arial", Font.PLAIN, 12));
		Toolkit pantalla=Toolkit.getDefaultToolkit();
		Dimension Tpantalla = pantalla.getScreenSize();
		int altura = Tpantalla.height;
		int ancho = Tpantalla.width;
		setLocation(ancho/4, altura/4);
		setSize(1100,400);
		setTitle("UpdateCliente");
		
		JLabel lblNombre = new JLabel("Nombre");
		
		JLabel lblApellido = new JLabel("Apellido");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		
		JLabel lblCuit = new JLabel("CUIT");
		
		textCuit = new JTextField();
		textCuit.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		
		dateChooserCliente = new JDateChooser();
		
		JLabel lblCalle = new JLabel("Calle");
		
		textCalle = new JTextField();
		textCalle.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura");
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		
		textCiudad = new JTextField();
		textCiudad.setColumns(10);
		
		JLabel lblCp = new JLabel("CP");
		textCp = new JTextField();
		textCp.setColumns(10);
		
		JLabel lblPais = new JLabel("Pais");
		
		comboBoxPais = new JComboBox<Paises>();
		comboBoxPais = mcc.CargarPaises(comboBoxPais);
		comboBoxPais.addItemListener(new MenuUpdateClientesEventos(this));
		
		JLabel lblProvincia = new JLabel("Provincia");
		
		comboBoxProvincia = new JComboBox<Provincias>();
		comboBoxProvincia = mcc.CargarPronvincias(comboBoxProvincia);
		
		JLabel lblNPasaporte = new JLabel("N\u00B0 Pasaporte");
		
		textFieldNumPasaporte = new JTextField();
		textFieldNumPasaporte.setColumns(10);
		
		JLabel lblEmitido = new JLabel("Emitido");
		
		textAutoridadEmision = new JTextField();
		textAutoridadEmision.setColumns(10);
		
		JLabel lblFechaEmision = new JLabel("Fecha Emision");
		
		dateChooserEmisionP = new JDateChooser();
		
		JLabel lblFechaVencimiento = new JLabel("Fecha Vencimiento");
		
		dateChooserVencimientoP = new JDateChooser();
		
		JLabel lblOrigen = new JLabel("Origen");
		
		comboBoxOrigenP = new JComboBox<Paises>();
		comboBoxOrigenP = mcc.CargarPaises(comboBoxOrigenP);
		
		JLabel lblNpersonal = new JLabel("N\u00B0Personal");
		
		textPersonal = new JTextField();
		textPersonal.setColumns(10);
		
		JLabel lblNlaboral = new JLabel("N\u00B0Laboral");
		
		textLaboral = new JTextField();
		textLaboral.setColumns(10);
		
		JLabel lblNcelular = new JLabel("N\u00B0Celular");
		
		textCelular = new JTextField();
		textCelular.setColumns(10);
		
		JLabel lblAlianza = new JLabel("Alianza");
		
		textAlianza = new JTextField();
		textAlianza.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria");
		
		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		
		JLabel lblAerolinea = new JLabel("Aerolinea");
		
		comboBoxAerolinea = new JComboBox<Aerolineas>();
		comboBoxAerolinea = mcc.CargarAerolineas(comboBoxAerolinea);
		
		btnGuardarCliente = new JButton("Guardar Cliente");
		btnGuardarCliente.addActionListener(new MenuUpdateClientesEventos(this));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new MenuUpdateClientesEventos(this));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDni)
										.addComponent(lblCalle)
										.addComponent(lblPais)
										.addComponent(lblEmitido)
										.addComponent(lblOrigen)
										.addComponent(lblAlianza))
									.addGap(14))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(textAlianza, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(comboBoxOrigenP, Alignment.LEADING, 0, 142, Short.MAX_VALUE)
								.addComponent(textAutoridadEmision, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(comboBoxPais, Alignment.LEADING, 0, 142, Short.MAX_VALUE)
								.addComponent(textCalle, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(txtDni, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
								.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCategoria)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textCategoria, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNpersonal)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textPersonal, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNlaboral)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textLaboral, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFechaEmision)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dateChooserEmisionP, GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblProvincia)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBoxProvincia, 0, 233, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAltura)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textAltura, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblApellido)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtApellido, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblEmail)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textEmail, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblAerolinea, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBoxAerolinea, 0, 225, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCuit)
									.addGap(10)
									.addComponent(textCuit, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFechaNacimiento)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dateChooserCliente, 0, 0, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblFechaVencimiento)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(dateChooserVencimientoP, 0, 0, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNPasaporte)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textFieldNumPasaporte, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(58)
									.addComponent(lblNcelular)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textCelular, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCiudad)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textCiudad, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblCp)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textCp, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnGuardarCliente, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
							.addGap(49)
							.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnGuardarCliente, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addGap(68))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellido)
								.addComponent(txtApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCuit)
								.addComponent(textCuit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(dateChooserCliente, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEmail)
							.addComponent(lblDni)
							.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textEmail, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addComponent(lblFechaNacimiento)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCalle)
						.addComponent(textCalle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAltura)
						.addComponent(textAltura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCiudad)
						.addComponent(textCiudad, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textCp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCp))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPais)
						.addComponent(comboBoxPais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProvincia)
						.addComponent(comboBoxProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNumPasaporte, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNPasaporte))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblEmitido)
						.addComponent(lblFechaEmision)
						.addComponent(textAutoridadEmision, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaVencimiento, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(dateChooserEmisionP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(dateChooserVencimientoP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOrigen)
						.addComponent(comboBoxOrigenP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNpersonal)
						.addComponent(lblNcelular)
						.addComponent(textCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPersonal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textLaboral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNlaboral))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAlianza)
						.addComponent(textAlianza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCategoria)
						.addComponent(textCategoria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAerolinea)
						.addComponent(comboBoxAerolinea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(15))
		);
		groupLayout.setAutoCreateContainerGaps(true);
		getContentPane().setLayout(groupLayout);
		setMinimumSize ( new Dimension ( 600, 360 ) );

	}

	public JButton getBtnGuardarCliente() {
		return btnGuardarCliente;
	}
	public void setBtnGuardarCliente(JButton btnGuardarCliente) {
		this.btnGuardarCliente = btnGuardarCliente;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
	public MenuClienteController getMcc() {
		return mcc;
	}
	public void setMcc(MenuClienteController mcc) {
		this.mcc = mcc;
	}
	public JTextField getTxtNombre() {
		return txtNombre;
	}
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}
	public JTextField getTxtApellido() {
		return txtApellido;
	}
	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}
	public JTextField getTxtDni() {
		return txtDni;
	}
	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}
	public JTextField getTextCuit() {
		return textCuit;
	}
	public void setTextCuit(JTextField textCuit) {
		this.textCuit = textCuit;
	}
	public JTextField getTextEmail() {
		return textEmail;
	}
	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}
	public JTextField getTextCalle() {
		return textCalle;
	}
	public void setTextCalle(JTextField textCalle) {
		this.textCalle = textCalle;
	}
	public JTextField getTextAltura() {
		return textAltura;
	}
	public void setTextAltura(JTextField textAltura) {
		this.textAltura = textAltura;
	}
	public JTextField getTextCiudad() {
		return textCiudad;
	}
	public void setTextCiudad(JTextField textCiudad) {
		this.textCiudad = textCiudad;
	}
	public JTextField getTextFieldNumPasaporte() {
		return textFieldNumPasaporte;
	}
	public void setTextFieldNumPasaporte(JTextField textFieldNumPasaporte) {
		this.textFieldNumPasaporte = textFieldNumPasaporte;
	}
	public JTextField getTextAutoridadEmision() {
		return textAutoridadEmision;
	}
	public void setTextAutoridadEmision(JTextField textAutoridadEmision) {
		this.textAutoridadEmision = textAutoridadEmision;
	}
	public JTextField getTextPersonal() {
		return textPersonal;
	}
	public void setTextPersonal(JTextField textPersonal) {
		this.textPersonal = textPersonal;
	}
	public JTextField getTextLaboral() {
		return textLaboral;
	}
	public void setTextLaboral(JTextField textLaboral) {
		this.textLaboral = textLaboral;
	}
	public JTextField getTextCelular() {
		return textCelular;
	}
	public void setTextCelular(JTextField textCelular) {
		this.textCelular = textCelular;
	}
	public JTextField getTextAlianza() {
		return textAlianza;
	}
	public void setTextAlianza(JTextField textAlianza) {
		this.textAlianza = textAlianza;
	}
	public JTextField getTextCategoria() {
		return textCategoria;
	}
	public void setTextCategoria(JTextField textCategoria) {
		this.textCategoria = textCategoria;
	}
	public JComboBox<Paises> getComboBoxPais() {
		return comboBoxPais;
	}
	public void setComboBoxPais(JComboBox<Paises> comboBoxPais) {
		this.comboBoxPais = comboBoxPais;
	}
	public JComboBox<Provincias> getComboBoxProvincia() {
		return comboBoxProvincia;
	}
	public void setComboBoxProvincia(JComboBox<Provincias> comboBoxProvincia) {
		this.comboBoxProvincia = comboBoxProvincia;
	}
	public JComboBox<Paises> getComboBoxOrigenP() {
		return comboBoxOrigenP;
	}
	public void setComboBoxOrigenP(JComboBox<Paises> comboBoxOrigenP) {
		this.comboBoxOrigenP = comboBoxOrigenP;
	}
	public JComboBox<Aerolineas> getComboBoxAerolinea() {
		return comboBoxAerolinea;
	}
	public void setComboBoxAerolinea(JComboBox<Aerolineas> comboBoxAerolinea) {
		this.comboBoxAerolinea = comboBoxAerolinea;
	}
	public JDateChooser getDateChooserCliente() {
		return dateChooserCliente;
	}
	public void setDateChooserCliente(JDateChooser dateChooserCliente) {
		this.dateChooserCliente = dateChooserCliente;
	}
	public JDateChooser getDateChooserEmisionP() {
		return dateChooserEmisionP;
	}
	public void setDateChooserEmisionP(JDateChooser dateChooserEmisionP) {
		this.dateChooserEmisionP = dateChooserEmisionP;
	}
	public JDateChooser getDateChooserVencimientoP() {
		return dateChooserVencimientoP;
	}
	public void setDateChooserVencimientoP(JDateChooser dateChooserVencimientoP) {
		this.dateChooserVencimientoP = dateChooserVencimientoP;
	}
	public JTextField getTextCp() {
		return textCp;
	}
	public void setTextCp(JTextField textCp) {
		this.textCp = textCp;
	}
}
