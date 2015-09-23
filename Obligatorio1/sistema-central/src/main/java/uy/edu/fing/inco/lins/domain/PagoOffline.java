
package uy.edu.fing.inco.lins.domain;

import java.util.Date;

public class PagoOffline {

	private long identificadorCliente;
	private String codigoMoneda;
	private double monto;
	private Date fechaCobro;
	private Date horaCobro;

	public long getIdentificadorCliente() {
		return identificadorCliente;
	}

	public void setIdentificadorCliente(long identificadorCliente) {
		this.identificadorCliente = identificadorCliente;
	}

	public String getCodigoMoneda() {
		return codigoMoneda;
	}

	public void setCodigoMoneda(String codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFechaCobro() {
		return fechaCobro;
	}

	public void setFechaCobro(Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public Date getHoraCobro() {
		return horaCobro;
	}

	public void setHoraCobro(Date horaCobro) {
		this.horaCobro = horaCobro;
	}

}
