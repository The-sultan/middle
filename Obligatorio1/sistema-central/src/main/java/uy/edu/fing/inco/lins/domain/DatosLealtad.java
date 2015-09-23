
package uy.edu.fing.inco.lins.domain;

import javax.xml.datatype.XMLGregorianCalendar;

public class DatosLealtad {

	private Long idCliente;
    private String codigoMoneda;
    private double monto;
    private XMLGregorianCalendar fechaHoraCobro;

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

    public double getMonto() {
        return monto;
    }

    public void setMonto(double value) {
        this.monto = value;
    }
    
    public XMLGregorianCalendar getFechaHoraCobro() {
		return fechaHoraCobro;
	}


	public void setFechaHoraCobro(XMLGregorianCalendar fechaHoraCobro) {
		this.fechaHoraCobro = fechaHoraCobro;
	}
}
