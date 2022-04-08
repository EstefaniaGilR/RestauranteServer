package pe.proyecto.mapper;

import pe.proyecto.entity.Cliente;

public class ClienteMapper {

	private Integer clienteId;
	private String nombre;
	private String apellidos;
	private Integer ctelefono;
	private String genero;
	private Integer dni;
	private Integer direccionId;
	
	public ClienteMapper() { 
	}
	
	
	public ClienteMapper(Integer clienteId, String nombre, String apellidos, Integer ctelefono, String genero,
			Integer dni, Integer direccionId) {
		this.clienteId = clienteId;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ctelefono = ctelefono;
		this.genero = genero;
		this.dni = dni;
		this.direccionId = direccionId;
	}


	public ClienteMapper(Cliente cliente) {
		this(cliente.getClienteId(),
				cliente.getNombre(),
				cliente.getApellidos(),
				cliente.getCtelefono(),
				cliente.getGenero(),
				cliente.getDni(),
				cliente.getDireccion().getDireccionId());
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


	public Integer getDireccionId() {
		return direccionId;
	}


	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}
	
	
	
}
