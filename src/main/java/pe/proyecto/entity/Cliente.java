package pe.proyecto.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer clienteId;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;	
	
	@Column
	private Integer ctelefono;	
	
	@Column
	private String genero;	
	
	@Column
	private Integer dni;
	
	
	@OneToOne
	@JoinColumn(name="direccion_id",nullable=false,unique=true)
	private Direccion direccion;
	
	@OneToMany(mappedBy="cliente") 
	private Collection<Pedido> itemsPedido=new ArrayList<>();
	

	public Cliente(){
	}

	public Cliente(Integer clienteId, String nombre, String apellidos, Integer ctelefono, String genero, Integer dni) {
		this.clienteId = clienteId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ctelefono = ctelefono;
		this.genero = genero;
		this.dni = dni;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getCtelefono() {
		return ctelefono;
	}

	public void setCtelefono(Integer ctelefono) {
		this.ctelefono = ctelefono;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Collection<Pedido> getItemsPedido() {
		return itemsPedido;
	}

	public void setItemsPedido(Collection<Pedido> itemsPedido) {
		this.itemsPedido = itemsPedido;
	}
	
	
}
