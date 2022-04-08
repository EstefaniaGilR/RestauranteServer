package pe.proyecto.util;

import java.util.ArrayList;
import java.util.Collection;

import pe.proyecto.entity.Cliente;
import pe.proyecto.entity.Direccion;
import pe.proyecto.entity.Pedido;
import pe.proyecto.entity.Proveedor;
import pe.proyecto.entity.Menu;
import pe.proyecto.mapper.ClienteMapper;
import pe.proyecto.mapper.DireccionMapper;
import pe.proyecto.mapper.MenuMapper;
import pe.proyecto.mapper.MenuProveedorMapper;
import pe.proyecto.mapper.MenuProveedorTextMapper;
import pe.proyecto.mapper.PedidoMapper;
import pe.proyecto.mapper.PedidoMenuMapper;
import pe.proyecto.mapper.PedidoMenuTextMapper;
import pe.proyecto.mapper.ProveedorMapper;

public class UtilMapper {
	
	public static Collection<DireccionMapper> toDireccion(Collection<Direccion> collection){
		Collection<DireccionMapper> mapper=new ArrayList<>();
		
		for(Direccion direccion:collection) {
			DireccionMapper direccionMapper=new DireccionMapper(direccion);
			mapper.add(direccionMapper);
		}
		return mapper;
	}
	
	public static DireccionMapper toDireccion(Direccion direccion) {
		DireccionMapper mapper = new DireccionMapper(direccion);
		return mapper;
	}
	
	
	public static Collection<ClienteMapper> toCliente(Collection<Cliente> collection){
		Collection<ClienteMapper> mapper=new ArrayList<>();
		
		for(Cliente cliente:collection) {
			ClienteMapper clienteMapper=new ClienteMapper(cliente);
			mapper.add(clienteMapper);
		}
		return mapper;
	}
	
	public static ClienteMapper toCliente(Cliente cliente) {
		ClienteMapper mapper = new ClienteMapper(cliente);
		return mapper;
	}
	

	public static Collection<MenuMapper> toMenu(Collection<Menu> collection){
		Collection<MenuMapper> mapper=new ArrayList<>();
		
		for(Menu menu:collection) {
			MenuMapper menuMapper=new MenuMapper(menu);
			mapper.add(menuMapper);
		}
		return mapper;
	}
	
	public static MenuMapper toMenu(Menu menu) {
		MenuMapper mapper = new MenuMapper(menu);
		return mapper;
	}
	
	
	public static Collection<PedidoMapper> toPedido(Collection<Pedido> collection){
		Collection<PedidoMapper> mapper=new ArrayList<>();
		
		for(Pedido pedido:collection) {
			PedidoMapper pedidoMapper=new PedidoMapper(pedido);
			mapper.add(pedidoMapper);
		}
		return mapper;
	}
	
	public static PedidoMapper toPedido(Pedido pedido) {
		PedidoMapper mapper = new PedidoMapper(pedido);
		return mapper;
	}
	
	
	public static Collection<PedidoMenuMapper> toPedidoMenu(Collection<Object[]> collection)
	{
		Collection<PedidoMenuMapper> mapper=new ArrayList<>();
		
		for(Object[] object:collection) {
			PedidoMenuMapper pedidoMenuMapper=new PedidoMenuMapper(object);
			mapper.add(pedidoMenuMapper);
		}
		
		return mapper;
		
	}
	
	public static Collection<PedidoMenuTextMapper> toPedidoMenuText(Collection<Object[]> collection)
	{
		Collection<PedidoMenuTextMapper> mapper=new ArrayList<>();
		
		for(Object[] object:collection) {
			PedidoMenuTextMapper pedidoMenuTextMapper=new PedidoMenuTextMapper(object);
			mapper.add(pedidoMenuTextMapper);
		}
		
		return mapper;
		
	}
	
	
	
	public static Collection<MenuProveedorMapper> toMenuProveedor(Collection<Object[]> collection)
	{
		Collection<MenuProveedorMapper> mapper=new ArrayList<>();
		
		for(Object[] object:collection) {
			MenuProveedorMapper menuProveedorMapper=new MenuProveedorMapper(object);
			mapper.add(menuProveedorMapper);
		}
		
		return mapper;
		
	}
	
	
	public static Collection<MenuProveedorTextMapper> toMenuProveedorText(Collection<Object[]> collection)
	{
		Collection<MenuProveedorTextMapper> mapper=new ArrayList<>();
		
		for(Object[] object:collection) {
			MenuProveedorTextMapper menuProveedorTextMapper=new MenuProveedorTextMapper(object);
			mapper.add(menuProveedorTextMapper);
		}
		
		return mapper;
		
	}
	
	
	public static Collection<ProveedorMapper> toProveedor(Collection<Proveedor> collection){
		Collection<ProveedorMapper>mapper=new ArrayList<>();
		
		for(Proveedor proveedor:collection) {
			ProveedorMapper proveedorMapper=new ProveedorMapper(proveedor);
			mapper.add(proveedorMapper);
		}
		
		return mapper;
	}
	
	public static ProveedorMapper toProveedor(Proveedor proveedor) {
		ProveedorMapper mapper=new ProveedorMapper(proveedor);
		return mapper;
	}
	
	

}
