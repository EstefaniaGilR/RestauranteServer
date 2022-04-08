package pe.proyecto.mapper;

import pe.proyecto.entity.Menu;

public class MenuMapper {
	
	private String plato;
	private String mdescripcion;
	
	public MenuMapper() {}
	
	
	
	public MenuMapper(String plato, String mdescripcion) {
		this.plato = plato;
		this.mdescripcion = mdescripcion;
	}



	public MenuMapper(Menu menu) {
		this(menu.getPlato(),
				menu.getMdescripcion());
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

	
}
