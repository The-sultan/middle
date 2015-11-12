package com.middleware.fing.model;

public class OrderResult {

	private String identificadorCompra;
	private String identificadorReserva;
	private Integer codigo;
	private String descripcion;
	
	
	public String getIdentificadorCompra() {
		return identificadorCompra;
	}
	public void setIdentificadorCompra(String identificadorCompra) {
		this.identificadorCompra = identificadorCompra;
	}
	public String getIdentificadorReserva() {
		return identificadorReserva;
	}
	public void setIdentificadorReserva(String identificadorReserva) {
		this.identificadorReserva = identificadorReserva;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
