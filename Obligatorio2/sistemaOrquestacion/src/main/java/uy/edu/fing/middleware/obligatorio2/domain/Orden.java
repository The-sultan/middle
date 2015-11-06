package uy.edu.fing.middleware.obligatorio2.domain;

import java.util.List;

public class Orden {
	
	private String idCompra;
	
	private Long nroTarjeta;
	
	private List<Item> productos;

	public String getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}

	public Long getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(Long nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public List<Item> getProductos() {
		return productos;
	}

	public void setProductos(List<Item> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Orden [idCompra=" + idCompra + ", nroTarjeta=" + nroTarjeta
				+ ", productos=" + productos + "]";
	}

	
}
