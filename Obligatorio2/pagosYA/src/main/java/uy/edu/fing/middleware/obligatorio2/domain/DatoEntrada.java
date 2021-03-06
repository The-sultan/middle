package uy.edu.fing.middleware.obligatorio2.domain;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DatoEntrada")
public class DatoEntrada {
	
	private Long idCompra;
	
	private String nroTarjeta;
	
	private Double monto;
	
	private Date fechaHora;

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public String getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(String nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public String toString() {
		return "DatoEntrada [idCompra=" + idCompra + ", nroTarjeta="
				+ nroTarjeta + ", monto=" + monto + ", fechaHora=" + fechaHora
				+ "]";
	}
	
	
	
	

}
