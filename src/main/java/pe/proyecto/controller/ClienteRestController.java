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

import pe.proyecto.entity.Cliente;
import pe.proyecto.mapper.ClienteMapper;
import pe.proyecto.service.ClienteService;
import pe.proyecto.util.UtilMapper;

@RestController
@RequestMapping("/cliente")
public class ClienteRestController {

	
	@Autowired
	private ClienteService clienteService;

	
	public ClienteRestController(){
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		
		Collection<ClienteMapper>mapper=UtilMapper.toCliente(clienteService.findAll());
		return new ResponseEntity<>(mapper,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar(@RequestBody Cliente cliente)
	{
		clienteService.insert(cliente);
		return new ResponseEntity<>("Cliente registrado.",HttpStatus.CREATED);
	}
	
	
	@PutMapping("/editar/{clienteId}")
	public ResponseEntity<?> editar(@RequestBody Cliente clienteEdit,@PathVariable Integer clienteId)
	{
		Cliente clienteDb=clienteService.findById(clienteId);
	
		if(clienteDb!=null)
		{
			clienteDb.setNombre(clienteEdit.getNombre());
			clienteDb.setApellidos(clienteEdit.getApellidos());
			clienteDb.setCtelefono(clienteEdit.getCtelefono());
			clienteDb.setGenero(clienteEdit.getGenero());
			clienteDb.setDni(clienteEdit.getDni());
			clienteDb.setDireccion(clienteEdit.getDireccion());
	
		clienteService.update(clienteDb);
		return new ResponseEntity<>("Cliente actualizado.",HttpStatus.OK);
		}
	
		return new ResponseEntity<>("Cliente no existe.",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{clienteId}")
	public ResponseEntity<?> borrar(@PathVariable Integer clienteId){
		
		Cliente clienteDb= clienteService.findById(clienteId);
		
		if(clienteDb!=null) {
			clienteService.delete(clienteId);
			return new ResponseEntity<>("Cliente eliminado.",HttpStatus.OK);
		}

		return new ResponseEntity<>("Cliente no existe.",HttpStatus.NOT_FOUND);
	}
	
	
	@GetMapping("/buscar/{clienteId}")
	public ResponseEntity<?> buscar(@PathVariable Integer clienteId){
		
		Cliente clienteDb= clienteService.findById(clienteId);
		
		if(clienteDb!=null) {
			ClienteMapper mapper=UtilMapper.toCliente(clienteDb);
			return new ResponseEntity<>(mapper,HttpStatus.FOUND);
		}

		return new ResponseEntity<>("Cliente no existe.",HttpStatus.NOT_FOUND);
	}
	
	
	
}
