package pe.proyecto.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.proyecto.entity.Menu;
import pe.proyecto.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService
{
	@Autowired
	private MenuRepository repository;

	@Override
	@Transactional
	public void insert(Menu menu) {
		repository.save(menu);		
	}

	@Override
	@Transactional
	public void update(Menu menu) {
		repository.save(menu);		
	}

	@Override
	@Transactional
	public void delete(Integer menuId) {
		repository.deleteById(menuId);		
	}

	@Override
	@Transactional(readOnly=true)
	public Menu findById(Integer menuId) {
		return repository.findById(menuId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Menu> findAll() {
		return repository.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Object[]> findAll_withProveedor(){
		return repository.findAll_withProveedor();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Object[]> findAll_withProveedorText(){
		return repository.findAll_withProveedorText();
	}

}
