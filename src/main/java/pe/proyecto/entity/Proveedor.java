package pe.proyecto.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="proveedores")
public class Proveedor implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer proveedorId;
	
	@Column
	private String marca;
	
	@Column
	private String ptelefono;
	
	@Column
	private String pdescripcion;
	
	@ManyToMany(mappedBy="itemsProveedor")
	private Set<Menu> itemsMenu = new HashSet<>();
	

	public Proveedor(){
	}

	public Proveedor(Integer proveedorId, String marca, String ptelefono, String pdescripcion) {
		this.proveedorId = proveedorId;
		this.marca = marca;
		this.ptelefono = ptelefono;
		this.pdescripcion = pdescripcion;
	}

	public Integer getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(Integer proveedorId) {
		this.proveedorId = proveedorId;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPtelefono() {
		return ptelefono;
	}

	public void setPtelefono(String ptelefono) {
		this.ptelefono = ptelefono;
	}

	public String getPdescripcion() {
		return pdescripcion;
	}

	public void setPdescripcion(String pdescripcion) {
		this.pdescripcion = pdescripcion;
	}

	public Set<Menu> getItemsMenu() {
		return itemsMenu;
	}

	public void setItemsMenu(Set<Menu> itemsMenu) {
		this.itemsMenu = itemsMenu;
	}

	
	
}
