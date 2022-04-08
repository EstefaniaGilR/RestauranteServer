package pe.proyecto.mapper;

public class MenuProveedorMapper {
	
	private Integer menuId;
	private Integer proveedorId;
	
	public MenuProveedorMapper(Integer menuId, Integer proveedorId) {
		this.menuId = menuId;
		this.proveedorId = proveedorId;
	}
	
	public MenuProveedorMapper(Object[] object) {
		this(Integer.parseInt(object[0].toString()),
				Integer.parseInt(object[1].toString()));
	}
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public Integer getProveedorId() {
		return proveedorId;
	}
	public void setProveedorId(Integer proveedorId) {
		this.proveedorId = proveedorId;
	}

	
	
}
