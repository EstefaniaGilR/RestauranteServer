package pe.proyecto.mapper;

public class PedidoMenuTextMapper {
	
	private String pedido;
	private String menu;
	
	public PedidoMenuTextMapper(String pedido, String menu) {
		this.pedido = pedido;
		this.menu = menu;
	}
	
	public PedidoMenuTextMapper(Object[] object) {
		this(object[0].toString(),
				object[1].toString());
	}


	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	

}
