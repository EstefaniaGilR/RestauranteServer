package pe.proyecto.service;

import java.util.Collection;

import pe.proyecto.entity.Direccion;

public interface DireccionService {
	
	public abstract void insert(Direccion direccion);
	public abstract void update(Direccion direccion);
	public abstract void delete(Integer direccionId);
	public abstract Direccion findById(Integer direccionId);
	public abstract Collection<Direccion> findAll();

}
