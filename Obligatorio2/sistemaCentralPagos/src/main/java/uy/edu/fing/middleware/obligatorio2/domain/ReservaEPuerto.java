
package uy.edu.fing.middleware.obligatorio2.domain;

public class ReservaEPuerto {

	private String idCompra;
	private Long idProducto;
	private Integer cantidad;
	
	
	public String getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	} 
}
