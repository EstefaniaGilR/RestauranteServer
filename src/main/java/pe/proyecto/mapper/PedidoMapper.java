package pe.proyecto.mapper;

import java.time.LocalDate;

import pe.proyecto.entity.Pedido;

public class PedidoMapper {
	
	private LocalDate fpedido;
	private LocalDate fenvio;
	private Integer cantidad;
	private Double monto;
	private String cliente;

	public PedidoMapper() {}
	
	




	public PedidoMapper(LocalDate fpedido, LocalDate fenvio, Integer cantidad, Double monto, String cliente) {
		super();
		this.fpedido = fpedido;
		this.fenvio = fenvio;
		this.cantidad = cantidad;
		this.monto = monto;
		this.cliente = cliente;
	}




	public PedidoMapper(Pedido pedido) {
		this(pedido.getFpedido(),
				pedido.getFenvio(),
				pedido.getCantidad(),
				pedido.getMonto(),
				pedido.getCliente().getNombre()
		);
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






	public String getCliente() {
		return cliente;
	}






	public void setCliente(String cliente) {
		this.cliente = cliente;
	}



	
}
