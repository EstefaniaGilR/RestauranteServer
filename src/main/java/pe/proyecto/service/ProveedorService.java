package pe.proyecto.service;

import java.util.Collection;

import pe.proyecto.entity.Proveedor;

public interface ProveedorService {
	
	public abstract void insert(Proveedor proveedor);
	public abstract void update(Proveedor proveedor);
	public abstract void delete(Integer proveedorId);
	public abstract Proveedor findById(Integer proveedorId);
	public abstract Collection<Proveedor> findAll();

}
