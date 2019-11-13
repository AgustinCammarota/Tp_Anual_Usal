package edu.usal.eventos.graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import edu.usal.view.graph.ClienteMenu;

public class MenuClienteEventos implements ActionListener, ListSelectionListener {
	ClienteMenu vista;
	
	public MenuClienteEventos(ClienteMenu vista) {
		this.vista = vista;
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource().equals(vista.getListSelectionModel())) {
			int row = vista.getTable().getSelectedRow();
			if(row>=0) {
				vista.getMcc().HabilitarBotonoes();
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(vista.getBtnAltaCliente())) {
			vista.getMcc().AltaCliente();
			}
		if(e.getSource().equals(vista.getBtnEliminacionCliente())) {
			vista.getMcc().EliminarCliente();
		}
		if(e.getSource().equals(vista.getBtnModificacionCliente())) {
			vista.getMcc().ModificarCliente();
		}
		if(e.getSource().equals(vista.getBtnConsultaCliente())) {
			vista.getMcc().QueryCliente();
		}
		}
		
	}

