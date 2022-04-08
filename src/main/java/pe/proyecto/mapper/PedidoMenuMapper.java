package pe.proyecto.mapper;

public class PedidoMenuMapper {
	
	private Integer pedidoId;
	private Integer menuId;
	
	public PedidoMenuMapper() {}

	public PedidoMenuMapper(Integer pedidoId, Integer menuId) {
		this.pedidoId = pedidoId;
		this.menuId = menuId;
	}

	public PedidoMenuMapper(Object[] object) {
		this(Integer.parseInt(object[0].toString()),
				Integer.parseInt(object[1].toString()));
	}
	
	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	
	
	

}
