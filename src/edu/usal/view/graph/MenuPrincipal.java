package edu.usal.view.graph;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import edu.usal.controler.graph.MenuPrincipalController;
import edu.usal.eventos.graph.PrincipalEventos;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	MenuPrincipalController mpc;
	private JButton btnMenuCliente;
	private JButton btnMenuVuelo;
	private JButton btnMenuVenta;
	private JButton btnMenuLineasAereas;
	private JLabel lblProgramaUsal;
	
	public MenuPrincipal(MenuPrincipalController mpc) {
		this.mpc=mpc;
		setTitle("Menu");
		setLocationRelativeTo(null);
		setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		btnMenuCliente = new JButton("Menu Cliente");
		btnMenuCliente.addActionListener(new PrincipalEventos(this));
		contentPane.add(btnMenuCliente, BorderLayout.NORTH);
		
		btnMenuVuelo = new JButton("Menu Vuelo");
		contentPane.add(btnMenuVuelo, BorderLayout.WEST);
		
		btnMenuLineasAereas = new JButton("Menu Linea Aerea");
		contentPane.add(btnMenuLineasAereas, BorderLayout.SOUTH);
		
		btnMenuVenta = new JButton("Menu Venta");
		contentPane.add(btnMenuVenta, BorderLayout.EAST);
		
		lblProgramaUsal = new JLabel("Programa Universidad Del Salvador");
		lblProgramaUsal.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.ITALIC, 16));
		lblProgramaUsal.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblProgramaUsal, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
	
	public MenuPrincipalController getMpc() {
		return mpc;
	}

	public JButton getBtnMenuCliente() {
		return btnMenuCliente;
	}

	public void setBtnMenuCliente(JButton btnMenuCliente) {
		this.btnMenuCliente = btnMenuCliente;
	}

	public JButton getBtnMenuVuelo() {
		return btnMenuVuelo;
	}

	public void setBtnMenuVuelo(JButton btnMenuVuelo) {
		this.btnMenuVuelo = btnMenuVuelo;
	}

	public JButton getBtnMenuVenta() {
		return btnMenuVenta;
	}

	public void setBtnMenuVenta(JButton btnMenuVenta) {
		this.btnMenuVenta = btnMenuVenta;
	}

	public JButton getBtnMenuLineasAereas() {
		return btnMenuLineasAereas;
	}

	public void setBtnMenuLineasAereas(JButton btnMenuLineasAereas) {
		this.btnMenuLineasAereas = btnMenuLineasAereas;
	}

}
