package edu.usal.eventos.graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import edu.usal.view.graph.ClienteAlta;

public class MenuAltaClientesEventos implements ActionListener, ItemListener {
	ClienteAlta ca;
	
	public MenuAltaClientesEventos(ClienteAlta ca) {
		this.ca=ca;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(ca.getBtnGuardarCliente())) {
			ca.getMcc().AltaClienteFormulario(ca);
		}
		if(e.getSource().equals(ca.getBtnCancelar())) {
			ca.getMcc().CancelarAlta(ca);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int num = ca.getComboBoxPais().getSelectedIndex();
		if(num == 9) {
			ca.setComboBoxProvincia(ca.getMcc().CargarPronvincias(ca.getComboBoxProvincia()));
		}else {
			ca.setComboBoxProvincia(ca.getMcc().LimpiarProvincias(ca.getComboBoxProvincia()));
		}
	}

}
