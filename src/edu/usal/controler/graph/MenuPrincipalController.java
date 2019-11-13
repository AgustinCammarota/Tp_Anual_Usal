package edu.usal.controler.graph;


import edu.usal.view.graph.MenuPrincipal;

public class MenuPrincipalController {
	private MenuClienteController ControllerCliente;
	private MenuPrincipal vista;
	
	public MenuPrincipalController() {
		
	}
	
	public void EjecutarMenuPrincipal(){
		this.vista=new MenuPrincipal(this);
	}
	
	public void EjecutarMenuCliente() {
		this.vista.setVisible(false);
		setControllerCliente(new MenuClienteController(this));
	}

	public MenuClienteController getControllerCliente() {
		return ControllerCliente;
	}

	public void setControllerCliente(MenuClienteController controllerCliente) {
		ControllerCliente = controllerCliente;
	}
}
