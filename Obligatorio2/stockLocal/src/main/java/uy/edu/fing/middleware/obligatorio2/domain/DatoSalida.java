package uy.edu.fing.middleware.obligatorio2.domain;

import java.io.Serializable;

public class DatoSalida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3776172660352020296L;

	private String codigo;
	
	private String descripcion;
	
	private Long idReserva;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	@Override
	public String toString() {
		return "DatoSalida [codigo=" + codigo + ", descripcion=" + descripcion
				+ ", idReserva=" + idReserva + "]";
	}
	
	
	
}
