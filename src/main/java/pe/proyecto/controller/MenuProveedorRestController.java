package pe.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.proyecto.entity.Menu;
import pe.proyecto.entity.MenuProveedor;
import pe.proyecto.entity.Proveedor;
import pe.proyecto.mapper.MenuProveedorMapper;
import pe.proyecto.mapper.MenuProveedorTextMapper;
import pe.proyecto.service.MenuService;
import pe.proyecto.service.ProveedorService;
import pe.proyecto.util.UtilMapper;

@RestController
@RequestMapping("/menu_proveedor")
public class MenuProveedorRestController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private ProveedorService proveedorService;
	
	public MenuProveedorRestController() {}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<MenuProveedorMapper> mapper=
				UtilMapper.toMenuProveedor(menuService.findAll_withProveedor());
				
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	}
	
	@GetMapping("/listar_text")
	public ResponseEntity<?> listarText_GET(){
		Collection<MenuProveedorTextMapper> mapper=
				UtilMapper.toMenuProveedorText(menuService.findAll_withProveedorText());
				
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	}
	
	
	@PutMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody MenuProveedor menuProveedor){
		Menu menuDb = menuService.findById(menuProveedor.getMenu().getMenuId());
		
		if(menuDb!=null) {
			Proveedor proveedorDb=proveedorService.findById(menuProveedor.getProveedor().getProveedorId());
			if(proveedorDb!=null) {
				
				menuDb.addProveedor(proveedorDb);
				menuService.insert(menuDb);
				
				return new ResponseEntity<>("Menu proveedor registrado.",HttpStatus.CREATED);
			}
			
			return new ResponseEntity<>("Proveedor no existe.",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("Menu proveedor no existe.",HttpStatus.NOT_FOUND);
	}
}
