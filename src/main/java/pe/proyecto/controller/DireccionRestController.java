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

import pe.proyecto.entity.Direccion;
import pe.proyecto.mapper.DireccionMapper;
import pe.proyecto.service.DireccionService;
import pe.proyecto.util.UtilMapper;

@RestController
@RequestMapping("/direccion")
public class DireccionRestController {
	
	@Autowired
	private DireccionService direccionService;
	
	public DireccionRestController() {
	}
	
	
	@GetMapping("/listar") 
	public ResponseEntity<?> Listar(){
		
		Collection<DireccionMapper> mapper = UtilMapper.toDireccion(direccionService.findAll());
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Direccion direccion){
		direccionService.insert(direccion);
		return new ResponseEntity<>("Direccion registrada.",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{direccionId}")
	public ResponseEntity<?> editar(@RequestBody Direccion direccionEdit,@PathVariable Integer direccionId)
	{
		Direccion direccionDb=direccionService.findById(direccionId);

		if(direccionDb!=null) {
			direccionDb.setCiudad(direccionEdit.getCiudad());
			direccionDb.setDistrito(direccionEdit.getDistrito());
			
			direccionService.update(direccionDb);
		return new ResponseEntity<>("Direccion actualizanda.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Direccion no existe.",HttpStatus.OK);
	}
	
	@DeleteMapping("/borrar/{direccionId}")
	public ResponseEntity<?> borrar(@PathVariable Integer direccionId){
		Direccion direccionDb=direccionService.findById(direccionId);
		
		if(direccionDb!=null) {
			direccionService.delete(direccionId);
			return new ResponseEntity<>("Direccion eliminada",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("Direccion no existe.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{direccionId}")
	public ResponseEntity<?> buscar(@PathVariable Integer direccionId){
		Direccion direccionDb=direccionService.findById(direccionId);
		
		if(direccionDb!=null) {
			DireccionMapper mapper=UtilMapper.toDireccion(direccionDb);
			return new ResponseEntity<>(mapper,HttpStatus.FOUND);
		}
		return new ResponseEntity<>("Direccion no existe.",HttpStatus.NOT_FOUND);
	}

	

}
