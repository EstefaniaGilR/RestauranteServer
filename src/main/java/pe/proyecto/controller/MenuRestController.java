package pe.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.proyecto.entity.Menu;
import pe.proyecto.mapper.MenuMapper;
import pe.proyecto.service.MenuService;
import pe.proyecto.util.UtilMapper;

@RestController
@RequestMapping("/menu")
public class MenuRestController {

	@Autowired
	private MenuService menuService;
	
	public MenuRestController() {
		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<MenuMapper> mapper=UtilMapper.toMenu(menuService.findAll());
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	
	}	
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Menu menu){
		menuService.insert(menu);
		return new ResponseEntity<>("Platillo registrado.",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{menuId}")
	public ResponseEntity<?> editar(@RequestBody Menu menuEdit,@PathVariable Integer menuId){
		Menu menuDb=menuService.findById(menuId);
		
		if(menuDb!=null) {
			
			menuDb.setPlato(menuEdit.getPlato());
			menuDb.setMdescripcion(menuEdit.getMdescripcion());
			
			menuService.update(menuDb);
			
			return new ResponseEntity<>("Platillo actualizado.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No existe el platillo.",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{menuId}")
	public ResponseEntity<?> borrar(@PathVariable Integer menuId){
		Menu menuDb= menuService.findById(menuId);
		
		if(menuDb!=null) {
			menuService.delete(menuId);
			return new ResponseEntity<>("Platillo eliminado.",HttpStatus.OK);
		}
		return new ResponseEntity<>("No existe el platillo.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{menuId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer menuId){
		Menu menuDb= menuService.findById(menuId);
		
		if(menuDb!=null) {
				MenuMapper mapper=UtilMapper.toMenu(menuDb);
				return new ResponseEntity<>(mapper,HttpStatus.FOUND);
		}
		return new ResponseEntity<>("No existe el platillo.",HttpStatus.FOUND);
		
	}
	
}
