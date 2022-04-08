package pe.proyecto.service;

import java.util.Collection;

import pe.proyecto.entity.Menu;

public interface MenuService {
	
	public abstract void insert(Menu menu);
	public abstract void update(Menu menu);
	public abstract void delete(Integer menuId);
	public abstract Menu findById(Integer menuId);
	public abstract Collection<Menu> findAll();
	
	public abstract Collection<Object[]> findAll_withProveedor();
	
	public abstract Collection<Object[]> findAll_withProveedorText();

}
