package uy.edu.fing.middleware.obligatorio2.domain;

public class Item {
	
	private Long idProducto;
	
	private Integer cantidad;
	
	private Double precioUnitario;

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

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "Item [idProducto=" + idProducto + ", cantidad=" + cantidad
				+ ", precioUnitario=" + precioUnitario + "]";
	}
	
	
	

}
