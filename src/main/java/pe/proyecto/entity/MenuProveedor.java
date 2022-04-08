package pe.proyecto.entity;

public class MenuProveedor {
	
	private Menu menu;
	private Proveedor proveedor;
	
	public MenuProveedor(Menu menu, Proveedor proveedor) {
		this.menu = menu;
		this.proveedor = proveedor;
	}
	
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	

}
