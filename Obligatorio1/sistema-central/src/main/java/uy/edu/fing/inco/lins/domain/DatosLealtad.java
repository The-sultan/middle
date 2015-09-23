
package uy.edu.fing.inco.lins.domain;

import java.util.Date;

public class DatosLealtad {

	private Long idCliente;
    private String codigoMoneda;
    private Double monto;
    private Date fechaHoraCobro;

    public Long getIdCliente() {
		return idCliente;
	}

    public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public void setCodigoMoneda(String value) {
        this.codigoMoneda = value;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double value) {
        this.monto = value;
    }
    
    public Date getFechaHoraCobro() {
		return fechaHoraCobro;
	}


	public void setFechaHoraCobro(Date fechaHoraCobro) {
		this.fechaHoraCobro = fechaHoraCobro;
	}
}
