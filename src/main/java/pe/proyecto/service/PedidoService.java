package pe.proyecto.service;

import java.util.Collection;

import pe.proyecto.entity.Pedido;

public interface PedidoService {

	public abstract void insert(Pedido pedido);
	public abstract void update(Pedido pedido);
	public abstract void delete(Integer pedidoId);
	public abstract Pedido findById(Integer pedidoId);
	public abstract Collection<Pedido> findAll();
	
	public abstract Collection<Object[]> findAll_withMenu();
	
	public abstract Collection<Object[]> findAll_withMenuText();
}
