package uy.edu.fing.middleware.obligatorio2.domain;

import java.io.Serializable;

public class DatoReserva implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5909600860348343984L;

	private Long idProducto;
	
	private Integer cantidad;

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

	@Override
	public String toString() {
		return "DatoReserva [idProducto=" + idProducto + ", cantidad="
				+ cantidad + "]";
	}
	
	
}
