package com.middleware.fing.model;

public class Order {

	private String identificadorCompra;
	private String identificadorProducto;
	private String cantidad;

	
	
	public String getIdentificadorCompra() {
		return identificadorCompra;
	}
	public void setIdentificadorCompra(String identificadorCompra) {
		this.identificadorCompra = identificadorCompra;
	}
	public String getIdentificadorProducto() {
		return identificadorProducto;
	}
	public void setIdentificadorProducto(String identificadorProducto) {
		this.identificadorProducto = identificadorProducto;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	
	@Override
	public String toString() {
		return "Order [identificadorCompra=" + identificadorCompra + ", identificadorProducto=" + identificadorProducto
				+ ", cantidad=" + cantidad + "]";
	}
	


	
}