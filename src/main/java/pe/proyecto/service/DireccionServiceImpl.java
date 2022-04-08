package pe.proyecto.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.proyecto.entity.Direccion;
import pe.proyecto.repository.DireccionRepository;
@Service
public class DireccionServiceImpl implements DireccionService
{
	@Autowired
	private DireccionRepository repository;

	@Override
	@Transactional
	public void insert(Direccion direccion) {
		repository.save(direccion);		
	}

	@Override
	@Transactional
	public void update(Direccion direccion) {
		repository.save(direccion);		
	}

	@Override
	@Transactional
	public void delete(Integer direccionId) {
		repository.deleteById(direccionId);		
	}

	@Override
	@Transactional(readOnly=true)
	public Direccion findById(Integer direccionId) {
		return repository.findById(direccionId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Direccion> findAll() {
		return repository.findAll();
	}

}
