package pe.proyecto.entity;

public class PedidoMenu {
	
	private Pedido pedido;
	private Menu menu;
	
	public PedidoMenu(Pedido pedido, Menu menu) {
		this.pedido = pedido;
		this.menu = menu;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
	

	
}
