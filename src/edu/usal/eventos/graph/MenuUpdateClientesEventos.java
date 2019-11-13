package edu.usal.eventos.graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import edu.usal.view.graph.ClienteUpdate;

public class MenuUpdateClientesEventos implements ItemListener, ActionListener {
	ClienteUpdate cu;
	
	public MenuUpdateClientesEventos(ClienteUpdate cu) {
		this.cu=cu;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		int num = cu.getComboBoxPais().getSelectedIndex();
		if(num == 9) {
			cu.setComboBoxProvincia(cu.getMcc().CargarPronvincias(cu.getComboBoxProvincia()));
		}else {
			cu.setComboBoxProvincia(cu.getMcc().LimpiarProvincias(cu.getComboBoxProvincia()));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(cu.getBtnCancelar())) {
			cu.getMcc().CancelarUpdate(cu);
		}
		if(e.getSource().equals(cu.getBtnGuardarCliente())) {
			cu.getMcc().UpdateCliente(cu);
		}
	}

}
