package pe.proyecto.entity;

import java.io.Serializable;
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
import javax.persistence.Table;


@Entity
@Table(name="menus")
public class Menu implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer menuId;
	
	@Column
	private String plato;
	
	@Column
	private String mdescripcion;
	
	
	@ManyToMany(mappedBy="itemsMenu") 
	private Set<Pedido> itemsPedido = new HashSet<>();
	
	
	@ManyToMany
	@JoinTable(name="Menus_Proveedores",
			joinColumns=@JoinColumn(name="menu_id",nullable=false,
			foreignKey =@ForeignKey(foreignKeyDefinition="foreign key(menu_id) references menus(menu_id)")),
			
			inverseJoinColumns=@JoinColumn(name="proveedor_id",nullable=false,
					foreignKey =@ForeignKey(foreignKeyDefinition="foreign key(proveedor_id) references proveedores(proveedor_id)")))
	private Set<Proveedor> itemsProveedor=new HashSet<>();

	public Menu(){
	}

	public Menu(Integer menuId, String plato, String mdescripcion) {
		this.menuId = menuId;
		this.plato = plato;
		this.mdescripcion = mdescripcion;
	}
	
	public void addProveedor(Proveedor proveedor) {
		itemsProveedor.add(proveedor);
		proveedor.getItemsMenu().add(this);
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getPlato() {
		return plato;
	}

	public void setPlato(String plato) {
		this.plato = plato;
	}

	public String getMdescripcion() {
		return mdescripcion;
	}

	public void setMdescripcion(String mdescripcion) {
		this.mdescripcion = mdescripcion;
	}
	

	public Set<Pedido> getItemsPedido() {
		return itemsPedido;
	}

	public void setItemsPedido(Set<Pedido> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}
	
	

	public Set<Proveedor> getItemsProveedor() {
		return itemsProveedor;
	}

	public void setItemsProveedor(Set<Proveedor> itemsProveedor) {
		this.itemsProveedor = itemsProveedor;
	}
	
	
}
