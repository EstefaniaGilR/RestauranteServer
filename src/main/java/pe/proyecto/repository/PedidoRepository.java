package pe.proyecto.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.proyecto.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

	@Query(value="select * from pedidos_menus order by pedido_id;",nativeQuery=true)
	public abstract Collection<Object[]> findAll_withMenu();
	
	@Query(value="select pe.pedido_id as 'Id Pedido', m.plato as 'Platillo' from pedidos_menus pm inner join pedidos pe on pm.pedido_id=pe.pedido_id inner join menus m on pm.menu_id=m.menu_id order by pe.pedido_id;\r\n"
			+ "",nativeQuery=true)
	public abstract Collection<Object[]> findAll_withMenuText();
}
