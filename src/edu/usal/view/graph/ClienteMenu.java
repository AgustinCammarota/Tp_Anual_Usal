package edu.usal.view.graph;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import edu.usal.controler.graph.MenuClienteController;
import edu.usal.eventos.graph.MenuClienteEventos;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;

public class ClienteMenu extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnAltaCliente;
	private JButton btnModificacionCliente;
	private JButton btnEliminacionCliente;
	private JButton btnConsultaCliente;
	MenuClienteController mcc;
	private ListSelectionModel listSelectionModel;


	public ClienteMenu(MenuClienteController mcc) {
		this.mcc = mcc;
		
		setBounds(100, 100, 489, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Toolkit pantalla=Toolkit.getDefaultToolkit();
		Dimension Tpantalla = pantalla.getScreenSize();
		int altura = Tpantalla.height;
		int ancho = Tpantalla.width;
		setLocation(ancho/4, altura/4);
		setSize(600,400);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		btnAltaCliente = new JButton("Alta");
		btnAltaCliente.addActionListener(new MenuClienteEventos(this));
		
		btnModificacionCliente = new JButton("Modificacion");
		btnModificacionCliente.addActionListener(new MenuClienteEventos(this));
		btnModificacionCliente.setEnabled(false);
		
		btnEliminacionCliente = new JButton("Eliminacion");
		btnEliminacionCliente.addActionListener(new MenuClienteEventos(this));
		btnEliminacionCliente.setEnabled(false);
		
		btnConsultaCliente = new JButton("Consulta");
		btnConsultaCliente.addActionListener(new MenuClienteEventos(this));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAltaCliente, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnModificacionCliente, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnEliminacionCliente, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnConsultaCliente, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnModificacionCliente, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(btnAltaCliente, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(btnEliminacionCliente, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(btnConsultaCliente, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
		);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setForeground(Color.GRAY);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id_Cliente", "Nombre", "Apellido", "Fecha_Nacimiento", "DNI", "CUIT", "Email", "Calle",
						"Altura", "CP", "Ciudad", "Pais", "Provincia", "N°Pasaporte", "Autoridad_Emision",
						"Fecha_Emision", "Fecha_Vencimiento", "Origen", "N°Personal", "N°Celular", "N°Laboral",
						"Alianza", "Categoria", "Aerolinea" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(50);
		table.getColumnModel().getColumn(9).setPreferredWidth(50);
		table.getColumnModel().getColumn(10).setPreferredWidth(150);
		table.getColumnModel().getColumn(11).setPreferredWidth(150);
		table.getColumnModel().getColumn(12).setPreferredWidth(100);
		table.getColumnModel().getColumn(13).setPreferredWidth(100);
		table.getColumnModel().getColumn(14).setPreferredWidth(150);
		table.getColumnModel().getColumn(15).setPreferredWidth(100);
		table.getColumnModel().getColumn(16).setPreferredWidth(150);
		table.getColumnModel().getColumn(17).setPreferredWidth(100);
		table.getColumnModel().getColumn(18).setPreferredWidth(150);
		table.getColumnModel().getColumn(19).setPreferredWidth(150);
		table.getColumnModel().getColumn(20).setPreferredWidth(150);
		table.getColumnModel().getColumn(21).setPreferredWidth(100);
		table.getColumnModel().getColumn(22).setPreferredWidth(100);
		table.getColumnModel().getColumn(23).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		table = mcc.CargarTable(table);
		listSelectionModel = table.getSelectionModel();
		listSelectionModel.addListSelectionListener(new MenuClienteEventos(this));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(gl_contentPane);
	}

	

	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public ListSelectionModel getListSelectionModel() {
		return listSelectionModel;
	}
	public void setListSelectionModel(ListSelectionModel listSelectionModel) {
		this.listSelectionModel = listSelectionModel;
	}
	public MenuClienteController getMcc() {
		return mcc;
	}
	public void setMcc(MenuClienteController mcc) {
		this.mcc = mcc;
	}
	public JButton getBtnAltaCliente() {
		return btnAltaCliente;
	}
	public void setBtnAltaCliente(JButton btnAltacliente) {
		this.btnAltaCliente = btnAltacliente;
	}
	public JButton getBtnModificacionCliente() {
		return btnModificacionCliente;
	}
	public void setBtnModificacionCliente(JButton btnModificacionCliente) {
		this.btnModificacionCliente = btnModificacionCliente;
	}
	public JButton getBtnEliminacionCliente() {
		return btnEliminacionCliente;
	}
	public void setBtnEliminacionCliente(JButton btnEliminacionCliente) {
		this.btnEliminacionCliente = btnEliminacionCliente;
	}
	public JButton getBtnConsultaCliente() {
		return btnConsultaCliente;
	}
	public void setBtnConsultaCliente(JButton btnConsultaCliente) {
		this.btnConsultaCliente = btnConsultaCliente;
	}
}
