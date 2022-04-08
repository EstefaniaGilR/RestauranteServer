package pe.proyecto.mapper;

public class MenuProveedorTextMapper {
	
	private String menu;
	private String proveedor;
	
	public MenuProveedorTextMapper(String menu, String proveedor) {
		this.menu = menu;
		this.proveedor = proveedor;
	}
	
	public MenuProveedorTextMapper(Object[] object) {
		this(object[0].toString(),
				object[1].toString());
	}
	
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	
	

}
