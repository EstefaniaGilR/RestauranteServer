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
import pe.proyecto.entity.Pedido;
import pe.proyecto.entity.PedidoMenu;
import pe.proyecto.mapper.PedidoMenuMapper;
import pe.proyecto.mapper.PedidoMenuTextMapper;
import pe.proyecto.service.MenuService;
import pe.proyecto.service.PedidoService;
import pe.proyecto.util.UtilMapper;


@RestController
@RequestMapping("/pedido_menu")
public class PedidoMenuRestController {

	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private MenuService menuService;

	
	public PedidoMenuRestController (){
	}
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar_GET(){
		Collection<PedidoMenuMapper> mapper=
				UtilMapper.toPedidoMenu(pedidoService.findAll_withMenu());
				
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	}
	
	@GetMapping("/listar_text")
	public ResponseEntity<?> listarText_GET(){
		Collection<PedidoMenuTextMapper> mapper=
				UtilMapper.toPedidoMenuText(pedidoService.findAll_withMenuText());
				
		return new ResponseEntity<>(mapper,HttpStatus.OK);
	}
	
	@PutMapping("/registrar")
	public ResponseEntity<?> registrar_POST(@RequestBody PedidoMenu pedidoMenu){
		Pedido pedidoDb = pedidoService.findById(pedidoMenu.getPedido().getPedidoId());
		
		if(pedidoDb!=null) {
			Menu menuDb=menuService.findById(pedidoMenu.getMenu().getMenuId());
			if(menuDb!=null) {
				
				pedidoDb.addMenu(menuDb);
				pedidoService.insert(pedidoDb);
				
				return new ResponseEntity<>("Pedido menu registrado.",HttpStatus.CREATED);
			}
			
			return new ResponseEntity<>("Menu no existe.",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>("Pedido menu no existe.",HttpStatus.NOT_FOUND);
	}
	
}
