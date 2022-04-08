package pe.proyecto.mapper;

import pe.proyecto.entity.Direccion;

public class DireccionMapper {
	
	private Integer direccionId;
	private String ciudad;
	private String distrito;
	
	public DireccionMapper() {	
	}
	
	public DireccionMapper(Integer direccionId, String ciudad, String distrito) {
		this.direccionId = direccionId;
		this.ciudad = ciudad;
		this.distrito = distrito;
	}

	public DireccionMapper(Direccion direccion) {
		this(direccion.getDireccionId(),
				direccion.getCiudad(),
				direccion.getDistrito());
	}

	public Integer getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(Integer direccionId) {
		this.direccionId = direccionId;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	

}
