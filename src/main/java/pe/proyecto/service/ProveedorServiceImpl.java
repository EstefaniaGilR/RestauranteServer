package pe.proyecto.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.proyecto.entity.Proveedor;
import pe.proyecto.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService
{
	@Autowired
	private ProveedorRepository repository;

	@Override
	@Transactional
	public void insert(Proveedor proveedor) {
		repository.save(proveedor);		
	}

	@Override
	@Transactional
	public void update(Proveedor proveedor) {
		repository.save(proveedor);
	}

	@Override
	@Transactional
	public void delete(Integer proveedorId) {
		repository.deleteById(proveedorId);	
	}

	@Override
	@Transactional(readOnly=true)
	public Proveedor findById(Integer proveedorId) {
		return repository.findById(proveedorId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Proveedor> findAll() {
		return repository.findAll();
	}

}
