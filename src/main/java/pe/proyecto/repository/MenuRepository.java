package pe.proyecto.repository;

import pe.proyecto.entity.Menu;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<Menu, Integer>{
	
	@Query(value="select * from menus_proveedores order by menu_id;",nativeQuery=true)
	public abstract Collection<Object[]> findAll_withProveedor();
	
	@Query(value="select m.plato as 'Platillo', pr.marca as 'Marca' from menus_proveedores mp inner join menus m on mp.menu_id=m.menu_id inner join proveedores pr on mp.proveedor_id=pr.proveedor_id order by m.menu_id;\r\n"
			+ "",nativeQuery=true)
	public abstract Collection<Object[]> findAll_withProveedorText();
}
