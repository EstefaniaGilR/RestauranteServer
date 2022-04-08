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

import pe.proyecto.entity.Pedido;
import pe.proyecto.mapper.PedidoMapper;
import pe.proyecto.service.PedidoService;
import pe.proyecto.util.UtilMapper;

@RestController
@RequestMapping("/pedido")
public class PedidoRestController {
	

	@Autowired
	private PedidoService pedidoService;
	
	public PedidoRestController() {
		
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> Listar_GET(){
		Collection<PedidoMapper> mapper=UtilMapper.toPedido(pedidoService.findAll());
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	
	}	
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody Pedido pedido){
		pedidoService.insert(pedido);
		return new ResponseEntity<>("Pedido registrado.",HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{pedidoId}")
	public ResponseEntity<?> editar(@RequestBody Pedido pedidoEdit,@PathVariable Integer pedidoId){
		Pedido pedidoDb=pedidoService.findById(pedidoId);
		
		if(pedidoDb!=null) {
			
			pedidoDb.setFenvio(pedidoEdit.getFenvio());
			pedidoDb.setCantidad(pedidoEdit.getCantidad());
			pedidoDb.setMonto(pedidoEdit.getMonto());
			pedidoDb.setCliente(pedidoEdit.getCliente());
			
			pedidoService.update(pedidoDb);
			
			return new ResponseEntity<>("Pedido actualizado.",HttpStatus.OK);
		}
		
		return new ResponseEntity<>("El pedido no existe.",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{pedidoId}")
	public ResponseEntity<?> borrar(@PathVariable Integer pedidoId){
		Pedido pedidoDb= pedidoService.findById(pedidoId);
		
		if(pedidoDb!=null) {
			pedidoService.delete(pedidoId);
			return new ResponseEntity<>("Pedido eliminado.",HttpStatus.OK);
		}
		return new ResponseEntity<>("No existe el pedido.",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/buscar/{pedidoId}")
	public ResponseEntity<?> buscar_GET(@PathVariable Integer pedidoId){
		Pedido pedidoDb= pedidoService.findById(pedidoId);
		
		if(pedidoDb!=null) {
				PedidoMapper mapper=UtilMapper.toPedido(pedidoDb);
				return new ResponseEntity<>(mapper,HttpStatus.FOUND);
		}
		return new ResponseEntity<>("El pedido no existe.",HttpStatus.FOUND);
		
	}
	
	 

}
