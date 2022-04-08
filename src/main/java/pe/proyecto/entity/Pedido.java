package pe.proyecto.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Entity
@Table (name="pedidos")
public class Pedido implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pedidoId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fpedido;
	
	@DateTimeFormat(pattern="yyyy-MM-dd",iso=ISO.DATE)
	private LocalDate fenvio;
	
	@Column
	private Integer cantidad;
	
	@Column
	private Double monto;
	
	@ManyToOne
	@JoinColumn(name="cliente_id",nullable=false)
	private Cliente cliente;
	
	
	@ManyToMany
	@JoinTable(name="Pedidos_Menus",
			joinColumns=@JoinColumn(name="pedido_id",nullable=false,
			foreignKey =@ForeignKey(foreignKeyDefinition="foreign key(pedido_id) references pedidos(pedido_id)")),
			
			inverseJoinColumns=@JoinColumn(name="menu_id",nullable=false,
					foreignKey =@ForeignKey(foreignKeyDefinition="foreign key(menu_id) references menus(menu_id)")))
	private Set<Menu> itemsMenu=new HashSet<>();
	

	public Pedido(){
	}

	public Pedido(Integer pedidoId, LocalDate fpedido, LocalDate fenvio, Integer cantidad, Double monto) {
		this.pedidoId = pedidoId;
		this.fpedido = fpedido;
		this.fenvio = fenvio;
		this.cantidad = cantidad;
		this.monto = monto;
	}
	
	public void addMenu(Menu menu) {
		itemsMenu.add(menu);
		menu.getItemsPedido().add(this);
	}
	
	@PrePersist
	public void prePersist() {
		fpedido=LocalDate.now();
	}

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDate getFpedido() {
		return fpedido;
	}

	public void setFpedido(LocalDate fpedido) {
		this.fpedido = fpedido;
	}

	public LocalDate getFenvio() {
		return fenvio;
	}

	public void setFenvio(LocalDate fenvio) {
		this.fenvio = fenvio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Menu> getItemsMenu() {
		return itemsMenu;
	}

	public void setItemsMenu(Set<Menu> itemsMenu) {
		this.itemsMenu = itemsMenu;
	}
	
	
	
}
