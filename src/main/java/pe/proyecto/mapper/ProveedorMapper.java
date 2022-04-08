package pe.proyecto.mapper;

import pe.proyecto.entity.Proveedor;

public class ProveedorMapper {
	private Integer proveedorId;
	private String marca;
	private String ptelefono;
	private String pdescripcion;
	
	
	public ProveedorMapper(){
		
	}


	
	public ProveedorMapper(Integer proveedorId, String marca, String ptelefono, String pdescripcion) {
		
		this.proveedorId = proveedorId;
		this.marca = marca;
		this.ptelefono = ptelefono;
		this.pdescripcion = pdescripcion;
	}



	public ProveedorMapper(Proveedor proveedor) {
		this(proveedor.getProveedorId(),
				proveedor.getMarca(),
				proveedor.getPtelefono(),
				proveedor.getPdescripcion());
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
	
}
