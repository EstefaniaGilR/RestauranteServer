package pe.proyecto.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.proyecto.entity.Pedido;
import pe.proyecto.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService
{
	@Autowired
	private PedidoRepository repository;

	@Override
	@Transactional
	public void insert(Pedido pedido) {
		repository.save(pedido);	}

	@Override
	@Transactional
	public void update(Pedido pedido) {
		repository.save(pedido);
	}

	@Override
	@Transactional
	public void delete(Integer pedidoId) {
		repository.deleteById(pedidoId);		
	}

	@Override
	@Transactional(readOnly=true)
	public Pedido findById(Integer pedidoId) {
		return repository.findById(pedidoId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Pedido> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Object[]> findAll_withMenu(){
		return repository.findAll_withMenu();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Object[]> findAll_withMenuText(){
		return repository.findAll_withMenuText();
	}

}
